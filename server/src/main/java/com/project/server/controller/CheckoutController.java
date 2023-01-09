package com.project.server.controller;

import java.util.List;
import java.util.Optional;

import com.project.server.dto.*;
import com.project.server.entity.*;
import com.project.server.service.*;
import com.project.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartItemService cartService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public String placeOrder(@RequestParam(name="token") String token) {


		UserModel userModel = userService.findbyToken(token);
		User user = userRepository.getOne(userModel.getUserid());

		List<CartItemEntity> cartItems = cartService.listCartItems(user);
		CheckoutInfo checkoutInfo = checkoutService.prepareCheckout(cartItems);

		OrderEntity createdOrder = orderService.createOrder(user, cartItems, checkoutInfo);
		cartService.deleteByUser(user);
		
		return "Successfully Checkout";
	}

}
