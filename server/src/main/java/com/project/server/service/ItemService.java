package com.project.server.service;

import com.project.server.dto.*;
import com.project.server.entity.*;
import com.project.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private CommentService commentService;
	
	public List<ItemDTO> findAll(){
		List<ItemDTO> results = new ArrayList<>();
		List<ItemEntity> itemEntities = itemRepo.findAll();
		for (ItemEntity i : itemEntities) {
			ItemDTO item = new ItemDTO();
			item.setId(i.getId());
			item.setName(i.getName());
			item.setImage(i.getImage());
			item.setTime(i.getTime());
			item.setPrice(i.getPrice());
			item.setRating(commentService.getAverageRating(i.getId()));			
			results.add(item);
		}
		return results;
	}
	
	public void addItem(ItemDTO item) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setName(item.getName());
		itemEntity.setPrice(item.getPrice());
		itemEntity.setImage(item.getImage());
		itemEntity.setTime(item.getTime());
		itemRepo.save(itemEntity);
	}
	
	public void deleteById(Long itemNo) {
		itemRepo.deleteById(itemNo);
	}
	
	public void updateItem(ItemDTO item) {
		ItemEntity itemEntity = itemRepo.findById(item.getId()).get();
		itemEntity.setName(item.getName());
		itemRepo.save(itemEntity);
	}

}
