package org.jsp.springmock.helper;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	String message;
	int statusCode;
	T data;
	
}
