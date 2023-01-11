package com.project.sosyalmedyaapp.responses;

import com.project.sosyalmedyaapp.entities.Comment;


import lombok.Data;

@Data
public class CommentResponse {
	Long id;
	Long userId;
	Long postId;
	String text;
	String avatarUrl;
	String userName;
	
public CommentResponse(Comment entity ) {
		
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.avatarUrl = entity.getUser().getAvatarUrl();
		this.userName = entity.getUser().getUserName();
	    this.postId = entity.getPost().getId();
		this.text = entity.getText();
	
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public Long getPostId() {
	return postId;
}

public void setPostId(Long postId) {
	this.postId = postId;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public String getAvatarUrl() {
	return avatarUrl;
}

public void setAvatarUrl(String avatarUrl) {
	this.avatarUrl = avatarUrl;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}




}
