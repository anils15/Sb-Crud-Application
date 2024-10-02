package com.cts.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	
	@NotNull(message = "Name should not be empty")
	@Size(min = 4, max = 10, message = "Please Enter More than 4 chars")
	private String name;

	private String email;

	@Max(40)
	@Min(25)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}
