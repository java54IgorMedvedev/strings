package telran.strings;

public class Validations {
    public static boolean isArithmeticExpression(String expression) {
        String regex = RegularExpresions.arithmeticExpression();
        if (!expression.matches(regex)) {
            return false;
        }
        
        int counter = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
                if (counter < 0) {
                    return false;
                }
            }
        }
        return counter == 0;
    }
}
