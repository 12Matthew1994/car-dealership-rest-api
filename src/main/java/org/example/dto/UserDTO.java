package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @JsonProperty("_id")
    private long userId;

    @Email
    private String email;

    @NotBlank(message = "Enter the user password")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String password;

    @JsonProperty("isAdmin")
    private boolean admin;
}
