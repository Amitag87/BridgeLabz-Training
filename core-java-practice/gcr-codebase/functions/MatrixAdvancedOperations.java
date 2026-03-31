package functions;

import java.util.Scanner;

public class MatrixAdvancedOperations {

    public static double[][] generateRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static double determinant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double determinant3x3(double[][] matrix) {
        double det = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                   - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                   + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        return det;
    }

    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;

        return inverse;
    }

    public static double[][] inverse3x3(double[][] matrix) {
        double det = determinant3x3(matrix);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] = (matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1])/det;
        inv[0][1] = (matrix[0][2]*matrix[2][1] - matrix[0][1]*matrix[2][2])/det;
        inv[0][2] = (matrix[0][1]*matrix[1][2] - matrix[0][2]*matrix[1][1])/det;

        inv[1][0] = (matrix[1][2]*matrix[2][0] - matrix[1][0]*matrix[2][2])/det;
        inv[1][1] = (matrix[0][0]*matrix[2][2] - matrix[0][2]*matrix[2][0])/det;
        inv[1][2] = (matrix[0][2]*matrix[1][0] - matrix[0][0]*matrix[1][2])/det;

        inv[2][0] = (matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0])/det;
        inv[2][1] = (matrix[0][1]*matrix[2][0] - matrix[0][0]*matrix[2][1])/det;
        inv[2][2] = (matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0])/det;

        return inv;
    }

    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix does not exist (determinant is 0).");
            return;
        }
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.2f", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        double[][] matrix = generateRandomMatrix(size, size);
        System.out.println("Original Matrix:");
        displayMatrix(matrix);

        System.out.println("Transpose:");
        displayMatrix(transposeMatrix(matrix));

        if (size == 2) {
            System.out.println("Determinant: " + determinant2x2(matrix));
            System.out.println("Inverse:");
            displayMatrix(inverse2x2(matrix));
        } else if (size == 3) {
            System.out.println("Determinant: " + determinant3x3(matrix));
            System.out.println("Inverse:");
            displayMatrix(inverse3x3(matrix));
        } else {
            System.out.println("Determinant and Inverse only implemented for 2x2 and 3x3 matrices.");
        }

        sc.close();
    }
}
