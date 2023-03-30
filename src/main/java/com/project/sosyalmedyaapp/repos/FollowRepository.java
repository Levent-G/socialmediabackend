package com.project.sosyalmedyaapp.repos;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sosyalmedyaapp.entities.Follow;



public interface FollowRepository extends JpaRepository<Follow, Long> {
	List<Follow> findByTakipEdilenAndTakipEden(Long takipEdilen,Long takipEden);
	List<Follow> findByTakipEdilen(Long takipEdilen);
	List<Follow> findByTakipEden(Long takipEden);
	List<Follow> deleteByTakipEdilenAndTakipEden(Long takipEdilen,Long takipEden);
}
