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
            System.out.println("6. Inverse matrix");
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
                case 6:
                    inverseMatrix(scanner);
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
        System.out.println("Enter the size of the first matrix:");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(rowsA, colsA, scanner);

        System.out.println("Enter the size of the second matrix:");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(rowsB, colsB, scanner);

        if (rowsA == rowsB && colsA == colsB) {
            int[][] result = new int[rowsA][colsA];
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            System.out.println("The result is:");
            printMatrix(result);
        } else {
            System.out.println("Error: Matrices have different sizes and cannot be added.");
        }
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.println("Enter the size of the matrix:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        System.out.println("Enter the constant:");
        int constant = scanner.nextInt();

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void multiplyMatrices(Scanner scanner) {
        System.out.println("Enter the size of the first matrix:");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(rowsA, colsA, scanner);

        System.out.println("Enter the size of the second matrix:");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(rowsB, colsB, scanner);

        if (colsA == rowsB) {
            int[][] result = new int[rowsA][colsB];
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
            System.out.println("The result is:");
            printMatrix(result);
        } else {
            System.out.println("Error: Matrices cannot be multiplied due to incompatible sizes.");
        }
    }

    private static void transposeMatrixMenu(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        int transposeType = scanner.nextInt();

        System.out.println("Enter matrix size:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        int[][] result;

        switch (transposeType) {
            case 1:
                result = transposeMainDiagonal(matrix);
                break;
            case 2:
                result = transposeSideDiagonal(matrix);
                break;
            case 3:
                result = transposeVerticalLine(matrix);
                break;
            case 4:
                result = transposeHorizontalLine(matrix);
                break;
            default:
                System.out.println("Invalid transpose type.");
                return;
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void calculateDeterminant(Scanner scanner) {
        System.out.println("Enter matrix size:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        int determinant = calculateDeterminantRecursive(matrix);
        System.out.println("The result is: " + determinant);
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int calculateDeterminantRecursive(int[][] matrix) {
        int size = matrix.length;

        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < size; i++) {
            determinant += matrix[0][i] * cofactor(matrix, 0, i);
        }

        return determinant;
    }

    private static int cofactor(int[][] matrix, int row, int col) {
        int sign = (row + col) % 2 == 0 ? 1 : -1;
        return sign * calculateDeterminantRecursive(submatrix(matrix, row, col));
    }

    private static int[][] submatrix(int[][] matrix, int rowToRemove, int colToRemove) {
        int size = matrix.length - 1;
        int[][] submatrix = new int[size][size];
        int newRow = 0;
        int newCol;

        for (int i = 0; i < matrix.length; i++) {
            if (i == rowToRemove) {
                continue;
            }

            newCol = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (j != colToRemove) {
                    submatrix[newRow][newCol] = matrix[i][j];
                    newCol++;
                }
            }

            newRow++;
        }

        return submatrix;
    }

    private static void inverseMatrix(Scanner scanner) {
        System.out.println("Enter matrix size:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(rows, cols, scanner);

        int determinant = calculateDeterminantRecursive(matrix);

        if (determinant == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return;
        }

        int[][] adjugate = calculateAdjugate(matrix);
        double[][] inverse = scalarMultiply(adjugate, 1.0 / determinant);

        System.out.println("The result is:");
        printDoubleMatrix(inverse);
    }

    private static int[][] calculateAdjugate(int[][] matrix) {
        int size = matrix.length;
        int[][] adjugate = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sign = (i + j) % 2 == 0 ? 1 : -1;
                int cofactor = sign * calculateDeterminantRecursive(submatrix(matrix, i, j));
                adjugate[j][i] = cofactor; // Transpose the cofactor matrix to get the adjugate
            }
        }

        return adjugate;
    }

    private static double[][] scalarMultiply(int[][] matrix, double scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return result;
    }

    private static void printDoubleMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transposeMainDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }

    private static int[][] transposeSideDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = matrix[rows - 1 - j][cols - 1 - i];
            }
        }

        return result;
    }

    private static int[][] transposeVerticalLine(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][cols - 1 - j];
            }
        }

        return result;
    }

    private static int[][] transposeHorizontalLine(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[rows - 1 - i][j];
            }
        }

        return result;
    }
}
