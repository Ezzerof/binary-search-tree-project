package com.room2.bstProject.stringValidator;

public interface StringValidator {
    //Validates input to ensure a name has been entered
    static boolean containsNumbersOrSymbols(String input) {
        return input.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

}
