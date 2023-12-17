package com.auca.kigalimotaricoperative.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Motari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer motariId;
    private String plateNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    @OneToOne(mappedBy = "motari")
    private User user;
    @OneToMany(mappedBy = "motari")
    private   List<Imisanzu> imisanzus;
}
