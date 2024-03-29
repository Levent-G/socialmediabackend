 package com.project.sosyalmedyaapp.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sosyalmedyaapp.entities.User;

import com.project.sosyalmedyaapp.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	//USERS START->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser)throws NoSuchAlgorithmException {
		return userService.saveOneUser(newUser);
	}
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		
		return userService.getOneUserById(userId);
	}
	
	@GetMapping("/search/{userName}")
	public User getOneUsername(@PathVariable String userName) {
		
		return userService.getOneUserByUserName(userName);
	}
	@GetMapping("/token/{accessToken}")
	public User getOneUserToken(@PathVariable String accessToken) {
		
		return userService.getOneUserByToken(accessToken);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser)throws NoSuchAlgorithmException {
return userService.updateOneUser(userId,newUser);
	
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
		
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User loginUser)throws NoSuchAlgorithmException {
		return userService.loginUserService(loginUser);
	}
	
	@PutMapping("/logout/{userId}")
	public User updateStatus(@PathVariable Long userId) {
         return userService.updateStatus(userId);
	}
	

	//USERS END->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<
	
	//USER AUTHORIZATION START->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<
	
	//USER AUTHORIZATION END->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<
}
