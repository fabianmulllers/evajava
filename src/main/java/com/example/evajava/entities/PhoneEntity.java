package com.example.evajava.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhone;
	
	 private UUID idUser; // Columna para almacenar el ID del usuario
	
	private String numero;
	
	private String codigoCiudad;
	
	private String codigoPais;
	
}
