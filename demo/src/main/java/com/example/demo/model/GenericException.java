package com.example.demo.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(userException.class)
	public final ResponseEntity<UserResp> handleExceptions(Exception ex, WebRequest request) throws Exception {
		UserResp usr=new UserResp(request.getDescription(true),ex.getMessage());
		return new ResponseEntity<UserResp>(usr,HttpStatus.NOT_FOUND);
	}
}
