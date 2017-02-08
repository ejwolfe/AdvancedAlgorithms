/**
 * Created by Eric Wolfe on 1/23/2017.
 */
public class BubbleSort {
    //Construtor that will run bubble sort
    public BubbleSort(int[] array){
        bubbleSort(array);
    }

    //Bubble sort algorithm
    private void bubbleSort(int[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    swap(array, j, j+1);
                }
            }
        }
    }

    //Swap method for the bubble sort when the next position is less than the current position
    private void swap(int array[], int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
