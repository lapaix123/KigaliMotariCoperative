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

    public Optional<Admin> getAdminById(Integer adminId) {
        return dao.findById(adminId);
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
}
