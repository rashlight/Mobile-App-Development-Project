package a1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import a1.repository.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{

}
