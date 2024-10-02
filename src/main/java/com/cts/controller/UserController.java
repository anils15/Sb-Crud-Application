package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.UserDto;
import com.cts.entity.User;
import com.cts.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger logger =LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping(value = "/save")
	public User saveUser( @Valid @RequestBody UserDto user) {
		logger.info("UserController-saveUser()method execution started: {}", user.getName() );
		return userService.saveUser(user);
	}

	@GetMapping(value = "/getUser")
	public List<User> getAllUser() {
		logger.info("UserController-getAllUser()method execution started");
		return userService.getAllUser();
	}

	@GetMapping(value = "/{userId}")
	public User getUserById(@PathVariable Long userId) {
		logger.info("UserController-getUserById()method execution started: {}", userId );
		return userService.getUserById(userId);
	}

	@PutMapping(value = "updateUser/{userId}")
	public User updateUser(@PathVariable long userId, @RequestBody UserDto dto) {
		logger.info("UserController-updateUser()method execution started: {}", userId );
		return userService.updateUser(userId, dto);
	}

	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable long userId) {
		logger.info("UserController-delete()method execution started: {}", userId);
		userService.delete(userId);
	}
	
	@GetMapping("/getByName")
	public List<User> getUsersByName(@ RequestParam String name){
		return userService.getUsersByName(name);
	}
	
	@GetMapping("/byNameAndAge")
	public List<User> getUserByNameAndAge(@RequestParam String name, @RequestParam int age){
		return userService.getUserByNameAndAge(name, age);
	}
	
	@GetMapping("/pagenation")
	public List<User> getforPagenation(@RequestParam int pageNumber, @RequestParam int pageSize){
		return userService.getforPagenation(pageNumber, pageSize);
	}
	
	@GetMapping("/byNameAndEmail")
	public List<User> getUsersByNameAndEmail(String name, String email){
		return userService.getUsersByNameAndEmail(name, email);
	}
	
	@GetMapping("/byAge")
	public List<User> getAgeGreaterThanEqual(int age) {
		return userService.getAgeGreaterThanEqual(age);
	}
	
	@GetMapping("/nameStartsWith")
	public List<User> getUsersNameStartingWith(String name){
		return userService.getUsersNameStartingWith(name);
	}
}
