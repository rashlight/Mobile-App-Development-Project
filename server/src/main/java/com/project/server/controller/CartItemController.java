package com.project.server.controller;

import com.project.server.dto.*;
import com.project.server.entity.User;
import com.project.server.repository.UserRepository;
import com.project.server.service.CartItemService;
import com.project.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/cart")
public class CartItemController {
	@Autowired
	private UserService userService;
	@Autowired
	private CartItemService cartService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add/{itemId}/{quantity}")
	public String addProductToCart(@PathVariable(name = "itemId") Long itemId,
			@PathVariable(name = "quantity") Integer quantity,@RequestParam(name="token") String token) {
		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());
		Integer updatedQuantity = cartService.addProduct(itemId, quantity, user);
		return updatedQuantity + " item(s) of this product were added to your shopping cart.";
	}

	@GetMapping
	public CartItemDTO find(@RequestParam(value = "itemId") Long itemId,@RequestParam(value="token")String token) {
		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());
		CartItemDTO cartItem = cartService.findByUserAndItem(user, itemId);
		return cartItem;
	}

	@PostMapping("/update/{productId}/{quantity}")
	public String updateQuantity(@PathVariable("productId") Long itemId, @PathVariable("quantity") Integer quantity,@RequestParam(value="token")String token) {
		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());
		float subtotal = cartService.updateQuantity(itemId, quantity, user);

		return String.valueOf(subtotal);
	}

	@DeleteMapping("/remove/{itemId}")
	public String removeProduct(@PathVariable("itemId") Long itemId,@RequestParam("token") String token) {
		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());

		cartService.removeProduct(itemId, user);

		return "The product has been removed from your shopping cart.";

	}

}
