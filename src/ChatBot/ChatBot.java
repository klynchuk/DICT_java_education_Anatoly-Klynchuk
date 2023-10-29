import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Bot.");
        int birthYear = java.time.Year.now().getValue();
        System.out.println("I was created in " + birthYear + ".");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7:");

        float remainder3 = scanner.nextInt();
        float remainder5 = scanner.nextInt();
        float remainder7 = scanner.nextInt();

        float userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
    }
}
