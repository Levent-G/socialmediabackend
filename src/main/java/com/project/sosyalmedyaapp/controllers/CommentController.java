package com.project.sosyalmedyaapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.sosyalmedyaapp.entities.Comment;
import com.project.sosyalmedyaapp.requests.CommentCreateRequest;
import com.project.sosyalmedyaapp.requests.CommentUpdateRequest;
import com.project.sosyalmedyaapp.responses.CommentResponse;

import com.project.sosyalmedyaapp.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService=commentService;
	}
	
	@GetMapping
	public  List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId ){
		return commentService.getAllCommentsWithParam(userId,postId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest request) {
		return commentService.createOneComment(request);
	}
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest request) {
		return commentService.updateOneCommentById(commentId,request);
	}
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Long commentId) {
		commentService.deleteOneCommentById(commentId);
	}
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	
}
