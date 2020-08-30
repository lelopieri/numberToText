package br.com.pieri.numberToText.service;

import br.com.pieri.numberToText.vo.TextValue;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NumberToTextServiceTest {

	@Autowired
	private NumberToTextService service;

	@Test
	public void oneTest() throws Exception {
		//given
		Integer value = 1;
		//when
		TextValue textValue = service.toText(value);
		//them
		assertEquals("um", textValue.getExtenso());
	}

	@Test
	public void negative1042Test() throws Exception {
		Integer value = -1042;
		TextValue textValue = service.toText(value);
		assertEquals("menos mil e quarenta e dois", textValue.getExtenso());
	}

	@Test
	public void positive94587Test() throws Exception {
		Integer value = 94587;
		TextValue textValue = service.toText(value);
		assertEquals("noventa e quatro mil e quinhentos e oitenta e sete", textValue.getExtenso());
	}

	@Test
	public void minusOneTest() throws Exception {
		Integer value = -1;
		TextValue textValue = service.toText(value);
		assertEquals("menos um", textValue.getExtenso());
	}

	@Test
	public void zeroTest() throws Exception {
		Integer value = 0;
		TextValue textValue = service.toText(value);
		assertEquals("zero", textValue.getExtenso());
	}

	@Test
	public void lowerThan20Test() throws Exception {
		Integer value = 18;
		TextValue textValue = service.toText(value);
		assertEquals("dezoito", textValue.getExtenso());
	}

	@Test
	public void lowerThan100Test() throws Exception {
		Integer value = 55;
		TextValue textValue = service.toText(value);
		assertEquals("cinquenta e cinco", textValue.getExtenso());
	}

	@Test
	public void exact20Test() throws Exception {
		Integer value = 20;
		TextValue textValue = service.toText(value);
		assertEquals("vinte", textValue.getExtenso());
	}

	@Test
	public void exact100Test() throws Exception {
		Integer value = 100;
		TextValue textValue = service.toText(value);
		assertEquals("cem", textValue.getExtenso());
	}

	@Test
	public void biggerThan100ATest() throws Exception {
		Integer value = 101;
		TextValue textValue = service.toText(value);
		assertEquals("cento e um", textValue.getExtenso());
	}

	@Test
	public void biggerThan100BTest() throws Exception {
		Integer value = 125;
		TextValue textValue = service.toText(value);
		assertEquals("cento e vinte e cinco", textValue.getExtenso());
	}

	@Test
	public void biggerThan100CTest() throws Exception {
		Integer value = 299;
		TextValue textValue = service.toText(value);
		assertEquals("duzentos e noventa e nove", textValue.getExtenso());
	}

	@Test
	public void exact200Test() throws Exception {
		Integer value = 200;
		TextValue textValue = service.toText(value);
		assertEquals("duzentos", textValue.getExtenso());
	}

	@Test
	public void exact1000Test() throws Exception {
		Integer value = 1000;
		TextValue textValue = service.toText(value);
		assertEquals("mil", textValue.getExtenso());
	}

	@Test
	public void biggerThan1000Test() throws Exception {
		Integer value = 1487;
		TextValue textValue = service.toText(value);
		assertEquals("mil e quatrocentos e oitenta e sete", textValue.getExtenso());
	}

	@Test
	public void biggerThan2000Test() throws Exception {
		Integer value = 2300;
		TextValue textValue = service.toText(value);
		assertEquals("dois mil e trezentos", textValue.getExtenso());
	}

	@Test
	public void perfectThousandTest() throws Exception {
		Integer value = 50000;
		TextValue textValue = service.toText(value);
		assertEquals("cinquenta mil", textValue.getExtenso());
	}

	@Test
	public void minusBiggerThan1000Test() throws Exception {
		Integer value = -1487;
		TextValue textValue = service.toText(value);
		assertEquals("menos mil e quatrocentos e oitenta e sete", textValue.getExtenso());
	}

	@Test
	public void negativeEdgeTest() throws Exception {
		Integer value = -99999;
		TextValue textValue = service.toText(value);
		assertEquals("menos noventa e nove mil e novecentos e noventa e nove", textValue.getExtenso());
	}

	@Test
	public void positiveEdgeTest() throws Exception {
		Integer value = 99999;
		TextValue textValue = service.toText(value);
		assertEquals("noventa e nove mil e novecentos e noventa e nove", textValue.getExtenso());
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void invalidArgument() throws Exception {
		Integer value = 999999;
		Throwable t = assertThrows(IllegalArgumentException.class, () -> service.toText(value));
		assertEquals("São esperados valores entre -99.999 e 99.999", t.getMessage());
	}

	@Test
	public void invalidArgumentB() throws Exception {
		Integer value = -100000;
		Throwable t = assertThrows(IllegalArgumentException.class, () -> service.toText(value));
		assertEquals("São esperados valores entre -99.999 e 99.999", t.getMessage());
	}

}