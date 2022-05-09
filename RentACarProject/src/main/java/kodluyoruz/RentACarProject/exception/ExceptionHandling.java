package kodluyoruz.RentACarProject.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> methodNullPointerExceptionHandler(NullPointerException e) {

		return new ResponseEntity<>("Null data entered: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {

		return new ResponseEntity<>("An exception has occured: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException e) {

		return new ResponseEntity<String>("Entity not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
