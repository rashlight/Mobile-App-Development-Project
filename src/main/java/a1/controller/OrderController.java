package a1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a1.repository.entity.OrderEntity;
import a1.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	
	public List<OrderEntity> findAll(){
		List<OrderEntity> results = orderService.findAll();
		return results;
	} 
	
//	public OrderEntity findById() {
//		return null;
//	}

}
