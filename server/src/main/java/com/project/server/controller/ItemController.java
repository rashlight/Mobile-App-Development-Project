package com.project.server.controller;

import java.util.List;

import com.project.server.dto.*;
import com.project.server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<ItemDTO> findAll(){
		List<ItemDTO> results = itemService.findAll();
		return results;
	}
	
	@PostMapping
	public String createItem(@RequestBody ItemDTO item) {
		itemService.addItem(item);
		return "Added successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteItem(@PathVariable(name="id") Long id) {
		itemService.deleteById(id);
		return "Delete successfully";
	}
	
	@PutMapping
	public String updateItem(@RequestBody ItemDTO item) {
		itemService.updateItem(item);
		return "Edit successfully";
	}


}
