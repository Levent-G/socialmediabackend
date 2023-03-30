package com.project.sosyalmedyaapp.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sosyalmedyaapp.entities.Follow;

import com.project.sosyalmedyaapp.services.FollowService;



@RestController
@RequestMapping("/follow")
public class FollowController {
	
	private FollowService followService;
	
	public FollowController(FollowService followService) {
		this.followService=followService;
	}
	
	//FOLLOW START->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<
		@GetMapping
		public List<Follow> getAllFollow(){
			return followService.getAllFollow();
		}
	
		
		@PostMapping
		public Follow createFollow(@RequestBody Follow newFollow) {
			return followService.saveOneFollow(newFollow);
		}
		
		@GetMapping("/followed")
		public List<Follow> getOneTakipEden(@RequestParam("takipEden") Long takipEden ,@RequestParam("takipEdilen")Long takipEdilen ) {
			
			return followService.getOneTakipEden(takipEden,takipEdilen);
		}
		
		@DeleteMapping("/deletefollow")
		public void deleteFollow(@RequestParam("id") Long id  ) {
			
			 followService.getFollow(id);
		}
		
		@GetMapping("/followcount/{takipEdilen}")
		public long getfollowcount(@PathVariable Long takipEdilen) {
			return followService.getfollowcount(takipEdilen);
		}
		@GetMapping("/followcount2/{takipEden}")
		public long getfollowcount2(@PathVariable Long takipEden) {
			return followService.getfollowcount2(takipEden);
		}

}
