package com.project.k6.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;
import com.project.k6.service.LikeService;
import com.project.k6.service.MemberService;

@RestController
@RequestMapping("/like")
public class LikeController {

	@Autowired
	private LikeService likeService;
	@Autowired
	private MemberService memberService;

	@PostMapping("")
	public Like postLikes(@RequestBody LikeId id){
		return likeService.postLike(id);
	}
	
	//유저가 좋아요 했는지 확인
	@GetMapping("/status/{memberId}/{hscode}")
    public ResponseEntity<?> getLikeStatus(@PathVariable Long memberId, @PathVariable String hscode) {
        boolean isLiked = likeService.isLiked(memberId, hscode);
        return ResponseEntity.ok(Collections.singletonMap("isLiked", isLiked));
    }
	
	@DeleteMapping("/{memberId}/{hscode}")
	public Like deleteLikes(@PathVariable Long memberId, @PathVariable String hscode){
		LikeId id = new LikeId(memberId,hscode);
		return likeService.deleteLike(id);
	}

    @GetMapping("/{memberId}")
    public List<Like> getLikesByMember(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return likeService.getLikesByMember(member);
    }
}