package com.rishabh.practice.aws.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rishabh.practice.aws.api.response.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																	HttpHeaders headers, 
																	HttpStatus status, 
																	WebRequest request) {
		
		log.error("Validation failed: " + ex.getMessage());
		ApiResponse<Object> errorResponse = new ApiResponse<>(ex.getBindingResult()
																.getAllErrors()
																.get(0)
																.getDefaultMessage(), 
															 status.value());
		
		return new ResponseEntity<>(errorResponse, status);
	}

}
