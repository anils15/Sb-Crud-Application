package com.cts.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.cts.dto.UserDto;
import com.cts.entity.User;
import com.cts.exception.UserException;
import com.cts.repository.UserRepository;
import com.cts.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	Logger logger= LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(UserDto userDto) {
		User user=new User();
		logger.info("UserServiceImpl-saveUser()method execution started: {}", userDto.getName());
		BeanUtils.copyProperties(userDto, user);
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		List<User> user = new ArrayList<>();
		logger.info("UserServiceImpl-getAllUser()method execution started: {}");
		user = userRepository.findAll();
		if (!user.isEmpty()) {
			return user;
		} else {
			logger.error("Error while Pulling the User details: {}");
			throw new UserException("User does not exist");
		}
	}

	@Override
	public User getUserById(long userId) {
		Optional<User> user = userRepository.findById(userId);
		logger.info("UserServiceImpl-getUserById()method execution started: {}",userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserException("User does not exist with given id :" + userId);
		}
	}

	@Override
	public User updateUser(long userId, UserDto userDto) {
		logger.info("Update User data in UserServiceImpl");
		User user = getUserById(userId);
		user.setAge(userDto.getAge());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		return saveUser(userDto);
	}

	@Override
	public void delete(long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public List<User> getUsersByName(String name) {
		//return userRepository.findByName(name);
		//Pageable pageable=PageRequest.of(0, 2);
		//return userRepository.findByNameContains(name,pageable);
		return userRepository.getUserByName(name);
	}

	@Override
	public List<User> getUserByNameAndAge(String name, int age) {
		return userRepository.findByNameAndAge(name,age);
		}

	@Override
	public List<User> getforPagenation(int pageNumber, int pageSize) {
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		return userRepository.findAll(pageable).getContent();
	}
	
	@Override
	public List<User> getUsersByNameAndEmail(String name, String email) {
		//return userRepository.findByNameContainsOrEmailContainsOrderByNameDesc(name, email);
		return userRepository.findByNameContainsAndEmailOrderByNameDesc(name, email);
	}

	@Override
	public List<User> getAgeGreaterThanEqual(int age) {
		return userRepository.findByAgeGreaterThanEqual(age);
		//return userRepository.findByAgeIn(age);
	}
	
	public List<User> getUsersNameStartingWith(String name){
		return userRepository.findByNameStartingWith(name);
	}
}
