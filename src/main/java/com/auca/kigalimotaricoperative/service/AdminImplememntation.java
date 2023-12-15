package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Admin;
import com.auca.kigalimotaricoperative.repostory.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminImplememntation implements Adminserevice{
    @Autowired
    private AdminDao dao;
    @Override
    public Admin newAdmin(Admin admin) {
        return dao.save(admin);
    }

    @Override
    public Admin deleteAdmin(Admin admin) {
        return null;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> getAdminList() {
        return dao.findAll();
    }
}
