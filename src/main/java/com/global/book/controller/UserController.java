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

import com.global.book.entity.User;
import com.global.book.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {

		return userService.findById(id);
	}

	@GetMapping("")
	public List<User> findAll() {

		return userService.findAll();
	}

	@GetMapping("/count")
	public Long countAll() {
		return userService.countAll();

	}

	@PostMapping("")
	public User insert(@RequestBody @Valid User entity) {
		return userService.insert(entity);
	}

	@PutMapping("")
	public User updata(@RequestBody @Valid User entity) {

		return userService.updata(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable Long id) {
		return userService.existsById(id);
	}

}
