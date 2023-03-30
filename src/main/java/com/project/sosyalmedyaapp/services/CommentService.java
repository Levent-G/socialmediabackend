package com.project.sosyalmedyaapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.sosyalmedyaapp.entities.Comment;

import com.project.sosyalmedyaapp.entities.Post;
import com.project.sosyalmedyaapp.entities.User;
import com.project.sosyalmedyaapp.repos.CommentRepository;
import com.project.sosyalmedyaapp.requests.CommentCreateRequest;
import com.project.sosyalmedyaapp.requests.CommentUpdateRequest;
import com.project.sosyalmedyaapp.responses.CommentResponse;


@Service
public class CommentService {

	private CommentRepository  commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentService(CommentRepository commentRepository,PostService postService,UserService userService) {
	
		this.commentRepository = commentRepository;
		this.postService = postService;
		this.userService = userService;
	}

	public List<CommentResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Comment> list;
		if(userId.isPresent()&&postId.isPresent()) {
			list=  commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}
		else if(userId.isPresent()){
			list=  commentRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			list=  commentRepository.findByPostId(postId.get());
		}else {
			list=  commentRepository.findAll();
		}
		return list.stream().map(comment->new CommentResponse(comment)).collect(Collectors.toList());
		
		
	}

	public Comment getOneCommentById(Long commentId) {
	return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user!= null && post != null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(request.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(request.getText());
			return commentRepository.save(commentToSave);
		}else {
			return null;
		}
		
	}

	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
	Optional<Comment> comment = commentRepository.findById(commentId);
	if(comment.isPresent()) {
	Comment commentToUpdate = comment.get();	
	commentToUpdate.setText(request.getText());
	return commentRepository.save(commentToUpdate);
	}
	else {
	return null;
	}
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}
	public long getcommentcount(Optional<Long> userId) {
		List<Comment> list;
		list = commentRepository.findByUserId(userId.get());
		long count =0;
		count = list.size();
		 return count;
	}
	
	
}
