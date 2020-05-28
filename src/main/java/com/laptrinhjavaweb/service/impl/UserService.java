package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired	
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<UserDTO> res= new ArrayList<>();
		
		List<UserEntity> entities= userRepository.findAll(pageable).getContent();
		for(UserEntity obj:entities) {
			UserDTO userDTO= new UserDTO();
			userDTO= userConverter.toDto(obj);
			res.add(userDTO);
		}
		return res;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) userRepository.count();
	}

	@Override
	public UserDTO findById(long id) {
		// TODO Auto-generated method stub
		UserDTO res= new UserDTO();
		res=userConverter.toDto(userRepository.findOne(id)) ;
		return res;
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity userEntity=userConverter.toEntity(dto);
		if(dto.getId() != null) {
			userEntity=userRepository.findOne(dto.getId());
		}
		userEntity.setFullName(dto.getFullName());
		userEntity.setUserName(dto.getUserName());
		userEntity.setStatus(dto.getStatus());
	
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long id:ids) {
			userRepository.delete(id);
		}
		
	}
}
