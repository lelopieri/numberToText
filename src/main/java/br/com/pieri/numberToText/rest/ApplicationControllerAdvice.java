package br.com.pieri.numberToText.rest;

import br.com.pieri.numberToText.rest.exceptions.ApiErrors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	public ApiErrors handleValidationError(MethodArgumentNotValidException ex){
		BindingResult bindingResult = ex.getBindingResult();

		List<String> errors = bindingResult.getAllErrors()
				.stream()
				.map(objectError -> objectError.getDefaultMessage())
				.collect(Collectors.toList());
		ApiErrors apiErrors = new ApiErrors(errors);

		return apiErrors;
	}
}
