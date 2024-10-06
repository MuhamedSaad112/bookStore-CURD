package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Categories;
import com.global.book.repository.CategoriesRepo;

@Service
public class CategoriesService extends BaseService<Categories, Long> {

	@Autowired
	private CategoriesRepo categoriesRepo;

	public Categories findById(Long id) {

		return categoriesRepo.findById(id).get();
	}

	public List<Categories> findAll() {

		return categoriesRepo.findAll();
	}

	public Categories insert(Categories entity) {
		return categoriesRepo.save(entity);
	}

	public Categories updata(Categories entity) {

		Categories dem = findById(entity.getId());

		dem.setName(entity.getName());

		return categoriesRepo.save(dem);
	}

	public void delete(Categories entity) {
		categoriesRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return categoriesRepo.existsById(id);

	}

	public Long countAll() {
		return categoriesRepo.count();

	}

}
