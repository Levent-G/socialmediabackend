package com.project.sosyalmedyaapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.sosyalmedyaapp.entities.Follow;

import com.project.sosyalmedyaapp.repos.FollowRepository;


@Service
public class FollowService {
	
	FollowRepository followRepository;

	public FollowService(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}
	
	
	public List<Follow> getAllFollow() {
		
		
		return followRepository.findAll();
	}
	public Follow saveOneFollow(Follow newFollow) {
		List<Follow> follow = followRepository.findByTakipEdilenAndTakipEden(newFollow.getTakipEdilen(), newFollow.getTakipEden());
		if(follow.isEmpty()) {
			newFollow.getStatus();
			newFollow.getTakipEdilen();
			newFollow.getTakipEden();
			return followRepository.save(newFollow);
		}
		else return null;
		
	
		
		
	}


	public List<Follow> getOneTakipEden(Long takipEden,Long takipEdilen) {
		// TODO Auto-generated method stub
		return followRepository.findByTakipEdilenAndTakipEden(takipEdilen,takipEden);
	}


	public void getFollow(Long id) {
		// TODO Auto-generated method stub
		 followRepository.deleteById(id);
	}


	public long getfollowcount(Long takipEdilen) {
		List<Follow> list;
		list = followRepository.findByTakipEdilen(takipEdilen);
		long count =0;
		count = list.size();
		 return count;
	}


	public long getfollowcount2(Long takipEden) {
		List<Follow> list;
		list = followRepository.findByTakipEden(takipEden);
		long count =0;
		count = list.size();
		 return count;
		
	}





	
}
