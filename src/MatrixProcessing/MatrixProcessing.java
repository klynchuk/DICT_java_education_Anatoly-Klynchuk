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
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);
    }

    private static void addMatrices(Scanner scanner) {
        System.out.println("Enter size of first matrix: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(rowsA, colsA, scanner);

        System.out.println("Enter size of second matrix: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(rowsB, colsB, scanner);

        if (rowsA == rowsB && colsA == colsB) {
            int[][] resultMatrix = addMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed. Matrices have different sizes.");
        }
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.println("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        System.out.println("Enter constant: ");
        int constant = scanner.nextInt();

        int[][] resultMatrix = multiplyMatrixByConstant(matrix, constant);
        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    private static void multiplyMatrices(Scanner scanner) {
        System.out.println("Enter size of first matrix: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(rowsA, colsA, scanner);

        System.out.println("Enter size of second matrix: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(rowsB, colsB, scanner);

        if (colsA == rowsB) {
            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed. Number of columns in the first matrix " +
                    "should be equal to the number of rows in the second matrix.");
        }
    }

    private static void transposeMatrixMenu(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        int transposeChoice = scanner.nextInt();

        System.out.println("Enter matrix size: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        int[][] resultMatrix = transposeMatrix(matrix, transposeChoice);
        System.out.println("The result is:");
        printMatrix(resultMatrix);
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

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return resultMatrix;
    }

    private static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] * constant;
            }
        }

        return resultMatrix;
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        int[][] resultMatrix = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }

    private static int[][] transposeMatrix(int[][] matrix, int transposeChoice) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[cols][rows];

        switch (transposeChoice) {
            case 1:
                // Main diagonal
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        resultMatrix[i][j] = matrix[j][i];
                    }
                }
                break;
            case 2:
                // Side diagonal
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        resultMatrix[i][j] = matrix[rows - 1 - j][cols - 1 - i];
                    }
                }
                break;
            case 3:
                // Vertical line
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        resultMatrix[i][j] = matrix[i][rows - 1 - j];
                    }
                }
                break;
            case 4:
                // Horizontal line
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        resultMatrix[i][j] = matrix[cols - 1 - i][j];
                    }
                }
                break;
            default:
                System.out.println("Invalid choice for transpose.");
        }

        return resultMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
