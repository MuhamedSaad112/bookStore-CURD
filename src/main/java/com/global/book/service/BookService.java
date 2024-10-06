package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;

@Service
public class BookService extends BaseService<Book, Long> {

	@Autowired
	private BookRepo bookRepo;

	public Book findById(Long id) {

		return bookRepo.findById(id).get();
	}

	public List<Book> findAll() {

		return bookRepo.findAll();
	}

	public Book insert(Book entity) {
		return bookRepo.save(entity);
	}

	public Book updata(Book entity) {

		Book dem = findById(entity.getId());

		dem.setTitle(entity.getTitle());
		dem.setPrice(entity.getPrice());
		dem.setIsbn(entity.getIsbn());
		dem.setDescription(entity.getDescription());
		dem.setAuthor(entity.getAuthor());
		dem.setCategories(entity.getCategories());

		return bookRepo.save(dem);
	}

	public void delete(Book entity) {
		bookRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return bookRepo.existsById(id);

	}

	public Long countAll() {
		return bookRepo.count();

	}

}
