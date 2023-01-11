package com.project.sosyalmedyaapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.sosyalmedyaapp.entities.Post;
import com.project.sosyalmedyaapp.requests.PostCreateRequest;
import com.project.sosyalmedyaapp.requests.PostUpdateRequest;
import com.project.sosyalmedyaapp.responses.PostResponse;
import com.project.sosyalmedyaapp.services.PostService;
@RestController
@RequestMapping("/posts")
public class PostController {
	
      private PostService postService;

	public PostController(PostService postService) {
	
		this.postService = postService;
	}
	
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
	return postService.getAllPosts(userId);
    }
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	@GetMapping("/getUserId/{userId}")
	public List<PostResponse> getOnePostUser(@PathVariable Optional<Long> userId) {
		return postService.getOnePostUser(userId);
	}
      
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId,@RequestBody PostUpdateRequest updatePost) {
		return postService.updateOnePostById(postId,updatePost);
		
	}
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		 postService.deleteOnePostById(postId);
	}
 

}
