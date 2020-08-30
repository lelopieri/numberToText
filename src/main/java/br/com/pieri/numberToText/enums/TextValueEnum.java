package br.com.pieri.numberToText.enums;

import java.util.HashMap;

public enum TextValueEnum {
	ZERO(0, "zero"),
	HUM(1, "um"),
	DOIS(2, "dois"),
	TRES(3, "três"),
	QUATRO(4, "quatro"),
	CINCO(5, "cinco"),
	SEIS(6, "seis"),
	SETE(7, "sete"),
	OITO(8, "oito"),
	NOVE(9, "nove"),
	DEZ(10, "dez"),
	ONZE(11, "onze"),
	DOZE(12, "doze"),
	TREZE(13, "treze"),
	QUATORZE(14, "quatorze"),
	QUINZE(15, "quinze"),
	DEZESSEIS(16, "dezesseis"),
	DEZESSETE(17, "dezessete"),
	DEZOITO(18, "dezoito"),
	DEZENOVE(19, "dezenove"),
	VINTE(20, "vinte"),
	TRINTA(30, "trinta"),
	QUARENTA(40, "quarenta"),
	CINQUENTA(50, "cinquenta"),
	SESSENTA(60, "sessenta"),
	SETENTA(70, "setenta"),
	OITENTA(80, "oitenta"),
	NOVENTA(90, "noventa"),
	CENTO(100, "cento"),
	DUZENTOS(200, "duzentos"),
	TREZENTOS(300, "trezentos"),
	QUATROCENTOS(400, "quatrocentos"),
	QUINHENTOS(500, "quinhentos"),
	SEISENTOS(600, "seiscentos"),
	SETECENTOS(700, "setecentos"),
	NOVECENTOS(900, "novecentos"),
	MIL(1000, "mil");

	private Integer value;
	private String text;

	private static HashMap<Integer, TextValueEnum> byValue = new HashMap<>();

	static {
		for(TextValueEnum textValue : values()){
			byValue.put(textValue.value, textValue);
		}
	}

	public static TextValueEnum getByValue(Integer value){
		return byValue.get(value);
	}

	TextValueEnum(Integer value, String text) {
		this.value = value;
		this.text = text;
	}

	public Integer getValue() {
		return value;
	}

	public String getText() {
		return text;
	}
}
