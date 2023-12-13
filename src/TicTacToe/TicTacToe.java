import java.util.Scanner;

public class TicTacToe {
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

    private static boolean checkWin(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol) && (board[i][1] == symbol) && (board[i][2] == symbol)) {
                return true; // Победа в ряду
            }
            if ((board[0][i] == symbol) && (board[1][i] == symbol) && (board[2][i] == symbol)) {
                return true; // Победа в столбце
            }
        }
        if ((board[0][0] == symbol) && (board[1][1] == symbol) && (board[2][2] == symbol)) {
            return true; // Победа в главной диагонали
        }
        if ((board[0][2] == symbol) && (board[1][1] == symbol) && (board[2][0] == symbol)) {
            return true; // Победа в дополнительной диагонали
        }
        return false;
    }

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
        boolean xWins = checkWin(board, 'X');
        boolean oWins = checkWin(board, 'O');
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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = input.charAt(index);
                index++;
                gameBoard[i][j] = ' ';
            }
        }

        printBoard(gameBoard);

        boolean validMove;

        do {
            boolean xTurn = true;

            while (true) {
                char symbol = xTurn ? 'X' : 'O';

                System.out.print("Enter the coordinates: ");

                try {
                    if (!scanner.hasNextInt()) {
                        System.out.println("You should enter numbers!");
                        scanner.nextLine();
                        continue;
                    }

                    int row = scanner.nextInt() - 1;

                    if (!scanner.hasNextInt()) {
                        System.out.println("You should enter numbers!");
                        scanner.nextLine();
                        continue;
                    }

                    int col = scanner.nextInt() - 1;

                    if (isValidMove(gameBoard, row, col)) {
                        gameBoard[row][col] = symbol;
                        printBoard(gameBoard);

                        if (checkWin(gameBoard, symbol)) {
                            System.out.println(symbol + " wins");
                            break;
                        }

                        analyzeGameState(gameBoard);

                        xTurn = !xTurn; // Переключение игроков
                    }
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    System.out.println("Invalid input! Try again.");
                    scanner.nextLine();
                }
            }

            validMove = true;

            printBoard(gameBoard);

            if (checkWin(gameBoard, 'X')) {
                System.out.println("X wins");
            } else {
                analyzeGameState(gameBoard);
            }

        } while (!validMove);

        scanner.close();
    }
}