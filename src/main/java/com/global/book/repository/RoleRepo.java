package com.global.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Role;

@Repository
public interface RoleRepo extends BaseRepository<Role, Long> {

	@Query(value = "SELECT COUNT(*) FROM Role", nativeQuery = true)
	long count();
}
