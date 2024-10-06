package com.global.book.entity;

import com.global.book.base.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cart_items")
public class CartItem extends BaseEntity<Long> {

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Cart cart;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Book book;
	@NotNull
	private Long quantity;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
