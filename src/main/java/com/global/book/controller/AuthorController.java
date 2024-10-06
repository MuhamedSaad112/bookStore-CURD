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

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/author")
@Validated
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/{id}")
	public Author findById(@PathVariable Long id) {

		return authorService.findById(id);
	}

	@GetMapping("")
	public List<Author> findAll() {

		return authorService.findAll();
	}

	@GetMapping("/count")
	public Long countAll() {
		return authorService.countAll();

	}

	@PostMapping("")
	public Author insert(@RequestBody @Valid Author entity) {
		return authorService.insert(entity);
	}

	@PutMapping("")
	public Author updata(@RequestBody @Valid Author entity) {

		return authorService.updata(entity);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable Long id) {
		return authorService.existsById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		authorService.delete(id);
	}
}
