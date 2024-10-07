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

import com.global.book.entity.ShippingAddress;
import com.global.book.service.ShippingAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/shippingaddress")
@Validated
public class ShippingAddressController {

	@Autowired
	private ShippingAddressService addressService;

	@PostMapping("")
	public ShippingAddress addShippingAddress(@RequestBody @Valid ShippingAddress address) {
		return addressService.insert(address);
	}

	@GetMapping("/user/{userId}")
	public List<ShippingAddress> getAddressesByUserId(@PathVariable Long userId) {

		return addressService.findByAddressByUserId(userId);
	}

	@PutMapping("")
	public ShippingAddress updateShippingAddress(@RequestBody @Valid ShippingAddress address) {

		return addressService.update(address);
	}

	@DeleteMapping("/{id}")
	public void deleteShippingAddress(@PathVariable Long id) {

		addressService.delete(id);
	}
}