package com.project.sosyalmedyaapp.services;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

	public User saveOneUser(User newUser) throws NoSuchAlgorithmException{
	
	
		PasswordHashing passwordHashingClass = new PasswordHashing();
		Optional<User> user = userRepository.findByEmail(newUser.getEmail()); 
		Optional<User> user2 = userRepository.findByUserName(newUser.getUserName());
		 String hashedPassword = hashPassword(newUser.getPassword());
		
		if(!user.isPresent()&& !user2.isPresent()) {
		      newUser.setPassword( hashedPassword);	       
	           newUser.setAccessToken(passwordHashingClass.saltValueAdd(15));
			return userRepository.save(newUser);
		}else {
			return null;
		}
           

	}
	private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

	public User getOneUserById(Long userId) {
	
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser)throws NoSuchAlgorithmException {
		


		Optional<User> userToBeEdited = userRepository.findById(userId);
		
		User foundUser = userToBeEdited.get();	
		
		if(userToBeEdited.isPresent()) {
			if(newUser.getUserName() != null) {
				   foundUser.setUserName(newUser.getUserName());
				
			}else {
				foundUser.setUserName(foundUser.getUserName());
			} if(newUser.getEmail() != null){
			    foundUser.setEmail(newUser.getEmail());
			  
			}else {
				foundUser.setEmail(foundUser.getEmail());
			} if(newUser.getAvatarUrl() != null){
				   foundUser.setAvatarUrl(newUser.getAvatarUrl());
				 
			}else {
				foundUser.setAvatarUrl(foundUser.getAvatarUrl());
			}if(newUser.getMessage() != null){
			    foundUser.setMessage(newUser.getMessage());
			
			}
			else {
				foundUser.setMessage(foundUser.getMessage());
				
			}if(newUser.getPassword() != null){
				 String hashedPassword = hashPassword(newUser.getPassword());
			    foundUser.setPassword(hashedPassword);
			
			}
			else {
				foundUser.setPassword(foundUser.getPassword());
			}
		    userRepository.save(foundUser);
		    return foundUser;
			  
				
			
				
				  
		
		  
		}else {
			return null;
		}
		
		
	
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
		
	}

	public User loginUserService(User loginUser)throws NoSuchAlgorithmException {
		
		Optional<User> existingUser = userRepository.findByEmail(loginUser.getEmail());
		User foundUser = existingUser.get();	
		if(!existingUser.isPresent()) {
			return null ;
		}
		if(!verifyPassword(loginUser.getPassword(), foundUser.getPassword())) {
			return null ;
		}
			
				
					  Long userId= foundUser.getId();		    
			    	   foundUser.setStatus("ok");		    	  
			    	  userRepository.save(foundUser);
			    	  return userRepository.findById(userId).orElse(null);
						     		    
			    		    		  
							 							
	
	}
	  public boolean verifyPassword(String plainPassword, String hashedPassword) throws NoSuchAlgorithmException {
	        String newHashedPassword = hashPassword(plainPassword);
	        return newHashedPassword.equals(hashedPassword);
	    }

	public User updateStatus(Long userId) {
		Optional<User> user = userRepository.findById(userId); 	
		if(user.isPresent()) {
			User foundUser = user.get();	
		    foundUser.setStatus(null);
		    
		    userRepository.save(foundUser);
		    return foundUser;
		}else
			return null;
	}

	public User getOneUserByToken(String accessToken) {
		return userRepository.findByAccessToken(accessToken).orElse(null);
	}

	public User getOneUserByUserName(String userName) {
		return userRepository.findByUserName(userName).orElse(null);
	}
	


	
	
}
