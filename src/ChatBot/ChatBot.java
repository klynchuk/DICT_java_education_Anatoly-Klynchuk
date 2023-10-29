import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is GPT-3.5 ChatBot.");
        int birthYear = java.time.Year.now().getValue();
        System.out.println("I was created in " + birthYear + ".");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();
        System.out.println("What a great name you have, " + userName + "!");

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7:");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");

        System.out.println("Now, please enter a positive number: ");
        int userInp = scanner.nextInt();

        System.out.println("Now I will test your programming knowledge.");

        String[] questions = {
                "What is the capital of France?\n1. Berlin\n2. Madrid\n3. Paris\n4. London",
                "Which programming language is known for its flexibility and readability?\n1. Java\n2. Python\n3. C++\n4. Ruby",
                "How many bits are in a byte?\n1. 4 bits\n2. 8 bits\n3. 16 bits\n4. 32 bits"
        };

        int[] correctAnswers = {3, 2, 2};
        int score = 0;

        System.out.println("Now I will prove to you that I can count to any number you want!");
        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":\n" + questions[i]);
            int userAnswer = scanner.nextInt();
            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct! Good job!");
                score++;
            } else {
                System.out.println("Wrong answer. Try again.");
            }
        }

        if (score == questions.length) {
            System.out.println("Congratulations! You got all the questions correct.");
        } else {
            System.out.println("You got " + score + " out of " + questions.length + " questions correct.");
        }

        System.out.println("Goodbye, have a nice day!");
    }
}
