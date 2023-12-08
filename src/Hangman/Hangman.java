import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("HANGMAN");
        // Список слів для вибору
        String[] words = {"python", "java", "javascript", "kotlin"};
        // Випадковим чином вибираємо слово зі списку
        int randomIndex = random.nextInt(words.length);
        String wordToGuess = words[randomIndex];

        System.out.println("Guess the word: >");
        // Виводимо підказку з першими двома літерами
        StringBuilder hint = new StringBuilder();
        hint.append(wordToGuess.charAt(0));
        hint.append(wordToGuess.charAt(1));

        for (int i = 2; i < wordToGuess.length(); i++) {
            hint.append("-");
        }

        System.out.println("Guess the word " + hint + ": >");

        String playerGuess = scanner.nextLine();

        if (playerGuess.equals(wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
        scanner.close();
    }
}