package com.auca.kigalimotaricoperative.repostory;

import com.auca.kigalimotaricoperative.model.Motari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotariDao extends JpaRepository<Motari,Integer> {
    @Query("from Motari where email =:email")
    Motari findByEmail(String email);
}
