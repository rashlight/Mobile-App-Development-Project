package a1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a1.model.CheckoutInfo;
import a1.repository.entity.CartItemEntity;
import a1.repository.entity.OrderEntity;
import a1.repository.entity.UserEntity;
import a1.service.CartItemService;
import a1.service.CheckoutService;
import a1.service.OrderService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartItemService cartService;

	@PostMapping
	public String placeOrder() {

		
		UserEntity userEntity = new UserEntity();
		Long userId = (long) 1;
		userEntity.setId(userId);
		userEntity.setName("kali");
		userEntity.setEmail("kali@gmail.com");

		List<CartItemEntity> cartItems = cartService.listCartItems(userEntity);
		CheckoutInfo checkoutInfo = checkoutService.prepareCheckout(cartItems);

		OrderEntity createdOrder = orderService.createOrder(userEntity, cartItems, checkoutInfo);
		cartService.deleteByUser(userEntity);
		
		return "Successfully Checkout";
	}

}
