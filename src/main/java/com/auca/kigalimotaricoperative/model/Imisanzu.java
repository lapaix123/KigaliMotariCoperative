package com.auca.kigalimotaricoperative.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Imisanzu {
    @Id
    private Integer imisanzuId;
    private Double amount;
    private LocalDate imisanzuDate;
    @ManyToOne
    @JoinColumn(name="motariId")
    private Motari motari;
}
