package com.example.evajava.utils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.evajava.entities.PhoneEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomResponseAll {

	private UUID id;
	
	private String nombre;
	
	private String correo;
	
	private List<PhoneEntity> telefonos;
	
	private Date dateCreated;
	
	private Date dateUpdated;
	
	private Date lastLogin;
	
	private Boolean active;
	
}
