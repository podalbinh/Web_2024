package com.ltweb.onlinetest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendRegistrationConfirmationEmail(String to, String name, String confirmationLink) {
        sendEmail(to, name, confirmationLink, "Confirm Registration", "confirm-registration");
    }

    public void sendPasswordResetEmail(String to, String name, String resetLink) {
        sendEmail(to, name, resetLink, "Password Reset Request", "reset-password");
    }
    @Async
    private void sendEmail(String to, String name, String link, String subject, String templateName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,"utf-8");
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);

            // Thymeleaf Context
            Context context = new Context();
            context.setVariable("name", name);
            context.setVariable("link", link);

            // Generate mail content using Thymeleaf template
            String html = templateEngine.process(templateName, context);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to send email");
        }
    }
}