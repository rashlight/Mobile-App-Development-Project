package com.project.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.dto.OrderDTO;
import com.project.server.dto.UserModel;
import com.project.server.entity.OrderEntity;
import com.project.server.entity.User;
import com.project.server.repository.UserRepository;
import com.project.server.service.OrderService;
import com.project.server.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<OrderDTO> findAll(@RequestParam(value="token")String token){
		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());
		List<OrderDTO> results = orderService.findAll(user);
		return results;
	}

//	public OrderEntity findById() {
//		return null;
//	}

}
