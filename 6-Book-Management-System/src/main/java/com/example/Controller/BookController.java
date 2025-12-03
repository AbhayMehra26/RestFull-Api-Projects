package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Book;
import com.example.Service.BookService;

@RestController
@RequestMapping("Book-Management")
public class BookController 
{
	@Autowired
    private BookService bs;

// http://localhost:8080/Book-Management/addBook	
	
	@PostMapping("addBook")
	public ResponseEntity<Book>addBook(@RequestBody Book book)
	{
		bs.CreateBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
		
	}

// http://localhost:8080/Book-Management/allBook	
	@GetMapping("allBook")
    public ResponseEntity<List<Book>> getAllBooks() 
	{
		List<Book>book=bs.GetAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
	
//http://localhost:8080/Book-Management/Byid?id=104	
	@GetMapping("Byid")
    public ResponseEntity<Book> getBooksById(@RequestParam  int  id) 
	{
		Book book=bs.GetBooksById(id);
		if (book==null)
		 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

//http://localhost:8080/Book-Management/delete?id=109	
	@DeleteMapping("delete")
    public ResponseEntity<Book> DeleteBooks(@RequestParam  int  id) 
	{
		Book book=bs.GetBooksById(id);
		if (book==null)
		 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    bs.DeleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
	
//http://localhost:8080/Book-Management/update?id=106	
	@PutMapping("update")
    public ResponseEntity<Book> UpdateBooks(@RequestParam  int  id ,@RequestBody Book book) 
	{
		Book OldBook=bs.GetBooksById(id);
		if (OldBook==null)
		{	 
			bs.CreateBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}		
		book.setId(id);
	    bs.UpdateBooksById(book);
        return ResponseEntity.status(HttpStatus.OK).body(OldBook);
    }
	
	
// http://localhost:8080/Book-Management/update?id=101	
	@PatchMapping("update")
    public ResponseEntity<Book> PatchUpdateBooks(@RequestParam  int  id ,@RequestBody Book Newbook) 
	{
		Book OldBook=bs.GetBooksById(id);
		if (OldBook==null)
		 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	    bs.PatchUpdateBooksById(OldBook,Newbook);
        return ResponseEntity.status(HttpStatus.OK).body(OldBook);
    }	
	
//http://localhost:8080/Book-Management/m?category=crime
	@GetMapping("m")
	public ResponseEntity<List<Book>> GetAllCategory(@RequestParam String category)
	{
		List<Book>book=bs.AllBookCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(book);
		
	}
	
	
	//http://localhost:8080/Book-Management/a?author=sita
	@GetMapping("a")
	public ResponseEntity<List<Book>> GetAllAutor(@RequestParam String author)
	{
		List<Book>book=bs.AllBookAuthor(author);
		return ResponseEntity.status(HttpStatus.OK).body(book);
		
	}

	
}
