package com.project.sosyalmedyaapp.entities;

import java.sql.Date;

import javax.persistence.*;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {

	@Id
	@GeneratedValue
	Long id;
	  
    
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	User user;
	
	Date createdAt;
	String title;
	@Lob
	@Column(columnDefinition="text")
	String text;

	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	

	
}
