package com.project.sosyalmedyaapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sosyalmedyaapp.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByUserIdAndPostId(Long long1, Long long2);

	List<Like> findByUserId(Long userId);

	List<Like> findByPostId(Long long1);



}
