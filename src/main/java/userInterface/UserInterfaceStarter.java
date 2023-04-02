package userInterface;

import com.room2.bstProject.binaryTree.BinarySearchTree;
import com.room2.bstProject.binaryTree.BinarySearchTreeInterface;
import stringValidator.NameFormatter;
import stringValidator.StringValidator;

import java.util.Scanner;

public class UserInterfaceStarter {

    public static void getUserInput(BinarySearchTreeInterface tree) {
        Scanner scanner = new Scanner(System.in);
        boolean isOn = true;
        String formattedName;


        while (isOn) {
            System.out.println("Welcome!");
            System.out.print("Please enter employee's surname or Q to quit: ");
            String userInput = scanner.next();
            formattedName = NameFormatter.formatName(userInput);
            BinarySearchTree.TreeNode node = tree.findElement(formattedName);


            if ((userInput.equalsIgnoreCase("Q")) || (userInput.equalsIgnoreCase("quit"))) {
                isOn = false;
            } else if (StringValidator.containsNumbersOrSymbols(userInput)) {
                System.out.println("Invalid input. Please enter a string without numbers or symbols.");
            }else {
                System.out.println("You entered: " + formattedName);
                System.out.println();
                UserPrinter.printUser(node.getEmployee());
            }
        }
    }

}
