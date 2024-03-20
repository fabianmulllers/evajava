package com.example.evajava.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.evajava.utils.UserCustomRequest;
import com.example.evajava.utils.UserCustomUpdateRequest;

public interface IUserController {
	
	
	public ResponseEntity<?> getAllUser();
	
	public ResponseEntity<?> saveUser(UserCustomRequest user);
	
	public ResponseEntity<?> deleteUser(UUID id);

	public ResponseEntity<?> updateUser(UserCustomUpdateRequest user);
	
	public ResponseEntity<?> desactivar(UUID id);
}
