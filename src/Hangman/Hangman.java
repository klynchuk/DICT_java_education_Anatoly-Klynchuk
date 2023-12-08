import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("HANGMAN");

        while (true) {
            System.out.println("Type \"play\" to play the game, \"exit\" to quit:");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            } else if (command.equals("play")) {
                playHangman(scanner, random);
            } else {
                System.out.println("Unknown command. Type \"play\" to play the game, \"exit\" to quit.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void playHangman(Scanner scanner, Random random) {
        String[] words = {"python", "java", "javascript", "kotlin"};
        int randomIndex = random.nextInt(words.length);
        String wordToGuess = words[randomIndex];
        int lives = 8; // Кількість життів
        Set<Character> guessedLetters = new HashSet<>();
        StringBuilder wordInProgress = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordInProgress.append("-");
        }
        while (lives > 0) {
            System.out.println(wordInProgress);
            System.out.println("Input a letter: >");
            String inputLetter = scanner.nextLine().toLowerCase();

            if (inputLetter.length() != 1 || !Character.isLowerCase(inputLetter.charAt(0))) {
                System.out.println("Please enter a lowercase English letter");
            } else {
                char letter = inputLetter.charAt(0);
                if (guessedLetters.contains(letter)) {
                    System.out.println("You've already guessed this letter");
                } else {
                    guessedLetters.add(letter);
                    if (wordToGuess.contains(inputLetter)) {
                        if (wordInProgress.toString().contains(inputLetter)) {
                            System.out.println("No improvements");
                            lives--;
                        } else {
                            for (int i = 0; i < wordToGuess.length(); i++) {
                                if (wordToGuess.charAt(i) == letter) {
                                    wordInProgress.setCharAt(i, letter);
                                }
                            }
                        }
                    } else {
                        System.out.println("That letter doesn't appear in the word");
                        lives--;
                    }

                    if (!wordInProgress.toString().contains("-")) {
                        System.out.println(wordInProgress);
                        System.out.println("You guessed the word!");
                        System.out.println("You guessed the word " + wordToGuess + "!");
                        System.out.println("You survived!");
                        break;
                    }
                }
            }
        }

        if (lives == 0) {
            System.out.println("You lost!");
        }

        guessedLetters.clear();  // Очищуємо введені букви для наступної гри
    }
}