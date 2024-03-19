package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import telran.strings.Validations;

class ValidationsTest {

    @Test
    void isArithmeticExpressionTest() {
    	assertTrue(Validations.isArithmeticExpression("20 + 3 * (5 - 2)"));
        assertFalse(Validations.isArithmeticExpression("2 +() 3"));
    }
}
