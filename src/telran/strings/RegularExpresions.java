package telran.strings;

public class RegularExpresions {
	public static String javaVariable() {
		String regex = "([A-Za-z$][\\w$]*|_[\\w$]+)";
		return regex;
	}
	public static String zero_300() {
		String regex = "[1-9]\\d?|[1-2]\\d\\d|300|0";
		return regex;
	}
	public static String ipOctet() {
		// "[0-1]?\\d?\\d|2([0-4]\\d|5[0-5])";
		String regex = "(0|00|000|0?[1-9]\\d?|0?\\d{2}|1\\d{2}|2[0-4]\\d|25[0-5])";
		return regex;
	}
	public static String mobileIsraelPhone() {
		//"(\\+972-?|0)5\\d-?(\\d{3}-\\d{2}-|\\d{2}-?\\d{3}-?)\\d{2}";
		String regex = "(\\+972-5\\d-\\d{7})|(05\\d-\\d{3}-\\d{2}-\\d{2})";
		return regex;
	}
	public static String ipV4Address() {
		String ipOctetExpr = ipOctet();
		return String.format("%1$s(\\.%1$s){3}", ipOctetExpr);
	}
	public static String simpleArithmeticExpresion() {
		String operand = integerNumberExp();
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
		return "^(\\(*\\s*[-+]?[A-Za-z0-9$]+\\s*[+\\-*/]\\s*)+[-+]?[A-Za-z0-9$]+\\s*\\)*$";
	}
}
