package org.example.entity.filter;

import lombok.Data;

@Data
public class MotorbikeFilter {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private Integer km;
    private Integer weight;
    private Integer limit = 10;
}
