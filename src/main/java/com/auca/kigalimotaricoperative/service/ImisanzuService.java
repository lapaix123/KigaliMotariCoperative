package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Imisanzu;
import com.auca.kigalimotaricoperative.repostory.ImisanzuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImisanzuService {
    @Autowired
    private ImisanzuDao imisanzuRepository;

    // CRUD operations for Imisanzu entity

    public Imisanzu createImisanzu(Imisanzu imisanzu) {
        return imisanzuRepository.save(imisanzu);
    }

    public Imisanzu getImisanzuById(Integer imisanzuId) {
        return imisanzuRepository.findById(imisanzuId).get();
    }

    public List<Imisanzu> getAllImisanzus() {
        return imisanzuRepository.findAll();
    }

    public void updateImisanzu(Imisanzu imisanzu) {
        imisanzuRepository.save(imisanzu);
    }

    public void deleteImisanzu(Integer imisanzuId) {
        imisanzuRepository.deleteById(imisanzuId);
    }

    public List<Imisanzu> findImisanzuByMotari(Integer motariId) {
      return  imisanzuRepository.findIminzuByMotari(motariId);
    }
}
