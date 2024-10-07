package com.global.book.entity;

import java.util.HashSet;
import java.util.Set;

import com.global.book.base.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long> {

	@NotBlank
	private String title;

	@Min(200)
	private Long price;
	@Min(99999)
	private Long isbn;
	@NotEmpty
	@Lob
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	private Author author;

	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@NotNull
	@JoinTable(name = "sec_books_categories", joinColumns = @JoinColumn(name = "books_id"), inverseJoinColumns = @JoinColumn(name = "categories_id"))
	Set<Categories> categories = new HashSet<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

}
