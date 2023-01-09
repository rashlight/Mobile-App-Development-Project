package com.project.server.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import com.project.server.dto.*;
import com.project.server.entity.*;
import com.project.server.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class CartItemService {
	
	@Autowired 
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	public Integer addProduct(Long itemId, Integer quantity, User user) {
		Integer updatedQuantity = quantity;
		ItemEntity item = new ItemEntity(itemId);
		
		CartItemEntity cartItem = cartItemRepo.findByUserAndItem(user, item);
		
		if (cartItem != null) {
			updatedQuantity = cartItem.getQuantity() + quantity;
			cartItem.setQuantity(updatedQuantity);
		}else {
			cartItem = new CartItemEntity();
			cartItem.setUser(user);
			cartItem.setItem(item);
		}
		
		cartItem.setQuantity(updatedQuantity);
		
		cartItemRepo.save(cartItem);
		
		return updatedQuantity;
	}
	
	public List<CartItemEntity> listCartItems(User userEntity) {
		return cartItemRepo.findByUser(userEntity);
	}
	
	public CartItemDTO findByUserAndItem(User user, Long itemId) {

		ItemEntity itemEntity = new ItemEntity(itemId);
		//userEntity.set
		CartItemEntity cartEntity = cartItemRepo.findByUserAndItem(user, itemEntity);
		CartItemDTO cartDTO = new CartItemDTO();
		cartDTO.setId(cartEntity.getId());
		cartDTO.setQuantity(cartEntity.getQuantity());
		cartDTO.setItemId(cartEntity.getItem().getId());
		cartDTO.setUserId(cartEntity.getUser().getUserid());
		return cartDTO;
	}
	
	public float updateQuantity(Long itemId, Integer quantity, User user) {
		cartItemRepo.updateQuantity(quantity, user.getUserid(), itemId);
		ItemEntity itemEntity = itemRepo.findById(itemId).get();
		float subtotal = itemEntity.getPrice() * quantity;
		return subtotal;
	}
	
	
	public void removeProduct(Long itemId, User userEntity) {
		cartItemRepo.deleteByUserAndItem(userEntity.getUserid(), itemId);
	}

	public void deleteByUser(User userEntity) {
		cartItemRepo.deleteByUser(userEntity.getUserid());
	}
	
	
	
	
	

}
