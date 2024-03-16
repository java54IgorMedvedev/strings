package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.strings.RegularExpresions;

class RegularExpresionsTests {

	@Test
	void javaVariableTrueTest() {
		String regex = RegularExpresions.javaVariable();
		assertTrue("abs".matches(regex));
		assertTrue("a".matches(regex));
		assertTrue("$".matches(regex));
		assertTrue("$123".matches(regex));
		assertTrue("$1_23".matches(regex));
		assertTrue("abs_".matches(regex));
		assertTrue("__".matches(regex));
		assertTrue("Abs_".matches(regex));
	}
	@Test
	void javaVariableFalseTest() {
		String regex = RegularExpresions.javaVariable();
		assertFalse("1abc".matches(regex));
		assertFalse("_".matches(regex));
		assertFalse("a-2".matches(regex));
		assertFalse("a 2".matches(regex));
		assertFalse("a?2".matches(regex));
		assertFalse("i*nt".matches(regex));
	}
	@Test
	void zero_300TrueTest() {
		String regex = RegularExpresions.zero_300();
		assertTrue("0".matches(regex));
		assertTrue("1".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("198".matches(regex));
		assertTrue("299".matches(regex));
		assertTrue("300".matches(regex));
	}
	@Test
	void zero_300FalseTest() {
		String regex = RegularExpresions.zero_300();
		assertFalse("00".matches(regex));
		assertFalse("01".matches(regex));
		assertFalse("19s".matches(regex));
		assertFalse("3980".matches(regex));
		assertFalse("299 ".matches(regex));
		assertFalse("-300".matches(regex));
		assertFalse("301".matches(regex));
	}
	@Test
	void ipOctetTest() {
		String regex = RegularExpresions.ipOctet();
		assertTrue("0".matches(regex));
		assertTrue("00".matches(regex));
		assertTrue("000".matches(regex));
		assertTrue("10".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("199".matches(regex));
		assertTrue("009".matches(regex));
		assertTrue("255".matches(regex));
		assertTrue("250".matches(regex));
		assertTrue("249".matches(regex));
		assertFalse("-0".matches(regex));
		assertFalse("00 ".matches(regex));
		assertFalse("0000".matches(regex));
		assertFalse("10?".matches(regex));
		assertFalse("1900".matches(regex));
		assertFalse("299".matches(regex));
		assertFalse("00a".matches(regex));
		assertFalse("256".matches(regex));
		assertFalse("260".matches(regex));
		assertFalse("300".matches(regex));
	}
	@Test
    void mobileIsraelPhoneTest() {
        String regex = RegularExpresions.mobileIsraelPhone();
        assertTrue("+972-52-1234567".matches(regex), "Matches international format with 52 prefix");
        assertTrue("+972-54-7654321".matches(regex), "Matches international format with 54 prefix");
        assertTrue("052-123-45-67".matches(regex), "Matches domestic format with 052 prefix");
        assertTrue("054-321-76-54".matches(regex), "Matches domestic format with 054 prefix");
        assertFalse("+972-12-1234567".matches(regex), "Invalid prefix for international format");
        assertFalse("0521234567".matches(regex), "Missing dashes in domestic format");
        assertFalse("+972-52-12345678".matches(regex), "Too many digits for international format");
        assertFalse("052-1234-56-78".matches(regex), "Incorrect dash placement in domestic format");
        assertFalse("+972-55 123 45 67".matches(regex), "Spaces instead of dashes");
        assertFalse("054-321-7654".matches(regex), "Incorrect number of digits in domestic format");
    }
}
