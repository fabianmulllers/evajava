package com.example.evajava.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evajava.services.IPasswordService;
import com.example.evajava.utils.PasswordRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/password")
public class PasswordController implements IPasswordController{

	private final Logger logger = LoggerFactory.getLogger(PasswordController.class);
	
	@Autowired
	private IPasswordService passwordService;
	
	@Override
	@PostMapping("/save")
	public ResponseEntity<?> saveExpression(@Valid @RequestBody PasswordRequest password) {
		Map<String, Object> response = new HashMap<>();
		try {
			passwordService.update(password.getExpresion());
			response.put("mensaje", "expresion modificada con exito");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
