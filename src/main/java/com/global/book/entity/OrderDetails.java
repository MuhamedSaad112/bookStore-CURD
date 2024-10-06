package com.global.book.entity;

import com.global.book.base.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrderDetails extends BaseEntity<Long> {

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Book book;
	@NotNull
	private Long quantity;
	@NotNull
	private Long price;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
