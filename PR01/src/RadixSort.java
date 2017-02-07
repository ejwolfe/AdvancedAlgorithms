/**
 * Created by EricWolfe on 1/23/2017.
 */
public class RadixSort
{
    public RadixSort(int[] array, int size)
    {
        if (array.length != 0)
        {
            radixSort(array, size);
        }
    }

    private void radixSort(int[] array, int size)
    {
      int exp = 1, curr = array[0];
      int[] temp = new int[size];
      for (int i = 1; i < array.length; i++)
      {
        if (array[i] > curr)
        {
          curr = array[i];
        }
      }
      while ((curr / exp) > 0)
      {
        int[] bucket = new int[size];
        for (int i = 0; i < array.length; i++)
        {
          bucket[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++)
        {
          bucket[i] += bucket[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--)
        {
          temp[--bucket[(array[i] / exp) % 10]] = array[i];
        }
        for (int i = 0; i < array.length; i++)
        {
          array[i] = temp[i];
        }
        exp *= 10;
      }
    }
}
