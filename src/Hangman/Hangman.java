import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");
        System.out.println("Guess the word: >");

        String wordToGuess = "java"; // Слово, яке гравцеві потрібно вгадати
        String playerGuess = scanner.nextLine();

        if (playerGuess.equals(wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}