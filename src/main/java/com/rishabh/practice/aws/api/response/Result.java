package com.rishabh.practice.aws.api.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Result<T> {

	private List<T> results;
	
	private Integer count;
	
	Result(T result) {
		results = new ArrayList<T>(); 
		results.add(result);
		count = 1;
	}
	
	Result(List<T> results) {
		this.results = results;
		count = results.size();
	}
}
