package com.example.evajava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evajava.entities.PhoneEntity;
import com.example.evajava.entities.UserEntity;
import com.example.evajava.repositories.IPhoneRepository;
import com.example.evajava.repositories.IUserRepository;
import com.example.evajava.utils.PhoneCustomRequest;
import com.example.evajava.utils.PhoneCustomUpdateRequest;
import com.example.evajava.utils.UtilsController;
import com.example.evajava.utils.UserCustomRequest;
import com.example.evajava.utils.UserCustomResponse;
import com.example.evajava.utils.UserCustomResponseAll;
import com.example.evajava.utils.UserCustomUpdateRequest;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IPhoneRepository phoneRepository;
	
	@Override
	public UserCustomResponse createUser(UserCustomRequest user) {
		
	    // Guardamos el usuario
	    UtilsController uuidGenerate = new UtilsController();
	    UserEntity userEntity = new UserEntity();     
	    userEntity.setIdUser(uuidGenerate.generateUUID());
	    userEntity.setNombre(user.getNombre());
	    userEntity.setCorreo(user.getCorreo());
	    userEntity.setPassword(user.getPassword());

	    // Guardamos los telefonos
	    List<PhoneCustomRequest> listPhoneCR = user.getTelefonos();
	    List<PhoneEntity> phoneEntities = new ArrayList<>();
	    for(PhoneCustomRequest pcr : listPhoneCR) {
	        PhoneEntity phoneEntity = new PhoneEntity();
	        phoneEntity.setIdUser(userEntity.getIdUser()); // Establecer la relación unidireccional
	        phoneEntity.setNumero(pcr.getNumero());
	        phoneEntity.setCodigoPais(pcr.getCodigoPais());
	        phoneEntity.setCodigoCiudad(pcr.getCodigoCiudad());
	        phoneEntities.add(phoneEntity);
	    }

	    // Guardar los telefonos
	    phoneRepository.saveAll(phoneEntities);

	    // Guardar el usuario
	    UserEntity usuarioSave = userRepository.save(userEntity);

	    UserCustomResponse userCR = new UserCustomResponse();
	    userCR.setId(usuarioSave.getIdUser());
	    userCR.setCreado(usuarioSave.getDateCreated());
	    userCR.setModificado(usuarioSave.getDateUpdated());
	    userCR.setUltimoLogin(usuarioSave.getLastLogin());
	    userCR.setActivo(usuarioSave.getActive());
	    return userCR;
	}
	
	@Override
	public UserCustomResponse updateUser(UserCustomUpdateRequest user) {
		
	    // Guardamos el usuario
	    UserEntity userEntity = new UserEntity();     
	    userEntity.setIdUser(user.getId());
	    userEntity.setNombre(user.getNombre());
	    userEntity.setCorreo(user.getCorreo());
	    userEntity.setPassword(user.getPassword());

	    // Guardamos los telefonos
	    List<PhoneCustomUpdateRequest> listPhoneCR = user.getTelefonos();
	    List<PhoneEntity> phoneEntities = new ArrayList<>();
	    for(PhoneCustomUpdateRequest pcr : listPhoneCR) {
	        PhoneEntity phoneEntity = new PhoneEntity();
	        phoneEntity.setIdPhone(pcr.getId());
	        phoneEntity.setNumero(pcr.getNumero());
	        phoneEntity.setIdUser(userEntity.getIdUser());
	        phoneEntity.setCodigoPais(pcr.getCodigoPais());
	        phoneEntity.setCodigoCiudad(pcr.getCodigoCiudad());
	        phoneEntities.add(phoneEntity);
	    }

	    // Guardar los telefonos
	    phoneRepository.saveAll(phoneEntities);

	    // Guardar el usuario
	    UserEntity usuarioSave = userRepository.save(userEntity);

	    UserCustomResponse userCR = new UserCustomResponse();
	    userCR.setId(usuarioSave.getIdUser());
	    userCR.setCreado(usuarioSave.getDateCreated());
	    userCR.setModificado(usuarioSave.getDateUpdated());
	    userCR.setUltimoLogin(usuarioSave.getLastLogin());
	    userCR.setActivo(usuarioSave.getActive());
	    return userCR;
	}

	@Override
	public UserEntity getUser(UUID id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public Boolean validateCorreo(String correo) {
		Boolean respuesta = false;
		if(userRepository.findByCorreo(correo.trim()) != null) {
			respuesta = true;
		}
		return respuesta;
	}
	
	@Override
	public Boolean validateCorreoUpdate(String correo, UUID id) {
		Boolean respuesta = false;
		if(userRepository.findByCorreoExcludingId(correo.trim(), id).size() > 0 ) {
			respuesta = true;
		}
		return respuesta;
	}

	@Override
	public List<UserCustomResponseAll> getAllUser() {
		List<UserEntity> listUserEntity = userRepository.findAll();
		List<UserCustomResponseAll> listUserCustom = new ArrayList<>();
		
		for(UserEntity user: listUserEntity) {
			UserCustomResponseAll userResponse = new UserCustomResponseAll();
			userResponse.setId(user.getIdUser());
			userResponse.setNombre(user.getNombre());
			userResponse.setCorreo(user.getCorreo());
			userResponse.setTelefonos(user.getTelefonos());
			userResponse.setDateCreated(user.getDateCreated());
			userResponse.setDateUpdated(user.getDateUpdated());
			userResponse.setLastLogin(user.getLastLogin());
			userResponse.setActive(user.getActive());
			listUserCustom.add(userResponse);
		}
		
		return listUserCustom;
	}

	@Override
	public Boolean eliminarUser(UUID id) {
	    userRepository.deleteById(id);
	    return userRepository.existsById(id);
	}

	@Override
	public UserEntity desactivarUsuario(UserEntity user) {
		user.setActive(false);
		return userRepository.save(user);
	}

}
