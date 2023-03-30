package com.project.sosyalmedyaapp.repos;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sosyalmedyaapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);
	Optional<User> findByEmail(String email);
	Optional<User> findByAccessToken(String accessToken);
	Optional<User> findByEmailAndPassword(String email,String password);
	

}
