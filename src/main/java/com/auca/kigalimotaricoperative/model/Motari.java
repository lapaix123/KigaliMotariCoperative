package com.auca.kigalimotaricoperative.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Motari {
    @Id
    private String motariId;
    private String plateNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    @OneToOne(mappedBy = "motari")
    private User user;
    @OneToMany(mappedBy = "motari")
    private   List<Imisanzu> imisanzus;
}
