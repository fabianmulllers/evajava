package com.example.evajava.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evajava.entities.PasswordEntity;
import com.example.evajava.services.PasswordService;

@Service
public class UtilsController {
	
    @Autowired
    private PasswordService passwordService;

	public UUID generateUUID() {
		return UUID.randomUUID();
	}

	public Boolean validatePassword(String password) {
		String PASSWORD_PATTERN =  "^(?=.*[0-9])(?=.*[a-zA-Z]).{5,10}$";
		PasswordEntity passwordEntity = passwordService.getPassword(1l);
		
		if(passwordEntity != null) {
			PASSWORD_PATTERN = passwordEntity.getExpression().trim();
		}
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);	
		Matcher matcher = pattern.matcher(password);
        return matcher.matches();
	}
}
