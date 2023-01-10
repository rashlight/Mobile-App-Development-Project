package com.project.server.service;

import com.project.server.converter.OrderConverter;

import com.project.server.dto.CheckoutInfo;
import com.project.server.dto.OrderDTO;
import com.project.server.entity.*;
import com.project.server.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderConverter converter;
	
	private String createListOfProducts(List<CartItemEntity> cartItems) {
		List<String> listOfItems = new ArrayList<>();
		for(CartItemEntity cartItem : cartItems) {
			listOfItems.add(cartItem.getItem().getName());
		}
		return String.join(",", listOfItems);
	}
	
	public OrderEntity createOrder(User userEntity, List<CartItemEntity> cartItems, CheckoutInfo checkoutInfo) {
		OrderEntity newOrder = new OrderEntity();
		//newOrder.setOrderTime(new Date());
		
		newOrder.setUser(userEntity);
		newOrder.setProductCost(checkoutInfo.getProductCost());
		newOrder.setProducts(createListOfProducts(cartItems));
//		newOrder.setSubtotal(checkoutInfo.getProductTotal());
//		newOrder.setTax(0.0f);
//		newOrder.setTotal(checkoutInfo.getPaymentTotal());
		
			
//		Set<OrderDetailEntity> orderDetails = newOrder.getOrderDetails();
//		
//		for (CartItemEntity cartItem : cartItems) {
//			ItemEntity item = cartItem.getItem();
//			OrderDetailEntity orderDetail = new OrderDetailEntity();
//			orderDetail.setOrder(newOrder);
//			orderDetail.setItem(item);
//			orderDetail.setQuantity(cartItem.getQuantity());
//			orderDetail.setItemCost(item.getPrice() * cartItem.getQuantity());
//			//orderDetail.setSubtotal(cartItem.getSubtotal());		
//			
//			orderDetails.add(orderDetail);
//		}
		return orderRepo.save(newOrder);
	}
	
	public List<OrderDTO> findAll(User user){
		List<OrderDTO> results = new ArrayList<>();
		List<OrderEntity> orderEntities = orderRepo.findByUser(user);
		for(OrderEntity i : orderEntities) {
			OrderDTO order = new OrderDTO();
			order.setProductCost(i.getProductCost());
		    order.setProducts(i.getProducts());
			results.add(order);
		}
		return results;
	}

}
