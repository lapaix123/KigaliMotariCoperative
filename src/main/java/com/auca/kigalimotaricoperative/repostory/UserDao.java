package com.auca.kigalimotaricoperative.repostory;

import com.auca.kigalimotaricoperative.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
