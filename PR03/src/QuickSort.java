/**
 * Created by EricWolfe on 1/23/2017.
 */
public class QuickSort {

    //Constructor for running quick sort
    public QuickSort(int[] array) {
        quickSort(array, 0, array.length-1);
        printResults(array);
    }

    //main quicksort function
    private void quickSort(int[] array, int low, int high){
        if (low < high){
            int pivot_location = partition(array, low, high);
            quickSort(array, low, pivot_location - 1);
            quickSort(array, pivot_location+1, high);
        }
    }

    //runs the parition for quick sort
    private int partition(int array[], int low, int high){
        int pivot = array[low];
        int leftwall = low + 1;

        for (int i = low + 1; i <= high; i++){
            if (array[i] < pivot){
                swap(array, i, leftwall);
                leftwall++;
            }
        }
        swap(array, low, leftwall - 1);
        return leftwall - 1;
    }

    //Swap function for when curren position and the leftwall
    private void swap(int array[], int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    //Printing function for debugging
    private void printResults(int array[])
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
