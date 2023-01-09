package com.project.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import a1.repository.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
