import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Eric Wolfe on 4/7/2017.
 */

public class main {

    public static void main(String args[])
    {
        Scanner fileScanner;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter true if you want to use input files and false if you want to use random numbers:");
        boolean choice = input.nextBoolean();
        if (choice == true) {
            //System.out.println("Please enter the size of the sort file");
            //int size1 = input.nextInt();
            //System.out.println("Please enter the sort file name");
            //String file1 = input.next();
            System.out.println("Please enter the size of matrices");
            int size2 = input.nextInt();
            System.out.println("Please enter the matrix file name");
            String file2 = input.next();

            try {
            /*fileScanner = new Scanner(new File("./inputfiles/" + file1));
            int sortArr1[] = new int[size1];
            int sortArr2[] = new int[size1];
            for (int i = 0; i < size1; i++)
            {
                sortArr1[i] = fileScanner.nextInt();
                sortArr2[i] = sortArr1[i];
            }
            QuickSort qs = new QuickSort(sortArr1);
            RandomizedQuickSort rqs = new RandomizedQuickSort(sortArr2);
            fileScanner.close();*/
                fileScanner = new Scanner(new File("./inputfiles/" + file2));
                int matrixA[][] = new int[size2][size2];
                int matrixB[][] = new int[size2][size2];
                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        matrixA[i][j] = fileScanner.nextInt();
                    }
                }
                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        matrixB[i][j] = fileScanner.nextInt();
                    }
                }

                StrassenAlgorithm sa = new StrassenAlgorithm(matrixA, matrixB);
                FreivaldAlgorithm fa = new FreivaldAlgorithm(matrixA, matrixB, matrixA.length, sa.result);
            } catch (FileNotFoundException e) {
                System.out.println("Please make sure the file you are entering is in the inputfiles folder");
            }
        }
        else
        {
            System.out.println("Please enter the size of the matrices");
            int size2 = input.nextInt();
            System.out.println("Please enter the sort size");
            int size1 = input.nextInt();

            Random random = new Random();
            int sortArr1[] = new int[size1];
            int sortArr2[] = new int[size1];
            for (int i = 0; i < size1; i++)
            {
                sortArr1[i] = random.nextInt(size1*10);
                sortArr2[i] = sortArr1[i];
            }

            QuickSort qs = new QuickSort(sortArr1);
            RandomizedQuickSort rqs = new RandomizedQuickSort(sortArr2);

            int matrixA[][] = new int[size2][size2];
            int matrixB[][] = new int[size2][size2];
            for (int i = 0; i < size2; i++) {
                for (int j = 0; j < size2; j++) {
                    matrixA[i][j] = random.nextInt(10);
                    matrixB[i][j] = random.nextInt(10);
                }
            }

            StrassenAlgorithm sa = new StrassenAlgorithm(matrixA, matrixB);
            FreivaldAlgorithm fa = new FreivaldAlgorithm(matrixA, matrixB, matrixA.length, sa.result);
        }
    }
}
