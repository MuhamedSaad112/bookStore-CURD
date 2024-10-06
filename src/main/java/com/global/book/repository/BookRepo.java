package com.global.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Book;

@Repository
public interface BookRepo extends BaseRepository<Book, Long> {
	
	
	
	@Query(value = "SELECT COUNT(*) FROM books", nativeQuery = true)
	long count();
}
