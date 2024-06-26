package com.ltweb.onlinetest.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ltweb.onlinetest.entities.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Query("SELECT u FROM User u WHERE " +
    "u.username LIKE CONCAT('%',:query, '%')")
    List<User> searchUser(String query);
    // Optional<User> findByUsernameAndProviderId(String username, String providerId);
    User findByConfirmationToken(String token);
    void deleteAllByUserStatusFalseAndConfirmationTokenExpirationBefore(LocalDateTime now);
    Boolean existsByUsernameAndUserStatusTrue(String username);
    Boolean existsByEmailAndUserStatusTrue(String email);
    void deleteAllByUserStatusFalseAndUsername(String username);
    User findByUsernameAndUserStatusTrue(String username);
}