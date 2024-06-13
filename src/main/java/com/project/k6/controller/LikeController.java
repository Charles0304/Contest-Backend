package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.k6.domain.HsCode;
import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;
import com.project.k6.service.LikeService;

@Controller
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/like")
	public List<Like> postLikes(Member member, HsCode hs){
		return likeService.postLike(member,hs);
	}
	
	@DeleteMapping("/like")
	public Like deleteLikes(LikeId id){
		return likeService.deleteLike(id);
	}
}
