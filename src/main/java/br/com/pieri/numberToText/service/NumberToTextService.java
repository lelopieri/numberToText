package br.com.pieri.numberToText.service;

import br.com.pieri.numberToText.enums.TextValueEnum;
import br.com.pieri.numberToText.vo.TextValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberToTextService {

	public TextValue toText(Integer value) {
		String text = translateNumberToText(value);
		return new TextValue(text);
	}

	private String translateNumberToText(Integer value)  {

//		this method suports from -999,999 up to 999,999, but
		if(value < -99999 || value > 99999){
			List<String> errors = new ArrayList<>();
			throw new IllegalArgumentException("São esperados valores entre -99.999 e 99.999");
		}

		String text = "";
		Integer localValue = value;

		if(localValue < 0){
			text += "menos ";
			localValue = localValue * -1;
		}

		if(localValue == 100) {
			text +=  "cem";
		}else if(localValue > 1000){
			Integer thousands = localValue / 1000;
			if(thousands == 1){
				thousands = thousands * 1000;
				text +=	TextValueEnum.getByValue(thousands).getText();
			}else{
				text += translateNumberToText(thousands);
				text += " mil";
			}
			Integer rest = localValue % 1000;
			if(rest > 0){
				text += " e ";
				text += translateNumberToText(rest);
			}
		}else if (localValue > 100){
			Integer hundreds = localValue / 100;
			Integer rest = localValue % 100;
			hundreds = hundreds * 100;
			text += TextValueEnum.getByValue(hundreds).getText();
			if(rest > 0){
				text += " e " + translateNumberToText(rest);
			}
		}else if(localValue > 20) {
//			TODO ferify if is possivle to refactor this and the above if block in a method
			Integer dozens = localValue / 10;
			Integer rest = localValue % 10;
			dozens = dozens * 10;
			text += TextValueEnum.getByValue(dozens).getText();
			if(rest > 0){
				text += " e " + TextValueEnum.getByValue(rest).getText();
			}
		}else{
			text += TextValueEnum.getByValue(localValue).getText();
		}

		return text;
	}
}
