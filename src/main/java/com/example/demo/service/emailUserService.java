/*package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.emailModel;
import com.example.demo.repository.email;

@Service
public class emailUserService {

	
	@Autowired
    private email emailRepo;

    @Autowired
    private EmailService emailService;

    public void forgotPassword(String email) {
        Optional<emailModel> userOptional = emailRepo.findByEmail(email);
        if (userOptional.isPresent()) {
        	emailModel user = userOptional.get();
            String token = UUID.randomUUID().toString();
            user.setResetToken(token);
            emailRepo.save(user);
            emailService.sendResetEmail(user.getEmail(), token);
        }
    }

    public emailModel findUserByResetToken(String token) {
        return emailRepo.findByResetToken(token).orElseThrow(() -> 
            new RuntimeException("Invalid reset token")
        );
    }

    public void updatePassword(emailModel user, String newPassword) {
        user.setPassword(newPassword); // Hash this password before saving in real implementation
        user.setResetToken(null);
        emailRepo.save(user);
    }
}*/
