package com.example.evajava.utils;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomResponse {

	private UUID id;
	
	private Date creado;
	
	private Date modificado;
	
	private Date ultimoLogin;
	
	private Boolean activo;
}
