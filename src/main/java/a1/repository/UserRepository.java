package a1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

import a1.repository.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>, CrudRepository<UserEntity,Long>{

	UserEntity findByName(String name);

	

}
