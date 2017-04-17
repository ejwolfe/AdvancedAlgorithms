import java.util.Random;

/**
 * Created by Eric Wolfe on 4/7/2017.
 */
public class FreivaldAlgorithm {
    private int size;
    public String answer;

    public FreivaldAlgorithm(int matrixA[][], int matrixB[][], int size, int matrixC[][])
    {
        this.size = size;
        matrixC[matrixA.length-1][matrixA.length-1] = 0;
        freivaldAlgorithm(matrixA, matrixB, matrixC);
        //For testing
        /*double a = 0;
        double b = 0;
        for (int i = 0; i < 5; i++)
        {
            boolean test = freivaldAlgorithm(matrixA, matrixB, matrixC);
            if (test == true)
            {
                a++;
            }
            else
            {
                b++;
            }
        }
        System.out.println((a/b));
        */
    }

    //Helper function for calculating the result matrices
    private int[][] calculateResultMatries(int matrixA[][], int matrixB[][])
    {
        int result[][] = new int[size][1];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < 1; y++)
            {
                for (int z = 0; z < size; z++)
                {
                    result[x][y] += matrixA[x][z] * matrixB[z][y];
                }
            }
        }
        return result;
    }

    //Helper function for subtracting the size x 1 matrix from the result matrix
    private int[][] subtractMatrix(int matrixA[][], int matrixB[][])
    {
        int result[][] = new int[size][1];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < 1; y++)
            {
                result[x][y] = matrixA[x][y] - matrixB[x][y];
            }
        }

        return result;
    }

    //Helper function for checking to see if the matrix that is passed has zeros
    private boolean checkMatrix(int matrixA[][])
    {
        boolean result = true;

        for (int x = 0; x < size; x++)
        {
            if (matrixA[x][0] != 0)
            {
                result = false;
            }
        }
        return result;
    }

    //Freivald algorithm for randomly checking to see if the result matrix is correct
    private boolean freivaldAlgorithm(int matrixA[][], int matrixB[][], int resultMatrix[][])
    {
        int r[][] = new int[size][1];
        Random rand = new Random();
        for (int i = 0; i < size; i++)
        {
            r[i][0] = rand.nextInt(2);
        }
        int Br[][] = calculateResultMatries(matrixB, r);
        int ABr[][] = calculateResultMatries(matrixA, Br);
        int Cr[][] = calculateResultMatries(resultMatrix, r);
        int P[][] = subtractMatrix(ABr, Cr);
        if(checkMatrix(P))
        {
            answer = "yes";
            return true;
        }
        answer = "no";
        return false;
    }

    private void printMatrix(int result[][])
    {
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result.length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
