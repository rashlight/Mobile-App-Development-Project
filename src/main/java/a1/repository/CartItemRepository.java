package a1.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import a1.repository.entity.CartItemEntity;
import a1.repository.entity.ItemEntity;
import a1.repository.entity.UserEntity;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Long>,JpaRepository<CartItemEntity,Long>{
	
	public List<CartItemEntity> findByCustomer(UserEntity user);
	
	CartItemEntity findByUserAndItem(UserEntity user,ItemEntity item);
	
	@Modifying
	@Query("UPDATE CartItemEntity c SET c.quantity = ?1 WHERE c.user.id = ?2 AND c.item.id = ?3")
	public void updateQuantity(Integer quantity, Long userId, Long itemId);
	
	@Modifying
	@Query("DELETE FROM CartItemEntity c WHERE c.user.id = ?1 AND c.item.id = ?2")
	public void deleteByUserAndItem(Long userId, Long itemId);

	@Modifying
	@Query("DELETE CartItemEntity c WHERE c.user.id = ?1")
	public void deleteByUser(Long userId);

}
