package com.cart.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.demo.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long>{

	List<ProductEntity> findByCategoryId(String categoryId);

}
