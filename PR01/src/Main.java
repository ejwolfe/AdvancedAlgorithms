import java.util.Scanner;

/**
 * Created by Eric Wolfe on 1/23/2017.
 */

import java.io.*;

public class Main {
    //Main function
    public static void main(String args[]){

        Scanner fileScanner; //Scanner for reading in the file
        Scanner scanner = new Scanner(System.in); //Scanner for user input for the size of the file and amount of buckets

        System.out.print("Please enter a text file to be searched (without .txt): ");

        String filename = scanner.next(); //Takes in a user input for the file name

        System.out.print("\nWhat size of an array would you like to use? ");

        int size = scanner.nextInt(); //Takes in the size of the file (amount of numbers)

        //Try to read the file
        try
        {
            fileScanner = new Scanner(new File(filename + ".txt"));
            System.out.print("\nHow many buckets: ");
            int amountBuckets = scanner.nextInt(); //Takes user input for the amount of buckets in the bucket sort

            //Initializing the arrays for each algorithm that will be passed into bucket sort
            int[] arrayBubble = new int[size];
            int[] arrayQuick = new int[size];
            int[] arrayRadix = new int[size];

            //Reads file contents into arrays
            for (int i = 0; i < arrayBubble.length; i++)
            {
                arrayBubble[i] = arrayQuick[i] = arrayRadix[i] = fileScanner.nextInt();
            }

            //Error checking for bucket size
            if (amountBuckets <= 0 && amountBuckets >= arrayBubble.length)
            {
                System.out.println("You entered buckets less than or equal to 0 or greater than or equal to the array size so bucket sort will default to 1 bucket");
            }

            //Runs each algorithm through bucket sort
            long startTimeBubble = System.currentTimeMillis();
            BucketSort bsb = new BucketSort(arrayBubble, 1, amountBuckets <= 0 ? 1 : amountBuckets > arrayBubble.length ? 1 : amountBuckets);
            long endTimeBubble = System.currentTimeMillis();
            long startTimeQuick = System.currentTimeMillis();
            BucketSort bsq = new BucketSort(arrayQuick, 1, amountBuckets <= 0 ? 1 : amountBuckets > arrayBubble.length ? 1 : amountBuckets);
            long endTimeQuick = System.currentTimeMillis();
            long startTimeRadix = System.currentTimeMillis();
            BucketSort bsr = new BucketSort(arrayRadix, 1, amountBuckets <= 0 ? 1 : amountBuckets > arrayBubble.length ? 1 : amountBuckets);
            long endTimeRadix = System.currentTimeMillis();

            //Tries to output the contents from the arrays to the specified file
            try {
                PrintWriter writer = new PrintWriter(filename + "Out.txt");
                writer.println("Sort Size: " + size + "\nNumber of Buckets: " + amountBuckets + "\nBubble Sort: "
                + (endTimeBubble-startTimeBubble) + "milliseconds" + "\nQuick Sort: " + (endTimeQuick-startTimeQuick) + "milliseconds"
                + "\nRadix Sort: " + (endTimeRadix-startTimeRadix) + "milliseconds");
                writer.println("\nBubble sort final array: \n");
                printArray(arrayBubble, writer);
                writer.println("\nQuick sort final array: \n");
                printArray(arrayQuick, writer);
                writer.println("\nRadix sort final array: \n");
                printArray(arrayRadix, writer);
                writer.close();

                System.out.println("\n Results can be found in " + filename + "Out.txt");
            }
            catch (IOException e)
            {
                System.out.println("Could not write to file");
            }
        }
        //Catch the error for reading in the file
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    //Prints the array to a file
    private static void printArray(int[] array, PrintWriter writer)
    {
        for (int i = 0; i < array.length; i++)
        {
            writer.println(array[i]);
        }
    }
}
