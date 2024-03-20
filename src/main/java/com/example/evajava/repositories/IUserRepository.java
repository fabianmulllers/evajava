package com.example.evajava.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.evajava.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,UUID> {
	
	 UserEntity findByCorreo(String correo);
	 
	 @Query("SELECT u FROM UserEntity u WHERE u.correo = :correo AND u.id != :id")
     List<UserEntity> findByCorreoExcludingId(@Param("correo") String correo, @Param("id") UUID id);
}
