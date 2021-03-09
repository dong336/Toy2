package com.study.common;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice("com.study")
public class CommonExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		System.out.println(e.getLocalizedMessage());
		System.out.println(e.getMessage());
		System.out.println(e.toString());
		return "error/error";
	}
}
