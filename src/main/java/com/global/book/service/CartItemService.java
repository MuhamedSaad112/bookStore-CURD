package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.CartItem;
import com.global.book.repository.CartItemRepo;

@Service
public class CartItemService extends BaseService<CartItem, Long> {

	@Autowired
	private CartItemRepo cartItemRepo;

	public CartItem findById(Long id) {

		return cartItemRepo.findById(id).get();
	}

	public CartItem findByBookId(Long bookId) {

		return cartItemRepo.findByBookId(bookId);
	}

	public List<CartItem> findAll() {

		return cartItemRepo.findAll();
	}

	public CartItem insert(CartItem entity) {
		return cartItemRepo.save(entity);
	}

	public CartItem update(CartItem entity) {

		CartItem dem = findById(entity.getId());

		dem.setBook(entity.getBook());
		dem.setCart(entity.getCart());
		dem.setQuantity(entity.getQuantity());

		return cartItemRepo.save(dem);
	}

	public void delete(CartItem entity) {
		cartItemRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return cartItemRepo.existsById(id);

	}

	public Long countAll() {
		return cartItemRepo.count();

	}

}