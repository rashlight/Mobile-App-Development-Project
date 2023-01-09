package com.project.server.repository;

import java.util.List;
import java.util.UUID;


import com.project.server.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CartItemRepository extends CrudRepository<CartItemEntity, Long>,JpaRepository<CartItemEntity,Long>{
	
	public List<CartItemEntity> findByUser(User user);
	
	CartItemEntity findByUserAndItem(User user,ItemEntity item);
	
	@Modifying
	@Query("UPDATE CartItemEntity c SET c.quantity = ?1 WHERE c.user.userid = ?2 AND c.item.id = ?3")
	public void updateQuantity(Integer quantity, UUID userId, Long itemId);
	
	@Modifying
	@Query("DELETE FROM CartItemEntity c WHERE c.user.userid = ?1 AND c.item.id = ?2")
	public void deleteByUserAndItem(UUID userId, Long itemId);

	@Modifying
	@Query("DELETE CartItemEntity c WHERE c.user.userid = ?1")
	public void deleteByUser(UUID userId);

}
