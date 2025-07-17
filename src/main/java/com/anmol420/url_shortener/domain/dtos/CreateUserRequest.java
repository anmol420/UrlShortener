package com.anmol420.url_shortener.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotBlank(message = "Username is Required")
    @Size(min = 2, message = "Username Too Small")
    @Size(max = 30, message = "Username Too Big")
    private String username;

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 6, message = "Password Too Small")
    @Size(max = 30, message = "Password Too Big")
    private String password;
}
