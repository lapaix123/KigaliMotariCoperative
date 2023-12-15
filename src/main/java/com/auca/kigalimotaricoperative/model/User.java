package com.auca.kigalimotaricoperative.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @OneToOne
    @JoinColumn(name="motariId")
    private Motari motari;
    private String password;
}
