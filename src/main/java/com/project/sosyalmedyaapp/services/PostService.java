package com.project.sosyalmedyaapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.*;

import com.project.sosyalmedyaapp.entities.Post;
import com.project.sosyalmedyaapp.entities.User;
import com.project.sosyalmedyaapp.repos.PostRepository;
import com.project.sosyalmedyaapp.requests.PostCreateRequest;
import com.project.sosyalmedyaapp.requests.PostUpdateRequest;
import com.project.sosyalmedyaapp.responses.PostResponse;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository,UserService userService) {

		this.postRepository = postRepository;
		this.userService=userService;
	}

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			list = postRepository.findByUserId(userId.get());
		}else {
		list= postRepository.findAll();
		}
		return list.stream().map(p->new PostResponse(p)).collect(Collectors.toList());
		
	}

	public Post getOnePostById(Long postId) {
	return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user =userService.getOneUserById(newPostRequest.getUserId());
		if(user == null) {
			return null;
		}else {
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setCreatedAt(newPostRequest.getCreatedAt());
		toSave.setUser(user);
		return postRepository.save(toSave); 
		}
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}else {return null;}
	}

	public void  deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}

	public List<PostResponse> getOnePostUser(Optional<Long> userId) {
		List<Post> list;
		list = postRepository.findByUserId(userId.get());
		return list.stream().map(p->new PostResponse(p)).collect(Collectors.toList());
	}

	public long getpostcount(Optional<Long> userId) {
		List<Post> list;
		list = postRepository.findByUserId(userId.get());
		long count =0;
		count = list.size();
		 return count;
	}
	
}
