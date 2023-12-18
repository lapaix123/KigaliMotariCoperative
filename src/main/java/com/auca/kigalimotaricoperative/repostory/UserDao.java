package com.auca.kigalimotaricoperative.repostory;

import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query("from User where motari.email=:email and password=:password")
    Optional<User> findByEmailAndPassword(String email, String password);

    @Query("from User where motari.motariId=:id")
    User findByMotari(Integer id);
}
