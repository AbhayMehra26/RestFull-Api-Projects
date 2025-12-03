package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Book;
import com.example.Repository.BookRepository;

@Service
public class BookServiceImpl implements  BookService 
{
	@Autowired
    private BookRepository br;

	@Override
	public void CreateBook(Book book) 
	{
		br.save(book);
		
	}

	@Override
	public List<Book> GetAllBook() 
	{
		
		return br.findAll();
	}

	

	@Override
	public List<Book> AllBookCategory(String category) 
	{
		
		return br.findByCategoryIgnoreCase(category);
	}

	@Override
	public List<Book> AllBookAuthor(String author) 
	{
		
		return br.findByAuthorIgnoreCase(author);
	}

	@Override
	public Book GetBooksById(int id) 
	{
		
		return br.findById(id).orElse(null);
	}

	@Override
	public void DeleteBookById(int id) 
	{
		br.deleteById(id);
		
	}

	@Override
	public void UpdateBooksById(Book book) 
	{
		br.save(book);
	}

	@Override
	public void PatchUpdateBooksById(Book oldBook, Book newbook) 
	{
		String title=newbook.getTitle();
		String author=newbook.getAuthor();
		String category=newbook.getCategory();
		Integer price=newbook.getPrice();
		if(title != null)
			oldBook.setTitle(title);
		if(author != null)
			oldBook.setAuthor(author);
		if(category != null)
			oldBook.setCategory(category);
		if(price != null)
			oldBook.setPrice(price);
		
		br.save(oldBook);
		
		
	}
	
	

	
}
