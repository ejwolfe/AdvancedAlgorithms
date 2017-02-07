import java.util.Scanner;

/**
 * Created by Eric Wolfe on 1/23/2017.
 */

import java.io.*;

public class Main {
    public static void main(String args[]){

        Scanner fileScanner;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which case would you like to test? \n SortedA100 \n SortedA1000 " +
                "\n SortedA10000 \n SortedA100000 \n SortedD100 \n SortedD1000 \n SortedD10000 \n SortedD100000" +
                "\n Unsorted100 \n Unsorted1000 \n Unsorted10000 \n Unsorted100000 \n Answer: ");

        String filename = scanner.next();

        System.out.print("\nWhat size of an array would you like to use? ");

        int size = scanner.nextInt();

        try
        {
            fileScanner = new Scanner(new File("TestCases/" + filename + ".txt"));
            System.out.print("\nPlease choose what algorithm to use: \n 1. Bubble \n 2. Quick \n 3. Radix \n Answers: ");
            int choice = scanner.nextInt();
            System.out.print("\nHow many buckets do you want to use? ");
            int amountBuckets = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++)
            {
                array[i] = fileScanner.nextInt();
            }

            if (amountBuckets <= 0 && amountBuckets >= array.length)
            {
                System.out.println("You entered buckets less than or equal to 0 or greater than or equal to the array size so bucket sort will default to 1 bucket");
            }

            printArray(array);
            long startTime = System.currentTimeMillis();
            BucketSort bs = new BucketSort(array, choice, amountBuckets <= 0 ? 1 : amountBuckets > array.length ? 1 : amountBuckets);
            long endTime = System.currentTimeMillis();
            printArray(array);
            System.out.println("Time for execution " + (endTime - startTime) + " milliseconds");
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
