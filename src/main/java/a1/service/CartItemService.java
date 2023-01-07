package a1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a1.model.CartItemDTO;
import a1.model.ItemDTO;
import a1.model.UserDTO;
import a1.repository.CartItemRepository;
import a1.repository.ItemRepository;
import a1.repository.entity.CartItemEntity;
import a1.repository.entity.ItemEntity;
import a1.repository.entity.UserEntity;

@Service
@Transactional
public class CartItemService {
	
	@Autowired 
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	public Integer addProduct(Long itemId, Integer quantity, UserEntity user) {
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
	
	public List<CartItemEntity> listCartItems(UserEntity userEntity) {
		return cartItemRepo.findByCustomer(userEntity);
	}
	
	public CartItemDTO findByUserAndItem(UserDTO user, Long itemId) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		userEntity.setId(user.getId());
		ItemEntity itemEntity = new ItemEntity(itemId);
		//userEntity.set
		CartItemEntity cartEntity = cartItemRepo.findByUserAndItem(userEntity, itemEntity);
		CartItemDTO cartDTO = new CartItemDTO();
		cartDTO.setId(cartEntity.getId());
		cartDTO.setQuantity(cartEntity.getQuantity());
		cartDTO.setItemId(cartEntity.getItem().getId());
		cartDTO.setUserId(cartEntity.getUser().getId());
		return cartDTO;
	}
	
	public float updateQuantity(Long itemId, Integer quantity, UserEntity user) {
		cartItemRepo.updateQuantity(quantity, user.getId(), itemId);
		ItemEntity itemEntity = itemRepo.findById(itemId).get();
		float subtotal = itemEntity.getPrice() * quantity;
		return subtotal;
	}
	
	
	public void removeProduct(Long itemId, UserEntity userEntity) {
		cartItemRepo.deleteByUserAndItem(userEntity.getId(), itemId);
	}

	public void deleteByCustomer(UserEntity userEntity) {
		cartItemRepo.deleteByUser(userEntity.getId());
	}
	
	
	
	
	

}
