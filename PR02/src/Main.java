/**
 * Created by Eric Wolfe on 3/4/17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input size of the file: ");
        int size = scanner.nextInt();
        System.out.println("Please enter the file name: ");
        String filename = scanner.next();
        Scanner fileScanner;
        PrintWriter writer;
        List<Point> points;
        try
        {
            writer= new PrintWriter("set" + size + ".txt");
            fileScanner = new Scanner(new File("./testinputs/" + filename));
            points = new ArrayList<Point>();
            for (int i = 0; i < size; i++)
            {
                Point p = new Point();
                //Random random = new Random();
                //p.setX(random.nextInt(size - 5));
                //p.setY(random.nextInt(size - 5));
                p.setX(fileScanner.nextInt());
                p.setY(fileScanner.nextInt());
                points.add(p);
            }
            long start = System.currentTimeMillis();
            GrahamScan sc = new GrahamScan(points);
            long end = System.currentTimeMillis();
            writer.println("Graham Scan: " + (end - start) + " millis");
            List<Point> points1 = sc.result;
            start = System.currentTimeMillis();
            JarvisMarch jm = new JarvisMarch(points);
            end = System.currentTimeMillis();
            writer.println("Jarvis March: " + (end - start) + " millis");
            List<Point> points2 = jm.result;
            start = System.currentTimeMillis();
            QuickHull qh = new QuickHull(points);
            end = System.currentTimeMillis();
            writer.println("Quick Hull: " + (end - start) + " millis");
            List<Point> points3 = qh.results;
            for (int i = 0; i < points1.size(); i++)
            {
                writer.println(points1.get(i).getX() + " " + points1.get(i).getY());
            }
            writer.close();

        }catch (FileNotFoundException e)
        {
            System.out.println("Could not find file");
        }
    }

}
