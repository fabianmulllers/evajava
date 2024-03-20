package com.example.evajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evajava.entities.PhoneEntity;

@Repository
public interface IPhoneRepository extends JpaRepository<PhoneEntity, Long>{

}
