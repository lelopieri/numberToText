package br.com.pieri.numberToText.rest;

import br.com.pieri.numberToText.service.NumberToTextService;
import br.com.pieri.numberToText.vo.TextValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NumberToTextController {

	@Autowired
	private NumberToTextService service;

	@RequestMapping("{value}")
	public TextValue numberToText(@PathVariable Integer value){
		try {
			return service.toText(value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
