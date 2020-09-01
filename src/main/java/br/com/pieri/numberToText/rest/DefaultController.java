package br.com.pieri.numberToText.rest;

import br.com.pieri.numberToText.rest.exceptions.ApiErrors;
import br.com.pieri.numberToText.service.NumberToTextService;
import br.com.pieri.numberToText.vo.TextValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DefaultController {

	@RequestMapping
	public ApiErrors defaultRoute(){
		ApiErrors error = new ApiErrors("São esperados valores entre -99.999 e 99.999");
		return error;
	}
}
