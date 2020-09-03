package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		UserDTO res = new UserDTO();
		res.setUserName(entity.getUserName());
		res.setFullName(entity.getFullName());
		res.setId(entity.getId());
		res.setStatus(entity.getStatus());
		res.setPassWord(entity.getPassword());
		
		return res;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity res= new UserEntity();
		res.setFullName(dto.getFullName());
		res.setStatus(dto.getStatus());
		res.setUserName(dto.getUserName());
		res.setPassword(dto.getPassWord());
		return res;
	}
	
}
