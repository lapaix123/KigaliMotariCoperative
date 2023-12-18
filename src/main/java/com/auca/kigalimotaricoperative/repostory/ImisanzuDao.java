package com.auca.kigalimotaricoperative.repostory;

import com.auca.kigalimotaricoperative.model.Imisanzu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImisanzuDao extends JpaRepository<Imisanzu,Integer> {

    @Query("from User where motari.motariId=:id")
    List<Imisanzu> findIminzuByMotari(Integer id);
}
