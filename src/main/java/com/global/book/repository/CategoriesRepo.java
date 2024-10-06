package com.global.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Categories;

@Repository
public interface CategoriesRepo extends BaseRepository<Categories, Long> {

	@Query(value = "SELECT COUNT(*) FROM categories", nativeQuery = true)
	long count();
}
