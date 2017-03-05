/**
 * Created by glitch on 3/5/17.
 */

import java.util.Stack;

public class GrahamScan
{
    Point p0;

    public GrahamScan(Point points[])
    {

    }

    private void grahamScan(Point points[])
    {
        int n = points.length;

        int ymin = points[0].getY(), min = 0;
        for (int i = 1; i < n; i++)
        {
            if ((points[i].getY() < ymin || (ymin == points[i].getY() && points[i].getX() < points[min].getX())))
            {
                ymin = points[i].getY();
                min = i;
            }
        }

        swap(points, 0, min);
        p0 = points[0];
        //do sort here

        int m = 1;
        for (int i = 1; i < n; i++)
        {
            while (i < n - 1 && ori(p0, points[i], points[i+1]) == 0)
            {
                i++;
            }
            points[m] = points[i];
            m++;
        }

        if (m > 3)
        {
            Stack<Point> s = new Stack<Point>();
            s.push(points[0]);
            s.push(points[1]);
            s.push(points[2]);

            for (int i = 3; i < m; i++)
            {
                while (ori(nextToTop(s), s.firstElement(), points[i]) != 2)
                {
                    s.pop();
                }
                s.push(points[i]);
            }
            while (!s.empty())
            {
                Point p = s.firstElement();
                System.out.println("(" + p.getX() + ", " + p.getY() + ")");
                s.pop();
            }
        }
    }


    private Point nextToTop(Stack<Point> S)
    {
        Point p = S.firstElement();
        S.pop();
        Point p2 = S.firstElement();
        S.push(p);
        return p2;
    }

    private void swap(Point points[], int p1, int p2)
    {
        Point temp = points[p1];
        points[p1] = points[p2];
        points[p2] = temp;
    }

    int distanceSquared(Point p1, Point p2)
    {
        return (p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
    }

    private int ori(Point a, Point b, Point c)
    {
        int value = (b.getY() - a.getY()) * (c.getX() - b.getX()) - (b.getX() - a.getX()) * (c.getY() - b.getY());

        return (value == 0) ? 0 : (value > 0) ? 1 : 2;
    }

    private int compare(Point p1, Point p2)
    {
        int o = ori(p0, p1, p2);
        if (o == 0)
        {
            return (distanceSquared(p0, p2) >= distanceSquared(p0, p1)) ? -1 : 1;
        }
        return (o == 2) ? -1 : 1;
    }
}
