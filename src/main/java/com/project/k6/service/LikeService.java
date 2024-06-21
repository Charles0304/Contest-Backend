package com.project.k6.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.HsCode;
import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;
import com.project.k6.persistence.HsCodeRepository;
import com.project.k6.persistence.LikeRepostitory;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepostitory likeRapo;
	@Autowired
	private HsCodeRepository hscodeRepo;
	
	public Like postLike(Member member, HsCode hs){
		Optional<HsCode> hscode = hscodeRepo.findById(hs.getHscode());
		Like like = Like.builder()
		.member(member)
		.hsCode(hscode.get())
		.build();
		likeRapo.save(like);
		return like;
	}

	public Like deleteLike(LikeId id) {
		Like lk = likeRapo.findById(id).get();
		likeRapo.deleteById(id);
		return lk;
	}
}
