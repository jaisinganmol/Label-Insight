package Problem1;

import java.util.Scanner;

/**
 * Entry point for the MissingLetter application.
 */

public class MissingLetterTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MissingLetters missingString = new MissingLetters();


        while (true) {
            System.out.print("Enter String: ");
            String userInput = scanner.nextLine();


            // Scanner end condition i.e. -1

            if (userInput.equals("-1")) {
                System.exit(0);
                scanner.close();
            }

            String output = missingString.getMissingLetters(userInput);
            System.out.println(output);
        }
    }
}