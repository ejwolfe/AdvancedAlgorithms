/**
 * Created by glitch on 3/4/17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String args[])
    {
        Scanner fileScanner;
        List<Point> points;
        try
        {
            fileScanner = new Scanner(new File("./testinputs/small2.txt"));
            points = new ArrayList<Point>();
            for (int i = 0; i < 8; i++)
            {
                Point p = new Point();
                p.setX(fileScanner.nextInt());
                p.setY(fileScanner.nextInt());
                points.add(p);
            }
            //ConvexHull ch = new ConvexHull(points);
            //GrahamScan sc = new GrahamScan(points);
            //points = sc.stack;
            JarvisMarch jm = new JarvisMarch(points);
            points = jm.stack;
            for (int i = 0; i < points.size(); i++)
            {
                System.out.println(points.get(i).getX() + " " + points.get(i).getY());
            }

        }catch (FileNotFoundException e)
        {
            System.out.println("Could not find file");
        }
    }

}
