package com.global.book.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.book.base.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cart extends BaseEntity<Long> {

	@NotNull
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private User user;

	@OneToMany(mappedBy = "cart", cascade = { CascadeType.ALL })
	@JsonManagedReference
	private List<CartItem> items;

	public Cart(@NotNull User user) {
		super();
		this.user = user;
	}

	public Cart() {
		super();

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;

	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
