package com.cart.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.demo.entity.CartEntity;

public interface CartRepo extends JpaRepository<CartEntity, Long>{

	

	
	List<CartEntity> findByIdAndUserId(long id, long userId);

	void findByIdAndUserIdAndProductId(long id,long userId, long productId);
	List<CartEntity> findByUserIdAndProductId(long userId, long productId);


	List<CartEntity> findByUserId(long userId);


	//void findByUserId(long userId);


	//void findByIdAndUserId(long id, long userId);

}
