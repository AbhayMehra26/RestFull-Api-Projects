package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByCategoryIgnoreCase(String category);

	List<Book> findByAuthorIgnoreCase(String author);

}
