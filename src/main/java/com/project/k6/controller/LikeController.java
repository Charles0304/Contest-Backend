package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;
import com.project.k6.service.LikeService;
import com.project.k6.service.MemberService;

@RestController
public class LikeController {

	@Autowired
	private LikeService likeService;
	@Autowired
	private MemberService memberService;

	@PostMapping("/like")
	public Like postLikes(@RequestBody Member member, String hs){
		return likeService.postLike(member,hs);
	}

	@DeleteMapping("/like")
	public Like deleteLikes(@RequestBody LikeId id){
		return likeService.deleteLike(id);
	}

    @GetMapping("/member/{memberId}")
    public List<Like> getLikesByMember(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return likeService.getLikesByMember(member);
    }
}