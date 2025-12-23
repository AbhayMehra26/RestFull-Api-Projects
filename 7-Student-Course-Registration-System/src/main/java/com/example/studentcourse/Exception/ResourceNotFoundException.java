package com.example.studentcourse.Exception;

public class ResourceNotFoundException extends  RuntimeException
{
	public ResourceNotFoundException(String message)
	{
        super(message);
    }

}


/*
 public class ResourceNotFoundException extends  RuntimeException{
 👉 This means:
                You are creating your own exception.
				It is a type of RuntimeException.
				Spring will automatically handle it.
 “Resource” means:
					Student
					Course
					Enrollment
					(any data from DB)
 
 ✅ Constructor:
 				public ResourceNotFoundException(String message) {
    			super(message);
}
* 👉 This allows you to send custom error messages, like:
* throw new ResourceNotFoundException("Student not found");

 
 
 
  */
 