package com.project.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import a1.repository.entity.ItemEntity;

public interface ItemRepository extends CrudRepository<ItemEntity,Long>, JpaRepository<ItemEntity,Long>{

}
