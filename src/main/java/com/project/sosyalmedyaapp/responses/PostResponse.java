package com.project.sosyalmedyaapp.responses;

import java.sql.Date;

import com.project.sosyalmedyaapp.entities.Post;

public class PostResponse {

	Long id;
	Long userId;
	String userName;
	String title;
	String text;
	String avatarUrl;
	Date createdAt;
	public PostResponse(Post entity ) {
		
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.title = entity.getTitle();
		this.text = entity.getText();
		this.avatarUrl = entity.getUser().getAvatarUrl();
		this.createdAt = entity.getCreatedAt();
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt=createdAt;
	}
}
