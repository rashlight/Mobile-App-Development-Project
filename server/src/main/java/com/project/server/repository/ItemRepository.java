package com.project.server.repository;

import com.project.server.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface ItemRepository extends CrudRepository<ItemEntity,Long>, JpaRepository<ItemEntity,Long>{

}
