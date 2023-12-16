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
    private MotariDao motariRepository;

    // CRUD operations for Motari entity

    public Motari createMotari(Motari motari) {
        return motariRepository.save(motari);
    }

    public Optional<Motari> getMotariById(String motariId) {
        return motariRepository.findById(motariId);
    }

    public List<Motari> getAllMotaris() {
        return motariRepository.findAll();
    }

    public void updateMotari(Motari motari) {
        motariRepository.save(motari);
    }

    public void deleteMotari(String motariId) {
        motariRepository.deleteById(motariId);
    }
}
