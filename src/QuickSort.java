/**
 * Created by EricWolfe on 1/23/2017.
 */
public class QuickSort {
    public QuickSort(int array[]){
        quickSort(array, 0, array.length);
    }

    private void quickSort(int array[], int low, int high){
        if (low < high){
            int pivot_location = partition(array, low, high);
            quickSort(array, low, pivot_location);
            quickSort(array, pivot_location+1, high);
        }
    }

    private int partition(int array[], int low, int high){
        int pivot = array[low];
        int leftwall = low;

        for (int i = low + 1; i < high; i++){
            if (array[i] < pivot){
                swap(array[i], array[leftwall]);
                leftwall++;
            }
        }

        return leftwall;
    }

    private void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
