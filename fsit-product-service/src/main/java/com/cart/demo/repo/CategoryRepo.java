package com.cart.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.demo.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long>{

}
