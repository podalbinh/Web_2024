package com.ltweb.onlinetest.restcontrollers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltweb.onlinetest.entities.ERole;
import com.ltweb.onlinetest.entities.Role;
import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.jwt.JwtTokenProvider;
import com.ltweb.onlinetest.payload.request.SignInRequest;
import com.ltweb.onlinetest.payload.request.SignUpRequest;
import com.ltweb.onlinetest.payload.response.JwtResponse;
import com.ltweb.onlinetest.payload.response.MessageResponse;
import com.ltweb.onlinetest.security.AuthService;
import com.ltweb.onlinetest.security.CustomUserDetails;
import com.ltweb.onlinetest.services.EmailService;
import com.ltweb.onlinetest.services.RoleService;
import com.ltweb.onlinetest.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.media.EmailSchema;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthControllers {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenPovider;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthService authService;
    @Autowired
    private EmailService emailService;
    @Operation(summary = "Sign Up" )
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username is already"));
        }
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email is already"));
        }
        
        User user = new User();
        user.setUserStatus(false);
        String token = UUID.randomUUID().toString();
        user.setConfirmationToken(token);
        user.setConfirmationTokenExpiration(LocalDateTime.now().plusMinutes(15)); // Token expires after 15 minutes


        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setPhone(signUpRequest.getPhone());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNow = new Date();
        String strNow = sdf.format(dateNow);
        try {
            user.setCreated(sdf.parse(strNow));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<String> roles = signUpRequest.getListRoles();
        Set<Role> listRoles = new HashSet<>();
        if (roles == null) {
            // User quyen mac dinh
            Role userRoles = roleService.findByRoleName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Role is not found"));
            listRoles.add(userRoles);
        } else {
            roles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRoles = roleService.findByRoleName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Role is not found"));
                        listRoles.add(adminRoles);
                        break;
                    case "moderator":
                        Role modRoles = roleService.findByRoleName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Role is not found"));
                        listRoles.add(modRoles);
                        break;
                    case "user":
                        Role userRoles = roleService.findByRoleName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Role is not found"));
                        listRoles.add(userRoles);
                        break;
                }
            });
        }
        user.setListRoles(listRoles);

        String link = "http://localhost:8081/api/v1/auth/confirm?token=" + token;
        userService.saveOrUpdate(user);
        emailService.sendRegistrationConfirmationEmail(signUpRequest.getEmail(),signUpRequest.getUsername(),link);
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }
    @Operation(summary = "Sign In")
    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody SignInRequest SignInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(SignInRequest.getUsername(), SignInRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = tokenPovider.generateToken(customUserDetails);
        List<String> listRoles = customUserDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, customUserDetails.getUsername(),listRoles));
    }
    @Operation(summary = "Log Out")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')  or hasRole('ROLE_USER')")
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        SecurityContextHolder.clearContext();
       return ResponseEntity.ok("Logout Success!!!");
    }
    @GetMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestParam("token") String token) {
        authService.confirmUser(token);
        return ResponseEntity.ok("Confirm");
    }

}
