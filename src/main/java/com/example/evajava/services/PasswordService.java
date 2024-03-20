package com.example.evajava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evajava.entities.PasswordEntity;
import com.example.evajava.repositories.IPasswordRepository;

@Service
public class PasswordService implements IPasswordService {

	@Autowired
	IPasswordRepository passwordRepository;
	
	@Override
	public PasswordEntity update(String expression) {
		PasswordEntity password = new PasswordEntity();
		password.setExpression(expression);
		password.setId(1l);
		PasswordEntity passwordSave = passwordRepository.save(password);
		return passwordSave;
	}

	@Override
	public PasswordEntity getPassword(Long id) {
		return passwordRepository.findById(id).orElse(null);
	}

}
