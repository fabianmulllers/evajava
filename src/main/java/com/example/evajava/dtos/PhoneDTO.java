package com.example.evajava.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
	
	
	private Long idPhone;
	
	private UUID idUser;
	
	private String numero;
	
	private String codigoCiudad;
	
	private String codigoPais;
}
