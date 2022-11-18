package com.bnt.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class MyException {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String, String> handleBusinessException(StudentNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<String, String>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public  Map<String, String> handaleBadRequest(MethodArgumentTypeMismatchException ex) {
		Map<String, String> errorMap = new HashMap<String, String>();
		  errorMap.put("errorMessage", "please provide valid integer number");
	        return errorMap;
	}

}
