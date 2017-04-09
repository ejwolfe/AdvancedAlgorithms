import java.util.Random;

/**
 * Created by GlitchRebel on 4/7/2017.
 */
public class FreivaldAlgorithm {
    private int size;

    public FreivaldAlgorithm(int matrixA[][], int matrixB[][], int size)
    {
        this.size = size;
        int result[][] = calculateResultMatrix(matrixA, matrixB);
        printMatrix(matrixA);
        printMatrix(matrixB);
        printMatrix(result);
        System.out.println("Running algorithm");
        System.out.println(freivaldAlgorithm(matrixA, matrixB, result));
        System.out.println("Running altered result matrix");
        result[matrixA.length-1][matrixA.length-1] = 0;
        System.out.println(freivaldAlgorithm(matrixA, matrixB, result));
    }

    private int[][] calculateResultMatrix(int matrixA[][], int matrixB[][])
    {
        int result[][] = new int[size][size];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                for (int z = 0; z < size; z++)
                {
                    result[x][y] += matrixA[x][z] * matrixB[z][y];
                }
            }
        }
        return result;
    }

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

    private boolean checkMatrix(int matrixA[][])
    {
        boolean flag = true;

        for (int x = 0; x < size; x++)
        {
            if (matrixA[x][0] != 0)
            {
                flag = false;
            }
        }
        return flag;
    }

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
            return true;
        }
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
