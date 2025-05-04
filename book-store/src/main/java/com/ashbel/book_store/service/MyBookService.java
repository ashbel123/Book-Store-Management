package com.ashbel.book_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashbel.book_store.entity.MyBook;
import com.ashbel.book_store.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepository myBRepo;
	
	public void saveMyBooks(MyBook b) {
		myBRepo.save(b);
	}
	
	public List<MyBook> getMyBooks() {
		return myBRepo.findAll();
	}
	
	public void deleteById(int id) {
		myBRepo.deleteById(id);
	}
}
