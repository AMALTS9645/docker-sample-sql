package com.ust.app.customerapp.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.app.customerapp.dto.ErrorResponse;

@RestControllerAdvice
public class CustomerApiErrorController {

//	@ResponseStatus(code = HttpStatus.NOT_FOUND)
//	@ExceptionHandler(CustomerNotFoundException.class)
//	public String handleCustomerNotFoundException(CustomerNotFoundException ex) {
//
//		return ex.getMessage();
//	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorResponse body = new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(body);
	}

//	@ResponseStatus(code = HttpStatus.CONFLICT)
//	@ExceptionHandler(CustomerAlreadyExistsException.class)
//	public String handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
//		return ex.getMessage();
//	}
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		ErrorResponse body = new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(body);
	}
}
