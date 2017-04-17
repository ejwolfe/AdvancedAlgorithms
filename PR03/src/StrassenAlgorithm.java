/**
 * Created by Eric Wolfe on 4/9/17.
 */
public class StrassenAlgorithm {

    public int result[][];

    public StrassenAlgorithm(int matrixA[][], int matrixB[][])
    {
        if (matrixA.length % 2 == 0) //Makes sure that the matrix is a power of 2
        {
            this.result = strassenAlgorithm(matrixA, matrixB);
            //printMatrix(result);
        }
        else
        {
            System.out.println("Matrix size was not a power of 2");
        }
    }

    private int[][] strassenAlgorithm(int matrixA[][], int matrixB[][])
    {
        return multiplyMatrices(matrixA, matrixB);
    }

    private int[][] multiplyMatrices(int matrixA[][], int matrixB[][])
    {
        int size = matrixA.length;
        int result[][] = new int[size][size];
        if (size == 1) //Base case if its a 1x1 matrix
        {
            result[0][0] = matrixA[0][0] * matrixB[0][0];
            return result;
        }
        else
        {
            //Making the arrays to split the main matrix up into its pieces
            int A11[][] = new int[size/2][size/2];
            int A12[][] = new int[size/2][size/2];
            int A21[][] = new int[size/2][size/2];
            int A22[][] = new int[size/2][size/2];
            int B11[][] = new int[size/2][size/2];
            int B12[][] = new int[size/2][size/2];
            int B21[][] = new int[size/2][size/2];
            int B22[][] = new int[size/2][size/2];

            //Split main matrix into the child matrices
            splitMatrix(matrixA, A11, 0, 0);
            splitMatrix(matrixB, B11, 0, 0);
            splitMatrix(matrixA, A12, 0, size/2);
            splitMatrix(matrixB, B12, 0, size/2);
            splitMatrix(matrixA, A21, size/2, 0);
            splitMatrix(matrixB, B21, size/2, 0);
            splitMatrix(matrixA, A22, size/2, size/2);
            splitMatrix(matrixB, B22, size/2, size/2);

            //Calculate m's to be put into the final result matrix
            int m1[][] = multiplyMatrices(addMatrices(A11, A22), addMatrices(B11, B22));
            int m2[][] = multiplyMatrices(addMatrices(A21, A22), B11);
            int m3[][] = multiplyMatrices(A11, subtractMatrices(B12, B22));
            int m4[][] = multiplyMatrices(A22, subtractMatrices(B21, B11));
            int m5[][] = multiplyMatrices(addMatrices(A11, A12), B22);
            int m6[][] = multiplyMatrices(subtractMatrices(A21, A11), addMatrices(B11, B12));
            int m7[][] = multiplyMatrices(subtractMatrices(A12, A22), addMatrices(B21, B22));

            //Calculate the final quadrants for the result matrix
            int c11[][] = addMatrices(subtractMatrices(addMatrices(m1, m4), m5), m7);
            int c12[][] = addMatrices(m3, m5);
            int c21[][] = addMatrices(m2, m4);
            int c22[][] = addMatrices(subtractMatrices(addMatrices(m1, m3), m2), m6);

            //Join the quadrant matrices together which when joined becomes the final result matrix
            joinMatrix(c11, result, 0, 0);
            joinMatrix(c12, result, 0, size/2);
            joinMatrix(c21, result, size/2, 0);
            joinMatrix(c22, result, size/2, size/2);

            //Return the final result matrix
            return result;
        }
    }

    //Function is used for splitting the main matrix into its child matrices
    private void splitMatrix(int matrixA[][], int matrixB[][], int x, int y)
    {
        for (int x1 = 0, x2 = x; x1 < matrixB.length; x1++, x2++)
        {
            for (int y1 = 0, y2 = y; y1 < matrixB.length; y1++, y2++)
            {
                matrixB[x1][y1] = matrixA[x2][y2];
            }
        }
    }

    //Function is used for joining the child matrices into the main matrix
    private void joinMatrix(int matrixA[][], int matrixB[][], int x, int y)
    {
        for (int x1 = 0, x2 = x; x1 < matrixA.length; x1++, x2++)
        {
            for (int y1 = 0, y2 = y; y1 < matrixA.length; y1++, y2++)
            {
                matrixB[x2][y2] = matrixA[x1][y1];
            }
        }
    }

    //Function for adding two matrices together and then it returns the result of the addition
    private int[][] addMatrices(int matrixA[][], int matrixB[][])
    {
        int size = matrixA.length;
        int result[][] = new int[size][size];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                result[x][y] = matrixA[x][y] + matrixB[x][y];
            }
        }
        return result;
    }

    //Function for subtracting two matrices and then it returns the result of the subtraction
    private int[][] subtractMatrices(int matrixA[][], int matrixB[][])
    {
        int size = matrixA.length;
        int result[][] = new int[size][size];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                result[x][y] = matrixA[x][y] - matrixB[x][y];
            }
        }
        return result;
    }

    private void printMatrix(int matrix[][])
    {
        for (int x = 0; x < matrix.length; x++)
        {
            for (int y = 0; y < matrix.length; y++)
            {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
    }
}
