package com.example.studentcourse.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//👉 Means:“This class will listen to exceptions from ALL controllers.”

@ControllerAdvice
public class GlobalExceptionHandler 
{
	
	// Handle Resource Not Found Exception
	//👉 Means:	“If ResourceNotFoundException happens anywhere,come here.”
  @ExceptionHandler(ResourceNotFoundException.class)
   
  // ✅ Method for Resource Not Found-->  * Catches the exception, *  Reads its message

  public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex)
    {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

                
    }

    // Handle all other exceptions (optional but good practice)
  
  //✅ Generic Exception Handler 
  //👉 Catches: nNullPointerException ,   Any unexpected error

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {

    	//✅ HTTP 500 Response ---> INTERNAL_SERVER_ERROR
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong: " + ex.getMessage());
                
                
    }
}
/* 
 
 
 
 
 
 * */	


