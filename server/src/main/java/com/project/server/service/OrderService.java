package a1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a1.model.CheckoutInfo;
import a1.repository.OrderRepository;
import a1.repository.entity.CartItemEntity;
import a1.repository.entity.ItemEntity;
import a1.repository.entity.OrderDetailEntity;
import a1.repository.entity.OrderEntity;
import a1.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public OrderEntity createOrder(UserEntity userEntity,List<CartItemEntity> cartItems, CheckoutInfo checkoutInfo) {
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
