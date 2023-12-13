import java.util.Scanner;

public class TicTacToe {

    // Функція для друку ігрового поля
    private static void printBoard(char[][] board) {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        // Приклад використання
        char[][] exampleBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        printBoard(exampleBoard);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        char[][] gameBoard = new char[3][3];
        int index = 0;

        // Заповнення ігрового поля з введеного рядка
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = input.charAt(index);
                index++;
            }
        }

        // Друк ігрового поля
        printBoard(gameBoard);

        // Закриття сканера
        scanner.close();
    }
}