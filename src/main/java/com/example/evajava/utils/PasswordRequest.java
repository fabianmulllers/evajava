package com.example.evajava.utils;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data	
public class PasswordRequest {

	@NotBlank(message = "El expresion no puede estar vacío")
	String expresion;
}
