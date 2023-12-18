package com.auca.kigalimotaricoperative.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Imisanzu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imisanzuId;
    private Double amount;
    private LocalDate imisanzuDate;
    @ManyToOne
    @JoinColumn(name="motariId")
    private Motari motari;

    @PrePersist
    public void prePersist() {
        this.imisanzuDate = LocalDate.now();
    }
}
