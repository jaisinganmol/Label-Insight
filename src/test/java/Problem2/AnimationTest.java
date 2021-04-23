package Problem2;
import java.util.List;
import java.util.Scanner;

/**
 * Entry point for animation application. Reads an integer, then string to produce the desired animation.
 */

public class AnimationTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Animation animation = new Animation();


        while (true) {
            System.out.println("Enter Speed and then String: ");
            int initialSpeed = Integer.parseInt(scanner.nextLine());


            if (initialSpeed == -1 ) {
                System.out.println("End of Program");
                System.exit(0);
                scanner.close();
            }

            String initialInput = scanner.nextLine();

            List<String> output = animation.animate(initialSpeed, initialInput);
            System.out.print(output);
            System.out.println();

        }
    }
}
