import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstant(scanner);
                    break;
                case 3:
                    multiplyMatrices(scanner);
                    break;
                case 4:
                    transposeMatrixMenu(scanner);
                    break;
                case 5:
                    calculateDeterminant(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);
    }

    private static void addMatrices(Scanner scanner) {
        // код для додавання матриць, аналогічний попереднім етапам
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        // код для множення матриці на константу, аналогічний попереднім етапам
    }

    private static void multiplyMatrices(Scanner scanner) {
        // код для множення матриць, аналогічний попереднім етапам
    }

    private static void transposeMatrixMenu(Scanner scanner) {
        // код для транспонування матриці, аналогічний попереднім етапам
    }

    private static void calculateDeterminant(Scanner scanner) {
        System.out.println("Enter matrix size: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        if (rows == cols) {
            int determinant = calculateDeterminantRecursive(matrix);
            System.out.println("The result is: " + determinant);
        } else {
            System.out.println("The determinant can only be calculated for a square matrix.");
        }
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int calculateDeterminantRecursive(int[][] matrix) {
        int size = matrix.length;
        if (size == 1) {
            return matrix[0][0];
        } else if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int determinant = 0;
            for (int j = 0; j < size; j++) {
                determinant += matrix[0][j] * cofactor(matrix, 0, j);
            }
            return determinant;
        }
    }

    private static int cofactor(int[][] matrix, int row, int col) {
        int size = matrix.length;
        int[][] minorMatrix = new int[size - 1][size - 1];
        int minorRow = 0, minorCol;

        for (int i = 0; i < size; i++) {
            if (i == row) {
                continue;
            }
            minorCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) {
                    continue;
                }
                minorMatrix[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }

        int sign = (row + col) % 2 == 0 ? 1 : -1;
        return sign * calculateDeterminantRecursive(minorMatrix);
    }
}
