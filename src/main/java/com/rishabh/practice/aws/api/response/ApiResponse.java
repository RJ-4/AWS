package com.rishabh.practice.aws.api.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

	@JsonProperty(value = "status_code")
	private Integer statusCode;
	
	private String message;
	
	private Result<T> result;
	
	private boolean successful;
	
	private LocalDateTime timestamp;
	
	public ApiResponse(String message, T result) {
		this(message);
		this.result = new Result<T>(result);
	}
	
	public ApiResponse(String message, List<T> result) {
		this(message);
		this.result = new Result<T>(result);
	}
	
	public ApiResponse(String message, Integer statusCode) {
		this.message = message;
		this.statusCode = statusCode;
		successful = false;
		timestamp = LocalDateTime.now();
	}
	
	public ApiResponse(String message) {
		this.message = message;
		statusCode = 200;
		timestamp = LocalDateTime.now();
		successful = true;
	}
}
