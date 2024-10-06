package com.global.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Role;
import com.global.book.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/{id}")
	public Role findById(@PathVariable Long id) {

		return roleService.findById(id);
	}

	@GetMapping("")
	public List<Role> findAll() {

		return roleService.findAll();
	}

	@GetMapping("/count")
	public Long countAll() {
		return roleService.countAll();

	}

	@PostMapping("")
	public Role insert(@RequestBody @Valid Role entity) {
		return roleService.insert(entity);
	}

	@PutMapping("")
	public Role updata(@RequestBody @Valid Role entity) {

		return roleService.updata(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		roleService.delete(id);
	}

	@GetMapping("/exist/{id}")
	public boolean existsById(@PathVariable Long id) {
		return roleService.existsById(id);
	}

}