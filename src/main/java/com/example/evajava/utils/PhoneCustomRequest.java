package com.example.evajava.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneCustomRequest {

	private String numero;
	
	private String codigoCiudad;
	
	private String codigoPais;
}
