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
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Функція для перевірки можливості перемоги для символу на ігровому полі
    private static boolean checkWin(char[][] board, char symbol) {
        // Перевірка рядків і стовпців
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol) && (board[i][1] == symbol) && (board[i][2] == symbol)) {
                return true; // Перемога у рядку
            }
            if ((board[0][i] == symbol) && (board[1][i] == symbol) && (board[2][i] == symbol)) {
                return true; // Перемога у стовпці
            }
        }

        // Перевірка діагоналей
        if ((board[0][0] == symbol) && (board[1][1] == symbol) && (board[2][2] == symbol)) {
            return true; // Перемога на головній діагоналі
        }
        if ((board[0][2] == symbol) && (board[1][1] == symbol) && (board[2][0] == symbol)) {
            return true; // Перемога на додатковій діагоналі
        }
        return false;
    }

    // Функція для аналізу стану гри
    private static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (board[row][col] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }

    private static void analyzeGameState(char[][] board) {
        int countX = 0;
        int countO = 0;
        int countEmpty = 0;

        // Підрахунок кількості "X", "O" та порожніх клітинок
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    countX++;
                } else if (board[i][j] == 'O') {
                    countO++;
                } else {
                    countEmpty++;
                }
            }
        }

        // Перевірка можливості перемоги
        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');

        // Аналіз стану гри та виведення результату
        if (Math.abs(countX - countO) >= 2 || (xWins && oWins)) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (countEmpty == 0) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }
    public static void main(String[] args) {
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

        // Аналіз стану гри
        analyzeGameState(gameBoard);
        boolean validMove = false;
        do {
            System.out.print("Enter the coordinates: ");
            try {
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                if (isValidMove(gameBoard, row, col)) {
                    gameBoard[row][col] = 'X';
                    validMove = true;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        } while (!validMove);

        printBoard(gameBoard);

        if (checkWin(gameBoard, 'X')) {
            System.out.println("X wins");
        } else {
            analyzeGameState(gameBoard);
        }

        // Закриття сканера
        scanner.close();
    }
}