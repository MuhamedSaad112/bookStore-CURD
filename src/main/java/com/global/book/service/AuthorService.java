package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Author;
import com.global.book.repository.AuthorRepo;

@Service
public class AuthorService extends BaseService<Author, Long> {

	@Autowired
	private AuthorRepo authorRepo;

	public Author findById(Long id) {

		return authorRepo.findById(id).get();
	}

	public List<Author> findAll() {

		return authorRepo.findAll();
	}

	public Author insert(Author entity) {
		return authorRepo.save(entity);
	}

	public Author updata(Author entity) {

		Author dem = findById(entity.getId());
		dem.setName(entity.getName());
		dem.setBio(entity.getBio());

		return authorRepo.save(dem);
	}

	public void delete(Author entity) {
		authorRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return authorRepo.existsById(id);

	}

	public Long countAll() {
		return authorRepo.count();

	}

}
