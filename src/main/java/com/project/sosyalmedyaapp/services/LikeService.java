package com.project.sosyalmedyaapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.project.sosyalmedyaapp.entities.Like;
import com.project.sosyalmedyaapp.entities.Post;
import com.project.sosyalmedyaapp.entities.User;
import com.project.sosyalmedyaapp.repos.LikeRepository;
import com.project.sosyalmedyaapp.requests.LikeCreateRequest;
import com.project.sosyalmedyaapp.responses.LikeResponse;


@Service
public class LikeService {
	
	private LikeRepository  likeRepository;
	private UserService userService;
	private PostService postService;
	
	public LikeService(LikeRepository likeRepository,PostService postService,UserService userService) {
		super();
		this.likeRepository = likeRepository;
		this.postService = postService;
		this.userService = userService;
		
	}

	public List<LikeResponse> getAllLikeWithParams(Optional<Long> userId, Optional<Long> postId) {
	List<Like> list;
		if(userId.isPresent()&&postId.isPresent()) {
			list= likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}
		else if(userId.isPresent()){
			list= likeRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			list=likeRepository.findByPostId(postId.get());
		}else {
			list= likeRepository.findAll();
		}
		return list.stream().map(like->new LikeResponse(like)).collect(Collectors.toList());
	}

	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
		
	}

	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public Like createOneLike(LikeCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user!= null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(request.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
		
			return likeRepository.save(likeToSave);
		}else {
			return null;
		}
	}

	
	
}
