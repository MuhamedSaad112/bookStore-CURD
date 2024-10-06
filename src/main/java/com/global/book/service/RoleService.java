package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Role;
import com.global.book.repository.RoleRepo;

@Service
public class RoleService extends BaseService<Role, Long> {

	@Autowired
	private RoleRepo roleRepo;

	public Role findById(Long id) {

		return roleRepo.findById(id).get();
	}

	public List<Role> findAll() {

		return roleRepo.findAll();
	}

	public Role insert(Role entity) {
		return roleRepo.save(entity);
	}

	public Role updata(Role entity) {

		Role dem = findById(entity.getId());

		dem.setName(entity.getName());

		return roleRepo.save(dem);
	}

	public void delete(Role entity) {
		roleRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return roleRepo.existsById(id);

	}

	public Long countAll() {
		return roleRepo.count();

	}
}
