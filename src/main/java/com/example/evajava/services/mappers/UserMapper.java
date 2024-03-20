package com.example.evajava.services.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.evajava.dtos.UserDTO;
import com.example.evajava.entities.UserEntity;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserEntity userDTOToUserEntity(UserDTO userDTO);
	
	UserDTO userEntityToUserDTO(UserEntity userEntity);
	
	List<UserDTO> listUserEntityToListUserDTO(List<UserEntity> userEntity);
	
	List<UserEntity> listUserDTOToListUserEntity(List<UserDTO> userDTO);
}
