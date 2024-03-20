package com.example.evajava.services;

import com.example.evajava.entities.PasswordEntity;

public interface IPasswordService {

	public PasswordEntity update(String expression);
	
	public PasswordEntity getPassword(Long id);
}
