package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Admin;

import java.util.List;

public interface Adminserevice {
    Admin newAdmin(Admin admin);
    Admin deleteAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    List<Admin> getAdminList();
}
