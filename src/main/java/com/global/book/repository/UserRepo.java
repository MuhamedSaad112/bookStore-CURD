package com.global.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.User;

@Repository
public interface UserRepo extends BaseRepository<User, Long> {

	@Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)
	long count();
}
