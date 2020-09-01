package br.com.pieri.numberToText.rest;

import br.com.pieri.numberToText.rest.exceptions.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationError(IllegalArgumentException ex){
		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());
		ApiErrors apiErrors = new ApiErrors(errors);
		return apiErrors;
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException e){
		String msgError = e.getMessage();
		HttpStatus status = e.getStatus();
		ApiErrors apiError = new ApiErrors(msgError);
		ResponseEntity responseEntity = new ResponseEntity(apiError, status);
		return responseEntity;
	}
}
