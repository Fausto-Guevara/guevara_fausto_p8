/*
 * @author Guevara Thomas Fausto Yahel
 * @version 1.0
 * @date 14-Junio-2024 
 */
import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    // Constructor para inicializar la matriz con un arreglo 2D
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // Método para visualizar la matriz
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    // Método para aplicar la regla de Sarrus a matrices de 3x3
    public int applySarrusRule() {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new IllegalArgumentException("La matriz debe ser de 3x3 para aplicar la regla de Sarrus");
        }
        int determinant = matrix[0][0] * matrix[1][1] * matrix[2][2]
                        + matrix[0][1] * matrix[1][2] * matrix[2][0]
                        + matrix[0][2] * matrix[1][0] * matrix[2][1]
                        - matrix[0][2] * matrix[1][1] * matrix[2][0]
                        - matrix[0][0] * matrix[1][2] * matrix[2][1]
                        - matrix[0][1] * matrix[1][0] * matrix[2][2];
        return determinant;
    }

    // Método para multiplicar dos matrices
    public static Matrix multiply(Matrix A, Matrix B) {
        int[][] a = A.matrix;
        int[][] b = B.matrix;

        if (a[0].length != b.length) {
            throw new IllegalArgumentException("El número de columnas de A debe ser igual al número de filas de B");
        }

        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la clase Matrix
        int[][] data1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] data2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        System.out.println("Matriz 1:");
        System.out.println(matrix1);

        System.out.println("Matriz 2:");
        System.out.println(matrix2);

        System.out.println("Determinante de la Matriz 1 (Regla de Sarrus): " + matrix1.applySarrusRule());

        Matrix resultMatrix = Matrix.multiply(matrix1, matrix2);
        System.out.println("Producto de Matriz 1 y Matriz 2:");
        System.out.println(resultMatrix);
    }
}

/*
 * 1.- El que realiza el producto de dos matrices, porque implica asegurarse 
 * de que las dimensiones de las matrices son compatibles para la multiplicación 
 * y manejar múltiples bucles anidados 
 * 
 * 2.- Con iteración
 * 
 * 3.- toString: 15-20min
 *     Regla de Sarrus: 25-30min
 *     Multi. de Matrices: 30-40min
 * 
 * 4.- Los arreglos son estructuras de datos que almacenan elementos de un mismo tipo en una 
 * secuencia contigua, pueden ser utilizados para almacenar colecciones de datos 
 * 
 * 5.- Para obtener la diagonal principal de un arreglo 2-dimensional, recorres los elementos 
 * donde la fila y la columna son iguales, es decir, matrix[i][i] para cada i. 
 * 
 * Para un arreglo 3-dimensional, haces algo similar recorriendo los elementos en las tres dimensiones 
 * donde los índices son iguales, es decir, matrix[i][i][i] para cada i.
 * 
 * 6.- Reforzar conceptos de programación estructurada y el uso de bucles anidados.
 * 
 */