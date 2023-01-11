package com.project.sosyalmedyaapp.services;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.project.sosyalmedyaapp.entities.User;
import com.project.sosyalmedyaapp.repos.UserRepository;

import security.PasswordHashing;



@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
	
		String passwordToHash = newUser.getPassword();
		Boolean  hashingControl = false;
		PasswordHashing passwordHashingClass = new PasswordHashing();
		Optional<User> user = userRepository.findByEmail(newUser.getEmail()); 
		Optional<User> user2 = userRepository.findByUserName(newUser.getUserName());
		if(!user.isPresent()&& !user2.isPresent()) {
		      newUser.setPassword( passwordHashingClass.passwordHashing(passwordToHash, hashingControl));	       
	           newUser.setAccessToken(passwordHashingClass.saltValueGet());
			return userRepository.save(newUser);
		}else {
			return null;
		}
           

	}

	public User getOneUserById(Long userId) {
	
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
		


		Optional<User> userToBeEdited = userRepository.findById(userId);
		
		User foundUser = userToBeEdited.get();	
		
		if(userToBeEdited.isPresent()) {
		    
			      foundUser.setUserName(newUser.getUserName());
				    foundUser.setAvatarUrl(newUser.getAvatarUrl());
				    foundUser.setEmail(newUser.getEmail());
				    foundUser.setMessage(newUser.getMessage());
				    userRepository.save(foundUser);
				    return foundUser;
		
		  
		}else {
			return null;
		}
		
		
	
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
		
	}

	public User loginUserService(User loginUser) {
		Optional<User> user = userRepository.findByEmail(loginUser.getEmail()); 
	 
		User foundUser = user.get();
		PasswordHashing passwordHashingClass = new PasswordHashing();	
		Boolean status = passwordHashingClass.Deneme(loginUser.getPassword(), foundUser.getPassword(), foundUser.getAccessToken());
			
			if(user.isPresent()) {
				if(status) {
					  Long userId= foundUser.getId();		    
			    	   foundUser.setStatus("ok");		    	  
			    	  userRepository.save(foundUser);
			    	  return userRepository.findById(userId).orElse(null);
				}else {return null;}
			       
			    
			    		    		  
			}else return null;
				 
				
	
		
		
	
	}

	public User updateStatus(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId); 	
		if(user.isPresent()) {
			User foundUser = user.get();	
		    foundUser.setStatus(null);
		    
		    userRepository.save(foundUser);
		    return foundUser;
		}else
			return null;
	}
	


	
	
}
