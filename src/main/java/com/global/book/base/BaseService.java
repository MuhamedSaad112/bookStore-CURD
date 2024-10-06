package com.global.book.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID> {

	@Autowired
	BaseRepository<T, ID> baseRepository;

	public T findById(ID id) {

		return baseRepository.findById(id).get();
	}

	public List<T> findAll() {

		return baseRepository.findAll();
	}

	public T insert(T entity) {
		return baseRepository.save(entity);
	}

	public void delete(ID entity) {
		baseRepository.deleteById(entity);
	}

	public boolean existsById(ID id) {
		return baseRepository.existsById(id);

	}
}
