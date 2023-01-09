package com.project.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import a1.model.CartItemDTO;
import a1.model.UserDTO;
import a1.repository.entity.UserEntity;
import a1.service.CartItemService;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

	@Autowired
	private CartItemService cartService;

	@PostMapping("/add/{itemId}/{quantity}")
	public String addProductToCart(@PathVariable(name = "itemId") Long itemId,
			@PathVariable(name = "quantity") Integer quantity) {
		// Have to add more (177)
		UserEntity user = new UserEntity();
		Long userId = (long) 1;
		user.setId(userId);
		user.setName("kali");
		user.setEmail("kali@gmail.com");
		Integer updatedQuantity = cartService.addProduct(itemId, quantity, user);
		return updatedQuantity + " item(s) of this product were added to your shopping cart.";
	}

	@GetMapping
	public CartItemDTO find(@RequestParam(value = "itemId") Long itemId) {
		UserDTO user = new UserDTO();
		Long userId = (long) 1;
		user.setId(userId);
		user.setName("kali");
		user.setEmail("kali@gmail.com");
		CartItemDTO cartItem = cartService.findByUserAndItem(user, itemId);
		return cartItem;
	}

	@PostMapping("/update/{productId}/{quantity}")
	public String updateQuantity(@PathVariable("productId") Long itemId, @PathVariable("quantity") Integer quantity) {
		UserEntity user = new UserEntity();
		Long userId = (long) 1;
		user.setId(userId);
		user.setName("kali");
		user.setEmail("kali@gmail.com");
		float subtotal = cartService.updateQuantity(itemId, quantity, user);

		return String.valueOf(subtotal);
	}

	@DeleteMapping("/remove/{itemId}")
	public String removeProduct(@PathVariable("itemId") Long itemId) {
		UserEntity user = new UserEntity();
		Long userId = (long) 1;
		user.setId(userId);
		user.setName("kali");
		user.setEmail("kali@gmail.com");

		cartService.removeProduct(itemId, user);

		return "The product has been removed from your shopping cart.";

	}

}
