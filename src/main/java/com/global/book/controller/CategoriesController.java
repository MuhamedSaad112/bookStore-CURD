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

import com.global.book.entity.Categories;
import com.global.book.service.CategoriesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	@GetMapping("/{id}")
	public Categories findById(@PathVariable Long id) {

		return categoriesService.findById(id);
	}

	@GetMapping("")
	public List<Categories> findAll() {

		return categoriesService.findAll();
	}

	@GetMapping("/count")
	public Long countAll() {
		return categoriesService.countAll();

	}

	@PostMapping("")
	public Categories insert(@RequestBody @Valid Categories entity) {
		return categoriesService.insert(entity);
	}

	@PutMapping("")
	public Categories updata(@RequestBody @Valid Categories entity) {

		return categoriesService.updata(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoriesService.delete(id);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable Long id) {
		return categoriesService.existsById(id);
	}

}