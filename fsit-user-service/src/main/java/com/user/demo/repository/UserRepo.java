package com.user.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.demo.entity.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long>{



	Optional<UserModel> findByMobile(String mobile_number);

	
}
