package com.example.evajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evajava.entities.PasswordEntity;

@Repository
public interface IPasswordRepository extends JpaRepository<PasswordEntity, Long>{
	
}
