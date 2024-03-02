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
public class CarDealerShipDTO {

    @JsonProperty("_id")
    private long id;
    @NotBlank
    private String city;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String street;
    @NotNull
    private int number;

}
