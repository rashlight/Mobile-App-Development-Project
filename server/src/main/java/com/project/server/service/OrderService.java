package com.project.server.service;

import com.project.server.dto.CheckoutInfo;
import com.project.server.entity.*;
import com.project.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public OrderEntity createOrder(User userEntity, List<CartItemEntity> cartItems, CheckoutInfo checkoutInfo) {
		OrderEntity newOrder = new OrderEntity();
		//newOrder.setOrderTime(new Date());
		
		newOrder.setUser(userEntity);
		newOrder.setProductCost(checkoutInfo.getProductCost());
		newOrder.setSubtotal(checkoutInfo.getProductTotal());
		newOrder.setTax(0.0f);
		newOrder.setTotal(checkoutInfo.getPaymentTotal());
		
			
		Set<OrderDetailEntity> orderDetails = newOrder.getOrderDetails();
		
		for (CartItemEntity cartItem : cartItems) {
			ItemEntity item = cartItem.getItem();
			OrderDetailEntity orderDetail = new OrderDetailEntity();
			orderDetail.setOrder(newOrder);
			orderDetail.setItem(item);
			orderDetail.setQuantity(cartItem.getQuantity());
			orderDetail.setItemCost(item.getPrice() * cartItem.getQuantity());
			//orderDetail.setSubtotal(cartItem.getSubtotal());		
			
			orderDetails.add(orderDetail);
		}
		return orderRepo.save(newOrder);
	}
	
	public List<OrderEntity> findAll(){
		return orderRepo.findAll();
	}

}
