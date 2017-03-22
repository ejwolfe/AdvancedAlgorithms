/**
 * Created by GlitchRebel on 3/21/2017.
 */

import java.util.*;

public class JarvisMarch {

    public List<Point> stack;

    public JarvisMarch(List<Point> points)
    {
        this.stack = jarvisMarch(points);
    }

    static class PointComparator implements Comparator<Point> {

        /*
         * Sorts the points so that the lowest - leftmost one is the first.
         * Used by both Graham's and Jarvis's algorithms.
         */
        public int compare(Point o1, Point o2) {
            double y1 = o1.getY();
            double y2 = o2.getY();
            double yDiff = y1 - y2;
            double errorTolerance = 0.001;
            if (yDiff < -errorTolerance) {
                return -1;
            } else if (yDiff>errorTolerance) {
                return 1;
            } else{
                double x1 = o1.getX();
                double x2 = o2.getX();
                double xDiff = x1 - x2;

                if (xDiff < -errorTolerance) {
                    return -1;
                } else if (xDiff > errorTolerance) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private Double polarAngle(Point p0, Point p1) {
        if (p0.equals(p1)) {
            return null;
        }
        double dy = p1.getY() - p0.getY();
        double dx = p1.getX() - p0.getX();
        double result = Math.toDegrees(Math.atan(dy / dx));
        if (dx < 0) {
            result = 180 + result;
        } else {
            if (dy < 0) {
                result = 270 + result;
            }
        }
        return result;
    }

    private Double polarAngleNegAxis(Point p0, Point p1) {
        if (p0.equals(p1)) {
            return null;
        }
        double dy = p1.getY() - p0.getY();
        double dx = p1.getX() - p0.getX();
        double result = Math.toDegrees(Math.atan(dy / dx));
        if (dx < 0) {
            result = 180 + result;
        }
        result = (result + 180) % 360;
        return result;
    }

    private int jarvisFindSmallestPolarAngle(List<Point> points, Point p0, boolean rightChain) {

        int i = 0;
        int index = 0;
        double minAngle = 500;
        Double polarAngle;


        for (Iterator<Point> it = points.iterator(); it.hasNext();) {
            Point point = it.next();
            if (rightChain) {
                polarAngle = polarAngle(p0, point);
            } else {
                polarAngle = polarAngleNegAxis(p0, point);
            }

            if ((polarAngle != null) && (polarAngle < minAngle)) {
                index = i;
                minAngle = polarAngle;
            }
            i++;
        }

        return index;
    }

    public List<Point> jarvisMarch(List<Point> points) {

        List<Point> result = new ArrayList<Point>();

        if (points.size() > 2) {

            Collections.sort(points, new PointComparator());

            Point lowestPoint = points.get(0);
            Point highestPoint = points.get(points.size() - 1);

            result.add(lowestPoint);

            int i = 1;

            Point p = lowestPoint;
            Point p1;
            int index = 1;
            while (p.equals(highestPoint) == false) {
                index = jarvisFindSmallestPolarAngle(points, p, true);
                result.add(points.get(index));
                p1 = points.get(index);
                p = p1;
            }

            while (p.equals(lowestPoint) == false) {
                index = jarvisFindSmallestPolarAngle(points, p, false);
                result.add(points.get(index));
                p1 = points.get(index);
                p = p1;
            }
        }
        result.remove(0);
        return result;
    }
}
