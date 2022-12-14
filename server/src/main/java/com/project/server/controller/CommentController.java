package com.project.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.dto.CommentDTO;
import com.project.server.dto.UserModel;
import com.project.server.entity.User;
import com.project.server.repository.UserRepository;
import com.project.server.service.CommentService;
import com.project.server.service.UserService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<CommentDTO> findAll(@RequestParam(value="token")String token,
			                        @RequestParam(value="itemId")Long itemId ){
		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());
		List<CommentDTO> results = commentService.findAll(itemId, user);
		return results;
	}
	
	@PostMapping
//	public CommentDTO addComment(@RequestBody String token,
//			@RequestBody String description,
//			@RequestBody Long itemId,
//			@RequestBody float rating) {
	public CommentDTO addComment(@RequestBody Map<String,Object> params) {
		Object token = params.get("token");
		Object description = params.get("description");
		Object rating = params.get("rating");
		Object itemId = params.get("itemId");
		//float rating = (float) params.get("rating");
		UserModel userModel = userService.findbyToken(token.toString());
		User user = userRepository.getOne(userModel.getUserid());
		CommentDTO comment = commentService.addComment(Long.parseLong(itemId.toString()), user, Float.valueOf(rating.toString()), description.toString());
		return comment;
	}
	
	@GetMapping("/average")
	public float getAverageRating(@RequestParam(value="itemId")Long itemId ) {
		float result = commentService.getAverageRating(itemId);
		return result;         
	}

}
