package a1.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import a1.model.UserDTO;
import a1.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDTO> findAll(){
		List<UserDTO> results = userService.findAll();
		return results;
	}
	
	@PostMapping
	public String createUser(@RequestBody UserDTO user) {
		userService.add(user);
		return "Added successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable(name="id") Long id) {
		userService.deleteById(id);
		return "Delete successfully";
	}
	
	@PutMapping
	public String updateUser(@RequestBody UserDTO user) {
		userService.updateUser(user);
		return "Edit successfully";
	}

}
