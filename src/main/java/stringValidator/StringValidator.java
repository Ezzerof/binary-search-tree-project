package stringValidator;

public class StringValidator {

    public static boolean containsNumbersOrSymbols(String input) {
        return input.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

}
