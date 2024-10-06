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

import com.global.book.entity.Order;
import com.global.book.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
@Validated
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{id}")
	public Order findById(@PathVariable Long id) {

		return orderService.findById(id);
	}

	@GetMapping("")
	public List<Order> findAll() {

		return orderService.findAll();
	}

	@GetMapping("/count")
	public Long countAll() {
		return orderService.countAll();

	}

	@PostMapping("")
	public Order insert(@RequestBody @Valid Order entity) {
		return orderService.insert(entity);
	}

	@PutMapping("")
	public Order updata(@RequestBody @Valid Order entity) {

		return orderService.updata(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		orderService.delete(id);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable Long id) {
		return orderService.existsById(id);
	}

}