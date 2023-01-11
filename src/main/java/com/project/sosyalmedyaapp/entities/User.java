package com.project.sosyalmedyaapp.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue
	Long id;
    
    String userName;
    String password;
    String avatarUrl;
    String status;
    String accessToken;
    String email;
    String message;


	public User(Long id, String userName, String password, String avatarUrl,String status, String accessToken,String email,String message) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.avatarUrl = avatarUrl;
		this.status = status;
		this.accessToken = accessToken;
		this.email = email;
		this.message = message;
	
	}

	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	};
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	};
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	};

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
