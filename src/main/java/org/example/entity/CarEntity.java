package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "cars")
@Getter
@Setter
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false)
    private Integer km;

    private boolean isAvailable;

    private Date dateAdded = new Date();

    @ManyToOne
    @JoinColumn(name = "carDealerShip_id")
    private CarDealerShipEntity carDealerShip;
}
