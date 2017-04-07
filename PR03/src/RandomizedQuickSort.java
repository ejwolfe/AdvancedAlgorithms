import java.util.Random;

/**
 * Created by Eric Wolfe on 4/7/2017.
 */

public class RandomizedQuickSort {

    //Constructor for running quick sort
    public RandomizedQuickSort(int[] array) {
        randomizedQuickSort(array, 0, array.length);
        printResults(array);
    }

    //main quicksort function
    private void randomizedQuickSort(int[] array, int low, int high){
        if (low < high){
            int pivot_location = partition(array, low, high);
            randomizedQuickSort(array, low, pivot_location);
            randomizedQuickSort(array, pivot_location+1, high);
        }
    }

    //runs the parition for randomized quick sort
    private int partition(int array[], int low, int high){
        Random random = new Random(); //Make a new random
        int leftwall = random.nextInt((high - low) + 1) + low;
        swap(array, array[leftwall], array[high]);
        int pivot = array[high];
        leftwall = low - 1;

        for (int i = low; i < high - 1; i++){
            if (array[i] <= pivot){
                swap(array, i, leftwall);
                leftwall++;
            }
        }
        swap(array, array[leftwall+1], array[high]);
        return leftwall + 1;
    }

    //Swap function for when curren position and the leftwall
    private void swap(int array[], int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    private void printResults(int array[])
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}