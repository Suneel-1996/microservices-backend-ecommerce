package com.cart.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.entity.CartEntity;
import com.cart.demo.repo.CartRepo;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartRepo cartRepo;
	
	@PostMapping("/update-qty-by-cartId/{cartId}/{qty}/{price}")
	public void updateQtyByCartId(@PathVariable long cartId,@PathVariable int qty,@PathVariable double price) {
		Optional<CartEntity> cartEntity=cartRepo.findById(cartId);
		if(cartEntity.isPresent()) {
			CartEntity cart=cartEntity.get();
			cart.setPrice(price);
			cart.setQuantity(qty);
			cartRepo.save(cart);
			
		}
		
		
	}
	
	
	@DeleteMapping("/remove-cart-by-userId/{userId}")
	public List<CartEntity> removeCartItemsForUser(@PathVariable long userId) {
		List<CartEntity> cartList = new ArrayList<CartEntity>();
		try {
			
			cartList=cartRepo.findByUserId(userId);
			cartRepo.deleteAll(cartList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartList;
	}
	
	//Check the functionality
	@DeleteMapping("/remove-cart-by-id-productId/{id}/{productId}")
	public void removeProductFromCart(@PathVariable long id,@PathVariable long productId) {
		List<CartEntity> cartEntity=cartRepo.findByUserIdAndProductId(id,productId);
		cartRepo.deleteAll(cartEntity);
		
	}
	@RequestMapping("/remove-cart-by-cartId/{cartId}")
	public void removeCartByCartId(@PathVariable long cartId) {
		//cartRepo.deleteAll();
		try {
			
			cartRepo.findById(cartId);
			cartRepo.deleteById(cartId);
			//cartRepo.deleteAll();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@RequestMapping("/get-cart-by-user-id/{userId}")
	public List<CartEntity> getCartByUserId(@PathVariable long userId){
		
		List<CartEntity> cartList = new ArrayList<CartEntity>();
		
		try {
			cartList=cartRepo.findByUserId(userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return cartList;
	}
	
	@RequestMapping("/get-cart-by-id-and-userid/{id}/{userId}")
	public List<CartEntity> getCartByIdAndUserId(@PathVariable long id,@PathVariable long userId) {
		List<CartEntity> cartList = new ArrayList<CartEntity>();
		try {
			cartList=cartRepo.findByIdAndUserId(id,userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartList;
	}
	
	@DeleteMapping("/delete-cart-by-id-and-userid/{id}/{userId}")
	public List<CartEntity> removeCartByIdAndUserId(@PathVariable long id,@PathVariable long userId){
		List<CartEntity> cartList = new ArrayList<CartEntity>();
		try {
			cartList=cartRepo.findByIdAndUserId(id,userId);
			for(CartEntity ce:cartList) {
				cartRepo.delete(ce);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cartList;
	}

	@PostMapping("/add-cart-by-productId-and-userId-quantity-price/{productId}/{userId}/{qty}/{price}")
	public void addCartByUserIdAndProductId(@PathVariable long productId,@PathVariable long userId,@PathVariable int qty,@PathVariable double price) {
			CartEntity cartEntity= new CartEntity();
			
		try {
			if(!cartRepo.findByUserIdAndProductId(userId,productId).isEmpty()) {
				throw new Exception("Product with user id already present");
			}
			else {
				cartEntity.setProductId(productId);
				cartEntity.setUserId(userId);
				cartEntity.setQuantity(qty);
				String date=""+LocalDate.now()+"";
				cartEntity.setAddedDate(date);
				cartEntity.setPrice(price);
				cartRepo.save(cartEntity);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
