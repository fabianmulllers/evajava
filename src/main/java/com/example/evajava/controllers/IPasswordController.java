package com.example.evajava.controllers;

import org.springframework.http.ResponseEntity;

import com.example.evajava.utils.PasswordRequest;

public interface IPasswordController {

	public ResponseEntity<?> saveExpression(PasswordRequest password);
}
