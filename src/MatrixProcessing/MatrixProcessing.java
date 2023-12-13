import java.util.Scanner;

public class MatrixProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо матрицю
        System.out.println("Enter matrix:");
        int[][] matrix = readMatrix(scanner);

        // Зчитуємо константу
        System.out.println("\nEnter constant:");
        int constant = scanner.nextInt();

        // Множимо матрицю на константу
        int[][] result = multiplyMatrixByConstant(matrix, constant);

        // Виводимо результат
        printMatrix(result);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

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

    private static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }
}
