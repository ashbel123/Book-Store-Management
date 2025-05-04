package com.ashbel.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashbel.book_store.entity.MyBook;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Integer> {

}
