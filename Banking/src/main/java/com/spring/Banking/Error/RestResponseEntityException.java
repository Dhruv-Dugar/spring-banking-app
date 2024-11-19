package com.spring.Banking.Error;


import com.spring.Banking.Model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestResponseEntityException {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage customerNotFoundExceptionHandler(CustomerNotFoundException e){
		return new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
	}

}
