package com.ashbel.book_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashbel.book_store.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	 List<Book> findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(String name, String author);
}
