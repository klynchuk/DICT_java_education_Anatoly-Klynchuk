import java.util.Scanner; // Импортируем класс Scanner

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Bot.");
        int birthYear = java.time.Year.now().getValue();
        System.out.println("I was created in " + birthYear + ".");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");
    }
}
