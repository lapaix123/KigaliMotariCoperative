package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.repostory.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminDao dao;

    // CRUD operations for Admin entity

    public Admin createAdmin(Admin admin) {
        return dao.save(admin);
    }

    public Admin getAdminById(Integer adminId) {
        return dao.findById(adminId).get();
    }

    public List<Admin> getAllAdmins() {
        return dao.findAll();
    }

    public void updateAdmin(Admin admin) {
        dao.save(admin);
    }

    public void deleteAdmin(Integer adminId) {
       dao.deleteById(adminId);
    }
    // Admin login method
    public Optional<Admin> loginAdmin(String email, String password) {
        // Implement your logic to authenticate admin
        // For example, you can check if the provided credentials match an admin in the database
        // and return the authenticated admin if successful
        return dao.findByEmailAndPassword(email, password);
    }
}
