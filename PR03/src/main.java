/**
 * Created by GlitchRebel on 4/7/2017.
 */
public class main {

    public static void main(String args[])
    {
        int size = 2;
        int arr[] = new int[]{1, 3, 6, 2};
        //QuickSort qs = new QuickSort(arr);
        int arr2[] = new int[]{3, 1, 5, 2};
        //RandomizedQuickSort rqs = new RandomizedQuickSort(arr2);

        int matrixA[][] = new int[size][size];
        int matrixB[][] = new int[size][size];

        int i = 0;
        int j = 0;

        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                matrixA[x][y] = arr[i];
                matrixB[x][y] = arr2[j];
                i++;
                j++;
            }
        }

        FreivaldAlgorithm fa = new FreivaldAlgorithm(matrixA, matrixB, size);
        StrassenAlgorithm sa = new StrassenAlgorithm(matrixA, matrixB);
    }
}
