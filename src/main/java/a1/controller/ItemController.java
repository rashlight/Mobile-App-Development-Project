package a1.controller;

import java.util.List;

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

import a1.model.ItemDTO;
import a1.model.UserDTO;
import a1.service.ItemService;

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
	public String createUser(@RequestBody ItemDTO item) {
		itemService.addItem(item);
		return "Added successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable(name="id") Long id) {
		itemService.deleteById(id);
		return "Delete successfully";
	}
	
	@PutMapping
	public String updateUser(@RequestBody ItemDTO item) {
		itemService.updateItem(item);
		return "Edit successfully";
	}


}
