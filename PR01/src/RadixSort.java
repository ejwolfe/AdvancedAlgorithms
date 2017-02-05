/**
 * Created by EricWolfe on 1/23/2017.
 */
public class RadixSort
{
    public RadixSort(int array[])
    {
      radixSort(array);
    }

    private void radixSort(int array[])
    {
      int exp = 1, curr = array[0];
      int temp = new int[10];
      for (int i = 1; i < n; i++)
      {
        if (array[i] > curr)
        {
          curr = a[i];
        }
      }
      while ((curr / exp) > 0)
      {
        int bucket = new int[10];
        for (int i = 0; i < n; i++)
        {
          bucket[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++)
        {
          bucket[i] += bucket[i - 1];
        }
        for (int i = n - 1; i >= 0; i--)
        {
          temp[--bucket[(array[i] / exp) % 10]] = array[i];
        }
        for (int i = 0; i < n; i++)
        {
          array[i] = temp[i];
        }
        exp *= 10;
      }
    }
}
