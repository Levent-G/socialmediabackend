package com.project.sosyalmedyaapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;


import com.project.sosyalmedyaapp.entities.Like;

import com.project.sosyalmedyaapp.requests.LikeCreateRequest;
import com.project.sosyalmedyaapp.responses.LikeResponse;
import com.project.sosyalmedyaapp.services.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		super();
		this.likeService = likeService;
	}
	
	
	@GetMapping
	public List<LikeResponse> getAllLike(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId ){
		return likeService.getAllLikeWithParams(userId,postId);
	}
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable Long likeId) {
		likeService.deleteOneLikeById(likeId);
	}
	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable Long likeId) {
		return likeService.getOneLikeById(likeId);
	}
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest request) {
		return likeService.createOneLike(request);
	}

	
	
}
