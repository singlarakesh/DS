package com.example.demo.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class userException extends RuntimeException {

	public userException(String msg) {
		super(msg);
	}
}
