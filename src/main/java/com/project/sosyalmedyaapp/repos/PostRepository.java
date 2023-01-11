package com.project.sosyalmedyaapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sosyalmedyaapp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

}
