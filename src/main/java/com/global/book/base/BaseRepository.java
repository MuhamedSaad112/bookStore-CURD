package com.global.book.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<ID>, ID> extends JpaRepository<T, ID> {

//	Optional<T> findById(ID id);
//
//	List<T> findAll();
//
//	T save(T entity);
//
//	void delete(T entity);
//
//	boolean existsById(ID id);

}
