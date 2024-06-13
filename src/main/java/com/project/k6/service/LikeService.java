package com.project.k6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.HsCode;
import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;
import com.project.k6.persistence.LikeRepostitory;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepostitory likeRapo;
	
	public List<Like> postLike(Member member, HsCode hs){
		Like like = Like.builder()
		.member(member)
		.hsCode(hs)
		.build();
		likeRapo.save(like);
		return likeRapo.findAll();
	}

	public Like deleteLike(LikeId id) {
		Like lk = likeRapo.getById(id);
		likeRapo.deleteById(id);
		return lk;
	}
}
