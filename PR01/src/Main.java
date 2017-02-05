import java.util.Scanner;

/**
 * Created by Eric Wolfe on 1/23/2017.
 */

import java.io.*;

public class Main {
    public static void main(String args[]){

        Scanner scanner;
        Scanner choice = new Scanner(System.in);

        try
        {
            scanner = new Scanner(new File("numbers.txt"));
            System.out.println("Please choose what algorithm to use: \n 1. Bubble \n 2. Quick \n 3. Radix \n");
            int chio = choice.nextInt();
            int[] array = new int[10];
            for (int i = 0; i < array.length; i++)
            {
                array[i] = scanner.nextInt();
            }
            printArray(array);
            switch (chio)
            {
                case 1:
                    BubbleSort bs = new BubbleSort(array);
                    break;
                case 2:
                    QuickSort qs = new QuickSort(array);
                    break;
                case 3:
                    RadixSort rs = new RadixSort(array);
                    break;
                default:
                    System.out.println("You did not pick an of the choices please restart");
            }
            printArray(array);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
