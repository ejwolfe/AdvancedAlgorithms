/**
 * Created by GlitchRebel on 4/7/2017.
 */
public class main {

    public static void main(String args[])
    {
        int arr[] = new int[]{1, 3, 6, 2, 5, 6, 7, 1, 3};
        //QuickSort qs = new QuickSort(arr);
        int arr2[] = new int[]{3, 1, 5, 2, 4, 3, 7, 9, 1};
        //RandomizedQuickSort rqs = new RandomizedQuickSort(arr2);

        int matrixA[][] = new int[3][3];
        int matrixB[][] = new int[3][3];

        int i = 0;
        int j = 0;

        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                matrixA[x][y] = arr[i];
                matrixB[x][y] = arr2[j];
                i++;
                j++;
            }
        }

        FreivaldAlgorithm fa = new FreivaldAlgorithm(matrixA, matrixB, 3);
    }
}
