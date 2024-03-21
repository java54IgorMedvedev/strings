package telran.strings;

public class Validations {
public static boolean isArithmeticExpression(String expression) {
	
	//1. Checking against the regular expression
	//2. Checking brackets parity For each '(' there should be ')"
	//consider introducing counter that increased for '(' and decreased for ')'
	//if during passing over the string expression counter < 0 returning false
	//if after passing whole string counter != 0 returning false
	String regex = RegularExpressions.arithmeticExpression();
	boolean regexMatch = expression.matches(regex);
	boolean parityMatch = isBracketsParity(expression);
	return  regexMatch && parityMatch;
}

private static boolean isBracketsParity(String expression) {
	int count = 0;
	int index = 0;
	char[] characters = expression.toCharArray();
	while(index < characters.length && count > -1) {
		if(characters[index] == '(') {
			count++;
		} else if(characters[index] == ')') {
			count--;
		}
		index++;
	}
	return count == 0;
}

}