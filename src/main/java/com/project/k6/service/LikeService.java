package com.project.k6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.HsCode;
import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;
import com.project.k6.persistence.HsCodeRepository;
import com.project.k6.persistence.LikeRepostitory;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepostitory likeRapo;
	@Autowired
	private HsCodeRepository hscodeRepo;

	
	public Like postLike(Member member, String hs){
		System.out.println(hs+" "+member);
		Optional<HsCode> hscodeOptional = hscodeRepo.findById(hs);
		HsCode hscode = hscodeOptional.orElseThrow(() -> new EntityNotFoundException("HsCode not found"));
		Like like = Like.builder()
		.member(member)
		.hsCode(hscode)
		.build();
		likeRapo.save(like);
		return like;
	}

	public Like deleteLike(LikeId id) {
		System.out.println(id);
		Like lk = likeRapo.findById(id).get();
		likeRapo.deleteById(id);		
		return lk;
	}
	
	 public List<Like> getLikesByMember(Member member) {
	        return likeRapo.findByMember(member);
	}
}
