package com.example.evajava.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PasswordEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5195901530258417127L;
	
	@Id
	private Long id;
	
	private String expression;
	
}
