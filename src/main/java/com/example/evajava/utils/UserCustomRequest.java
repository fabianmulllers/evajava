package com.example.evajava.utils;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCustomRequest {

	@NotBlank(message = "El nombre no puede estar vacío")
	@Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = "El nombre solo puede contener letras")
	private String nombre;
	
	@NotBlank(message = "El correo no puede estar vacío")
    @Pattern(regexp = "^((mailto:)?[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})?$", message = "El correo debe tener un formato válido")
	private String correo;
	
	private String password;
	
	private List<PhoneCustomRequest> telefonos;
	
}
