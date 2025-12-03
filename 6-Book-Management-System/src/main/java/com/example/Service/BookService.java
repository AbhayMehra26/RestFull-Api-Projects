package com.example.Service;

import java.util.List;

import com.example.Entity.Book;

public interface BookService {

	void CreateBook(Book book);

	List<Book> GetAllBook();

	List<Book> AllBookCategory(String category);

	List<Book> AllBookAuthor(String author);

	Book GetBooksById(int id);

	void DeleteBookById(int id);

	void UpdateBooksById(Book book);

	void PatchUpdateBooksById(Book oldBook, Book newbook);


}
