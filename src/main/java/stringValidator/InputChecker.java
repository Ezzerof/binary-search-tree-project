package stringValidator;

import java.util.Scanner;

public class InputChecker {

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        boolean isOn = true;
        String nameFormatted = "";

        while (isOn) {
            System.out.println("Welcome to the APP");
            System.out.print("Please provide surname of the employee: ");
            String userInput = scanner.next();
            nameFormatted = NameFormatter.formatName(userInput);

            if (StringValidator.containsNumbersOrSymbols(userInput)) {
                System.out.println("Invalid input. Please enter a string without numbers or symbols.");
            } else {
                System.out.println("Valid input. You entered: " + nameFormatted);
                System.out.println();
                break;
            }

        }

        return nameFormatted;
    }

}
