package com.global.book.controller;

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

import com.global.book.entity.OrderDetails;
import com.global.book.service.OrderDetailsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/OrderDetails")
@Validated
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService detailsService;

	@GetMapping("/order/{id}")
	OrderDetails findByOrderId(@PathVariable Long id) {
		return detailsService.findByOrderId(id);
	}

	@GetMapping("/{id}")
	public OrderDetails findById(@PathVariable Long id) {

		return detailsService.findById(id);
	}

	@PostMapping("")
	public OrderDetails insert(@RequestBody @Valid OrderDetails entity) {
		return detailsService.insert(entity);
	}

	@PutMapping("")
	public OrderDetails update(@RequestBody @Valid OrderDetails entity) {

		return detailsService.update(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		detailsService.delete(id);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@Valid Long id) {
		return detailsService.existsById(id);

	}

}
