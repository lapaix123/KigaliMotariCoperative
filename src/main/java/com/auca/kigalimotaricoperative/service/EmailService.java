package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Motari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(Motari motari) {

        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(customer.getEmail());
        message.setSubject("payment of Ticket");
        message.setText("hello "+"  "+customer.getNames() +"  with phone number "+customer.getPhone()+"welcome to online Ticket Manegment System ");
        javaMailSender.send(message);

    }
}
