package com.global.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Cart;
import com.global.book.entity.CartItem;
import com.global.book.service.CartService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/cart")
@Validated
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/{id}")
	public Cart findById(@PathVariable Long id) {

		return cartService.findById(id);
	}

	@GetMapping("/user/{userId}")
	public Cart findByUserId(@PathVariable Long userId) {

		return cartService.findByUserId(userId);
	}

	@PostMapping("")
	public Cart insert(@RequestBody @Valid Cart entity) {
		return cartService.insert(entity);
	}

	@PutMapping("")
	public Cart update(@RequestBody @Valid Cart entity) {

		Cart dem = findById(entity.getId());
		dem.setItems(entity.getItems());
		dem.setUser(entity.getUser());

		return cartService.update(dem);

	}

	@PostMapping("/items")
	public CartItem addItemToCart(@RequestAttribute Long userId, @RequestAttribute Long bookId,
			@RequestAttribute Long quantity) {

		return cartService.addItemToCart(userId, bookId, quantity);
	}

	@PutMapping("/items")
	public CartItem updateCartItem(@RequestAttribute Long bookId, @RequestAttribute @Min(1) Long quantity) {

		return cartService.updateCartItem(bookId, quantity);
	}

	@DeleteMapping("/items")
	void deleteCartItem(@RequestAttribute Long bookId) {
		cartService.deleteCartItem(bookId);

	}

}
