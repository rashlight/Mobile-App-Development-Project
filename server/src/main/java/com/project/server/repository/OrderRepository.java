package com.project.server.repository;

import com.project.server.entity.OrderEntity;
import com.project.server.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	
	List<OrderEntity> findByUser(User user);

}
