package com.project.server.repository;

import com.project.server.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{

}
