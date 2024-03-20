package com.example.evajava.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private UUID idUser;
	
	private String nombre;
	
	private List<PhoneDTO> telefonos;
	
	private String correo;
	
	private String password;
	
	private Date dateCreated;
	
	private Date dateUpdated;
	
	private Date lastLogin;
	
	private Boolean active;
	
}
