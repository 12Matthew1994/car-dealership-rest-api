package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    @NotNull
    @JsonProperty("_id")
    private long id;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotNull
    private Integer year;
    @NotNull
    private Integer weight;
    @NotNull
    private Integer km;
    @NotNull
    private long carDealerShipId;

    private boolean isAvailable;

    private String dateAdded;
    @JsonProperty("isAvailable")
    public boolean isAvailable(){
        return isAvailable;
    }
}
