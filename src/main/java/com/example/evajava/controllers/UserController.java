package com.example.evajava.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evajava.entities.UserEntity;
import com.example.evajava.services.IUserService;
import com.example.evajava.utils.UserCustomRequest;
import com.example.evajava.utils.UserCustomResponse;
import com.example.evajava.utils.UserCustomResponseAll;
import com.example.evajava.utils.UserCustomUpdateRequest;
import com.example.evajava.utils.UtilsController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController implements IUserController{

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UtilsController utils;
	
	
	@Override
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserCustomRequest user){
		Map<String, Object> response = new HashMap<>();
		try {

			if(userService.validateCorreo(user.getCorreo())){
				response.put("mensaje", "El correo ya está registrado");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CONFLICT);
			}
			
			if(!utils.validatePassword(user.getPassword())) {
				response.put("mensaje", "La password no cumple con lo requerido");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}
			
			UserCustomResponse respuesta = userService.createUser(user);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    
	@Override
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id) {
		Map<String, Object> response = new HashMap<>();
		try {

			Boolean respuesta = userService.eliminarUser(id);
			if(respuesta) {
				response.put("mensaje", "No se pudo eliminar!");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "Eliminado con exito !");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
    @PutMapping("/update")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserCustomUpdateRequest user) {
		Map<String, Object> response = new HashMap<>();
		try {
			UserEntity userEntity = userService.getUser(user.getId());
			if( userEntity == null) {
				response.put("mensaje", "Usuario no encontrado");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}

			if(userService.validateCorreoUpdate(user.getCorreo(), user.getId())){
				response.put("mensaje", "El correo ya está registrado");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CONFLICT);
			}
			
			if(!utils.validatePassword(user.getPassword())) {
				response.put("mensaje", "La password no cumple con lo requerido");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}
			
			UserCustomResponse respuesta = userService.updateUser(user, userEntity);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
    @PatchMapping("/desactivar/{id}")
	public ResponseEntity<?> desactivar(@PathVariable("id") UUID id) {
		Map<String, Object> response = new HashMap<>();
		try {
			UserEntity usuario = userService.getUser(id);
			if(usuario == null) {
				response.put("mensaje", "Usuario no encontrado");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}
			
			UserEntity user = userService.desactivarUsuario(usuario);
			response.put("mensaje", "Desactivado con exito !");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@GetMapping("/")
	public ResponseEntity<?> getAllUser(){
		try {
			List<UserCustomResponseAll> listUser = userService.getAllUser();
			return new ResponseEntity<>(listUser, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
	
	
    
}
