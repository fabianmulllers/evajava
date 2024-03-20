package com.example.evajava.services;

import java.util.List;
import java.util.UUID;

import com.example.evajava.entities.UserEntity;
import com.example.evajava.utils.UserCustomRequest;
import com.example.evajava.utils.UserCustomResponse;
import com.example.evajava.utils.UserCustomResponseAll;
import com.example.evajava.utils.UserCustomUpdateRequest;

public interface IUserService {
	
	public UserEntity getUser(UUID id);
	
	public UserCustomResponse createUser(UserCustomRequest user);
	
	public UserCustomResponse updateUser(UserCustomUpdateRequest user, UserEntity userEntity);
	
	public List<UserCustomResponseAll> getAllUser();
	
	public Boolean eliminarUser(UUID id);
	
	public Boolean validateCorreo(String correo);
	
	public Boolean validateCorreoUpdate(String correo, UUID id);
	
	public UserEntity desactivarUsuario(UserEntity user);
	
}
