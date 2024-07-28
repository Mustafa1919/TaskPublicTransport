package com.dw.entity;

import com.dw.enums.TYPE;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleId;

    @NotBlank(message = "Plaka Alanı Boş Olamaz")
    @Column(unique = true)
    private String plateNumber;
    @Enumerated(EnumType.STRING)
    private TYPE type;
    @Min(value = 0, message = "Kapasite Negatif Olamaz")
    private int capacity;

    public Vehicle(String plateNumber, TYPE type, int capacity) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.capacity = capacity;
    }
}
