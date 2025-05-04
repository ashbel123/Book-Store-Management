package com.ashbel.book_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashbel.book_store.entity.Book;
import com.ashbel.book_store.repository.BookRepository;

@Service
public class bookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	public List<Book> searchByKeyword(String keyword) {
	    return bRepo.findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
	}

}
