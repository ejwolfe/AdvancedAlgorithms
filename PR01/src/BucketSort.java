import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    public BucketSort(int[] array, int choice, int amountBuckets)
    {
        if (array.length != 0 && amountBuckets > 0) {
            bucketSort(array, choice, amountBuckets);
        }
    }

    private void bucketSort(int[] array, int choice, int amountBuckets)
    {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] > max)
            {
                max = array[i];
            }
            else if (array[i] < min)
            {
                min = array[i];
            }
        }

        int numBuckets = (max - min) /  amountBuckets;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(numBuckets);
        for (int i = 0; i < numBuckets; i++)
        {
            buckets.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.length; i++)
        {
            buckets.get((array[i] - min) / numBuckets).add(array[i]);
        }

        int current = 0;
        for (int i = 0; i < buckets.size(); i++)
        {
            Integer[] temp = new Integer[buckets.get(i).size()];
            temp = buckets.get(i).toArray(temp);
            switch (choice)
            {
                case 1:
                    BubbleSort bs = new BubbleSort(array);
                    break;
                case 2:
                    QuickSort qs = new QuickSort(array);
                    break;
                case 3:
                    RadixSort rs = new RadixSort(array, array.length);
                    break;
                default:
                    System.out.println("You did not pick an of the choices please restart");
            }
            for (int j = 0; j < temp.length; j++)
            {
                array[current++] = temp[j];
            }
        }
    }
}
