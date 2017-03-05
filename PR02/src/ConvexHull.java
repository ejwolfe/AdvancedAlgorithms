/**
 * Created by glitch on 3/4/17.
 */

import java.util.Vector;

public class ConvexHull
{
    public ConvexHull(Point points[])
    {
        convexHull(points);
    }

    private void convexHull(Point points[])
    {
        int n = points.length;
        if (n > 3)
        {
            Vector<Point> hull = new Vector<Point>();
            int leftmost = 0;
            for (int i = 1; i < n; i++)
            {
                if (points[i].getX() < points[leftmost].getX())
                {
                    leftmost = i;
                }
            }

            int a = leftmost, b;
            do {
                hull.add(points[a]);
                b = (a+1) % n;
                for (int i = 0; i < n; i++)
                {
                    if (ori(points[a], points[i], points[b]) == 2)
                    {
                        b = i;
                    }
                }

                a = b;

            } while (a != leftmost);

            for (int i = 0; i < hull.size(); i++)
            {
                System.out.println("(" + hull.elementAt(i).getX() + ", " + hull.elementAt(i).getY() + ")");
            }
        }
    }

    private int ori(Point a, Point b, Point c)
    {
        int value = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());

        return (value == 0) ? 0 : (value > 0) ? 1 : 2;
    }
}
