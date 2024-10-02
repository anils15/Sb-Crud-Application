package com.cts.service;

import java.util.List;

import com.cts.dto.UserDto;
import com.cts.entity.User;

public interface UserService {

	public User saveUser(UserDto user);

	public List<User> getAllUser();

	public User getUserById(long userId);

	public User updateUser(long userId, UserDto userDto);

	public void delete(long userId);
	
	public List<User> getUsersByName(String name);
	
	public List<User> getUserByNameAndAge(String name, int age);
	
	public List<User> getforPagenation(int pageNumber, int pageSize);
	
	public List<User> getUsersByNameAndEmail(String name, String email);
	
	public List<User> getAgeGreaterThanEqual(int age);
	
	public List<User> getUsersNameStartingWith(String name);
	
}
