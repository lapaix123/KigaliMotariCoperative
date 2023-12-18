package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.repostory.MotariDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotariService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private MotariDao motariRepository;

    // CRUD operations for Motari entity

    public Motari createMotari(Motari motari) {
      Motari motari1=   motariRepository.save(motari);
      if(motari1 != null){
          emailService.sendEmail(motari1);
      }
        return motari1;
    }

    public Motari getMotariById(Integer motariId) {
        try{
            return motariRepository.findById(motariId).get();
        }catch (Exception e){
            return null;
        }

    }

    public  List<Motari> getAllMotaris() {
        return motariRepository.findAll();
    }

    public void updateMotari(Motari motari) {
        motariRepository.save(motari);
    }

    public void deleteMotari(Integer motariId) {
        motariRepository.deleteById(motariId);
    }

    public Motari findByEmail(String email) {
        return motariRepository.findByEmail(email);

    }
}
