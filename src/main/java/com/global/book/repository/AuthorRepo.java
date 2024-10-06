package com.global.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Author;

@Repository
public interface AuthorRepo extends BaseRepository<Author, Long> {
  
	
	@Query("SELECT COUNT(a) FROM Author a")
	long count();

	@Query(value = "SELECT COUNT(*) FROM authors", nativeQuery = true)
	long countN();
	
}
