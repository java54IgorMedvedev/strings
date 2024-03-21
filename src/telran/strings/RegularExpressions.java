package telran.strings;

public class RegularExpressions {
public static String javaVariable() {
	String regex ="([A-Za-z$][\\w$]*|_[\\w$]+)";
	return regex;
}
public static String zero_300() {
	//string contains number from 0 - 300; leading zeros are disallowed
	String regex = "[1-9]\\d?|[1-2]\\d\\d|300|0"; 
	return regex;
}
public static String ipOctet() {
	//string contains 1 - 3 symbols presenting number from 0 - 255;
	// leading zeros are allowed
	return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
}
public static String mobileIsraelPhone() {
	//string contains possible Israel mobile phone number
	//+972-<prefix two digits beginning from 5>-<7 digits of number>
	//<prefix three digits: first - 0, second 5, third - any>-<7 digits>
	
	return "(\\+972-?|0)5\\d-?(\\d{3}-\\d{2}-|\\d{2}-?\\d{3}-?)\\d{2}";
}
public static String ipV4Address() {
	String ipOctetExpr = ipOctet();
	return String.format("%1$s(\\.%1$s){3}", ipOctetExpr);
}
public static String simpleArithmeticExpression() {
	//operations only binary +,-,*,/
	//operands only integer numbers
	//no brackets 
	String operand = integerNumberExp();
	return commonArithmeticExpression(operand);
}
private static String commonArithmeticExpression(String operand) {
	String operation = operationExp();
	return String.format("%1$s(%2$s%1$s)*", operand, operation);
}
private static String operationExp() {
	
	return "[-+*/]";
}
private static String integerNumberExp() {
	
	return "(\\s*\\d+\\s*)";
}
public static String arithmeticExpression() {
	//operand - any number or Java variable name
	//operation - the same as for simpleArithmeticExpression
	//brackets '(' ')' are allowed
	String operand = arithmeticOperandExpression();
	return commonArithmeticExpression(operand);
}
private static String arithmeticOperandExpression() {
	String variableExp = javaVariable();
	String numberExp = anyNumber();
	return String.format("[\\s(]*(%1$s|%2$s)[\\s)]*", variableExp, numberExp);
}
private static String anyNumber() {
	
	return "\\d*\\.?\\d+";
}
}