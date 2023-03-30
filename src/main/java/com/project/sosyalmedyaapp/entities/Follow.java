package com.project.sosyalmedyaapp.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="follow")
@Data
public class Follow {
	@Id
	@GeneratedValue
	Long id;
	
	
   Long takipEdilen;
	
	Long takipEden;
	
	String status;

	public Follow(Long id, Long takipEdilen, Long takipEden, String status) {
		super();
		this.id = id;
		this.takipEdilen = takipEdilen;
		this.takipEden = takipEden;
		this.status = status;
	}
	public Follow() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTakipEdilen() {
		return takipEdilen;
	}
	public void setTakipEdilen(Long takipEdilen) {
		this.takipEdilen = takipEdilen;
	}
	public Long getTakipEden() {
		return takipEden;
	}
	public void setTakipEden(Long takipEden) {
		this.takipEden = takipEden;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
