package org.example.entity.filter;

import lombok.Data;

@Data
public class CarFilter {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private Integer km;
    private Integer weight;
    private Integer limit = 10;
}
