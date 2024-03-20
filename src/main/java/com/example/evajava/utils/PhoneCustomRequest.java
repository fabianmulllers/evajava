package com.example.evajava.utils;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneCustomRequest {

	@NotBlank(message = "El numero no puede estar vacío")
	private String numero;
	
	@NotBlank(message = "El codigo ciudad no puede estar vacío")
	private String codigoCiudad;
	
	@NotBlank(message = "El codigo pais no puede estar vacío")
	private String codigoPais;
}
