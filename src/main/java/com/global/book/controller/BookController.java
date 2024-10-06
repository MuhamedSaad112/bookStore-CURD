package com.global.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Book;
import com.global.book.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/book")
@Validated
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id) {

		return bookService.findById(id);
	}

	@GetMapping("")
	public List<Book> findAll() {

		return bookService.findAll();
	}

	@GetMapping("/count")
	public Long countAll() {
		return bookService.countAll();

	}

	@PostMapping("")
	public Book insert(@RequestBody @Valid Book entity) {
		return bookService.insert(entity);
	}

	@PutMapping("")
	public Book updata(@RequestBody @Valid Book entity) {

		return bookService.updata(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable Long id) {
		return bookService.existsById(id);
	}

}
