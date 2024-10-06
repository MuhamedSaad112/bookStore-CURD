package com.global.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Book;
import com.global.book.entity.Cart;
import com.global.book.entity.CartItem;
import com.global.book.entity.User;
import com.global.book.repository.CartRepo;

@Service
public class CartService extends BaseService<Cart, Long> {

	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	public Cart findById(Long id) {

		return cartRepo.findById(id).get();
	}

	public Cart findByUserId(Long userId) {

		return cartRepo.findByUserId(userId);
	}

	public Cart insert(Cart entity) {
		return cartRepo.save(entity);
	}

	public Cart update(Cart entity) {

		Cart dem = findById(entity.getId());
		dem.setItems(entity.getItems());
		dem.setUser(entity.getUser());

		return cartRepo.save(dem);

	}

	public CartItem addItemToCart(Long userId, Long bookId, Long quantity) {
		Cart cart = findByUserId(userId);
		if (cart == null) {

			User user = userService.findById(userId);

			cart = new Cart(user);
			insert(cart);
		}
		CartItem cartItem = new CartItem();
		Book book = bookService.findById(bookId);
		cartItem.setCart(cart);
		cartItem.setBook(book);
		cartItem.setQuantity(quantity);
		cartItemService.insert(cartItem);
		return cartItem;
	}

	public CartItem updateCartItem(Long bookId, Long quantity) {
		CartItem cartItem = cartItemService.findByBookId(bookId);

		cartItem.setQuantity(quantity);

		cartItemService.update(cartItem);

		return cartItem;
	}

	public void deleteCartItem(Long bookId) {
		CartItem cartItem = cartItemService.findByBookId(bookId);
		cartItemService.delete(cartItem);

	}

}
