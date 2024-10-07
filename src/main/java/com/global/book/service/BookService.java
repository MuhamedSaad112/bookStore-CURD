package com.global.book.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Author;
import com.global.book.entity.Book;
import com.global.book.entity.Categories;
import com.global.book.repository.BookRepo;
import com.global.book.repository.CategoriesRepo;

@Service
public class BookService extends BaseService<Book, Long> {

	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoriesRepo categoriesRepo;

	public Book findById(Long id) {

		return bookRepo.findById(id).get();
	}

	public List<Book> findAll() {

		return bookRepo.findAll();
	}

	public Book insert(Book entity) {

		if (entity.getAuthor() != null && entity.getAuthor().getId() != null) {
			Author author = authorService.findById(entity.getAuthor().getId());
			entity.setAuthor(author);
		}

		Set<Categories> categories = new HashSet<>();
		for (Categories category : entity.getCategories()) {
			if (category.getId() != null) {
				Categories existingCategory = categoriesRepo.findById(category.getId()).orElseThrow();
				categories.add(existingCategory);
			}
		}

		entity.setCategories(categories);

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
