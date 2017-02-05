/**
 * Created by GlitchRebel on 1/23/2017.
 */
public class BubbleSort {
    public BubbleSort(int array[]){
        bubbleSort(array);
    }

    private void bubbleSort(int array[]){
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    swap(array[j], array[j+1]);
                }
            }
        }
    }

    private void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
