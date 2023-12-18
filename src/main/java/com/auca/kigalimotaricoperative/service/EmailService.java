package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Motari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Motari motari) {

        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(motari.getEmail());
        message.setSubject("Motari registration");
        message.setText( "Dear " + motari.getFirstName() + " " + motari.getLastName() + ",\n\n"
                + "Welcome to the Motari Management System!\n\n"
                + "Congratulations on successfully registering as a Motari.\n"
                + "Here are your registration details:\n"
                + "   - Motari ID: " + motari.getMotariId() + "\n"
                + "   - Name: " + motari.getFirstName() + " " + motari.getLastName() + "\n"
                + "   - Phone Number: " + motari.getPhone() + "\n\n"
                + "You are now part of our Motari community. If you have any questions or need assistance, feel free to reach out.\n\n"
                + "Thank you for choosing Motari Management System!\n\n"
                + "Best regards,\n"
                + "The Motari Management Team");
        javaMailSender.send(message);

    }
}
