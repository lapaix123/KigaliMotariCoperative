package com.auca.kigalimotaricoperative.repostory;

import com.auca.kigalimotaricoperative.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByEmailAndPassword( String email,String password);
}
