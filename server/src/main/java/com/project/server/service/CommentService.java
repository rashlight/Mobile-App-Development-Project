package com.project.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.server.dto.CommentDTO;
import com.project.server.entity.CommentEntity;
import com.project.server.entity.ItemEntity;
import com.project.server.entity.User;
import com.project.server.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	public CommentDTO addComment(Long itemId, User user, float rating, String description) {
		ItemEntity item = new ItemEntity(itemId);
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setDescription(description);
		commentEntity.setRating(rating);
		commentEntity.setItem(item);
		commentEntity.setUser(user);
		commentRepo.save(commentEntity);
		//commentEntity = commentRepo.findByUserAndItem(user, item);
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setDescription(description);
		commentDTO.setRating(rating);
		return commentDTO;
	}
	
	public List<CommentDTO> findAll(Long itemId, User user){
		List<CommentDTO> results = new ArrayList<>();
		ItemEntity item = new ItemEntity(itemId);
		List<CommentEntity> commentEntities = commentRepo.findByItem(item);
		for(CommentEntity i: commentEntities) {
			CommentDTO comment = new CommentDTO();
			comment.setDescription(i.getDescription());
			comment.setRating(i.getRating());
			results.add(comment);
		}
		return results;
		
	}
	
	public float getAverageRating() {
		List<CommentEntity> commentEntities = commentRepo.findAll();
		float result = 0;
		int count = 0;
		for(CommentEntity i: commentEntities) {
			result += i.getRating();
			count++;
		}
		return result/count;
	}

}
