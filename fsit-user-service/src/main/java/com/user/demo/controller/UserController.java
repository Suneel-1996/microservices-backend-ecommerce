package com.user.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.entity.UserModel;
import com.user.demo.repository.UserRepo;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping(value = "/status",produces = {"application/json"})
	public ResponseEntity<?> serverStatus(){
		System.err.println("Working fine");
		return new ResponseEntity<>("Server is up and running.",HttpStatus.OK);
	}
	
	@RequestMapping("/all-users")
	public List<UserModel> getAllUsers() {
		List<UserModel> userList= new ArrayList<UserModel>();
		try {
			userList= userRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userList;
	}
	
	@RequestMapping("/get-user-by-id/{id}")
	public UserModel getUser(@PathVariable long id) {
		UserModel user= new UserModel();
		 
		try {
			 Optional<UserModel> userDetails=userRepo.findById(id);
			 user=userDetails.get();
//			user= new UserModel(
//					user.get().getId(), 
//					name, 
//					email, 
//					password, 
//					created_at, 
//					login_token, 
//					type, 
//					address, 
//					is_email_verified, 
//					mobile_number)
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
				
	}

	@RequestMapping("/get-user-by-mobile/{mobile}")
	public UserModel getUserByMobile(@PathVariable String mobile) {
		UserModel user= new UserModel();
		 
		try { 
			 Optional<UserModel> userDetails=userRepo.findByMobile(mobile);
			 user=userDetails.get();
//			user= new UserModel(
//					user.get().getId(), 
//					name, 
//					email, 
//					password, 
//					created_at, 
//					login_token, 
//					type, 
//					address, 
//					is_email_verified, 
//					mobile_number)
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
				
	}
	
	@PostMapping(value = "/signup-user",consumes = "application/json")
	public UserModel signUpUser(@RequestBody UserModel userInput) throws Exception {
		UserModel user = new UserModel();
		if(userRepo.findById(userInput.getId()).isPresent()) {
			throw new Exception("User Already exists with the given Id. ");
			
		}
		else {
			try {
				user= new UserModel(userInput.getId(), 
						userInput.getName(), 
						userInput.getEmail(), 
						userInput.getPassword(), 
						new Timestamp(System.currentTimeMillis()),
						userInput.getLogin_token(), 
						 userInput.getType(),
						userInput.getAddress(),
						userInput.getIs_email_verified(),
						userInput.getMobile_number());
				userRepo.save(user);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		
		
		return user;
		
	}
}
