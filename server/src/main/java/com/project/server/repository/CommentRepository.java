package com.project.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.server.entity.CommentEntity;
import com.project.server.entity.ItemEntity;
import com.project.server.entity.User;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long>{
	
	CommentEntity findByUserAndItem(User user,ItemEntity item);
	
	List<CommentEntity> findByItem(ItemEntity item);

}
