import java.util.Scanner;

public class MatrixProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо матрицю A
        System.out.println("Enter matrix A:");
        int[][] matrixA = readMatrix(scanner);

        // Зчитуємо матрицю B
        System.out.println("\nEnter matrix B:");
        int[][] matrixB = readMatrix(scanner);

        // Додаємо матриці, якщо це можливо
        int[][] result = addMatrices(matrixA, matrixB);

        // Виводимо результат або повідомлення про помилку
        if (result != null) {
            System.out.println("\nSum of matrices A and B:");
            printMatrix(result);
        } else {
            System.out.println("ERROR");
        }
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

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            return null; // Повертаємо null, якщо додавання неможливе
        }

        int rows = matrixA.length;
        int cols = matrixA[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }
}