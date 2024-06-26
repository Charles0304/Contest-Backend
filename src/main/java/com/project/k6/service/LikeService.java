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
import com.project.k6.persistence.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepostitory likeRepository;
	@Autowired
	private HsCodeRepository hscodeRepo;
	@Autowired
	private MemberRepository memberRepo;

	
	public Like postLike(LikeId id){
		Optional<HsCode> hscodeOptional = hscodeRepo.findById(id.getHsCode());
		HsCode hscode = hscodeOptional.orElseThrow(() -> new EntityNotFoundException("HsCode not found"));
		Optional<Member> memberOptional = memberRepo.findById(id.getMember());
		Member member = memberOptional.orElseThrow(() -> new EntityNotFoundException("HsCode not found"));
		Like like = Like.builder()
		.member(member)
		.hsCode(hscode)
		.build();
		likeRepository.save(like);
		return like;
	}

	public Like deleteLike(LikeId id) {
		Like lk = likeRepository.findById(id).get();
		likeRepository.deleteById(id);		
		return lk;
	}
	
	 public List<Like> getLikesByMember(Member member) {
	        return likeRepository.findByMember(member);
	}

	public boolean isLiked(Long memberId, String hscode) {
		return likeRepository.existsByMemberIdAndHsCodeHscode(memberId, hscode);
	}
}
