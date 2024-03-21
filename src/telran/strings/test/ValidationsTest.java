package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.strings.Validations;

class ValidationsTest {

	@Test
	void isArithmeticExpressionTest() {
		assertTrue(Validations.isArithmeticExpression("(a+b)*(b+a)"));
		assertTrue(Validations.isArithmeticExpression("((a+b)*(b+a)) / 2.5"));
		assertTrue(Validations.isArithmeticExpression("25.5 + 10"));
		assertFalse(Validations.isArithmeticExpression("2 +() 3")); //no regex match;
		assertFalse(Validations.isArithmeticExpression("(20.5 + abc12))*2"));//no brackets parity
		assertFalse(Validations.isArithmeticExpression("(a+b))*((b+a)"));//no brackets parity
		
	}

}