package com.ashbel.book_store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyBooks") //  to give diff name to table rather than class name. (optional)
public class MyBook {
	
	@Id // we don't use generated because we are not creating.
	private int id;
	private String name;
	private String author;
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public MyBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyBook(int id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
}
