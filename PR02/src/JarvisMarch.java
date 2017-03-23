/**
 * Created by Eric Wolfe on 3/21/2017.
 */

import java.util.*;

public class JarvisMarch {

    public List<Point> result;

    public JarvisMarch(List<Point> points)
    {
        this.result = jarvisMarch(points);
    }

    private Double getAngle(Point p0, Point p1) {
        if (p0.equals(p1))
            return null;
        double dy = p1.getY() - p0.getY();
        double dx = p1.getX() - p0.getX();
        double result = Math.toDegrees(Math.atan(dy / dx));
        if (dx < 0)
            result = 180 + result;
        else
            if (dy < 0)
                result = 270 + result;
        return result;
    }

    private Double getAngleNegAxis(Point p0, Point p1) {
        if (p0.equals(p1))
            return null;
        double dy = p1.getY() - p0.getY();
        double dx = p1.getX() - p0.getX();
        double result = Math.toDegrees(Math.atan(dy / dx));
        if (dx < 0)
            result = 180 + result;
        result = (result + 180) % 360;
        return result;
    }

    private int getSmallestAngle(List<Point> points, Point p0, boolean rightChain) {

        int i = 0;
        int index = 0;
        double minAngle = 500;
        Double getAngle;
        for (Iterator<Point> it = points.iterator(); it.hasNext();) {
            Point point = it.next();
            if (rightChain)
                getAngle = getAngle(p0, point);
            else
                getAngle = getAngleNegAxis(p0, point);

            if ((getAngle != null) && (getAngle < minAngle)) {
                index = i;
                minAngle = getAngle;
            }
            i++;
        }
        return index;
    }

    private List<Point> jarvisMarch(List<Point> points) {

        List<Point> result = new ArrayList<Point>();

        if (points.size() > 2) {
            Collections.sort(points, new PointComparator());
            Point low = points.get(0);
            Point high = points.get(points.size() - 1);
            result.add(low);
            Point p = low;
            Point p1;
            int index = 1;
            while (p.equals(high) == false) {
                index = getSmallestAngle(points, p, true);
                result.add(points.get(index));
                p1 = points.get(index);
                p = p1;
            }

            while (p.equals(low) == false) {
                index = getSmallestAngle(points, p, false);
                result.add(points.get(index));
                p1 = points.get(index);
                p = p1;
            }
        }
        result.remove(0);
        return result;
    }
}
