
import java.util.*;

/**
 * Created by Eric Wolfe on 3/22/2017.
 */

public class QuickHull {

    public List<Point> results = new ArrayList<Point>();
    public QuickHull(List<Point> points)
    {
        setUpHull(points);
    }

    private void setUpHull(List<Point> points)
    {
        results.add(points.get(0));
        results.add(points.get(points.size()-1));

        Line lineAB = new Line(points.get(0), points.get(points.size()-1));
        Line lineBA = new Line(points.get(points.size()-1), points.get(0));

        ArrayList<Point> sublist1 = rightSidePoints(lineAB, points);
        ArrayList<Point> sublist2 = rightSidePoints(lineBA, points);

        quickHull(sublist1, lineAB);
        quickHull(sublist2, lineBA);
    }

    private ArrayList<Point> rightSidePoints(Line line, List<Point> points) {
        ArrayList<Point> rightPoints = new ArrayList<Point>();

        for(Point curr : points)
            if(line.isOnRight(curr))
                rightPoints.add(curr);

        return rightPoints;
    }

    private void quickHull(ArrayList<Point> pointSet, Line line) {

        if(pointSet.isEmpty()) return;

        double highestDist = 0;
        Point farthestPoint = null;

        for(Point curr : pointSet) {
            double distance = line.distanceFromLine(curr);
            if(distance < highestDist) {
                highestDist = distance;
                farthestPoint = curr;
            }
        }

        results.add(farthestPoint);

        Line lineAB = new Line(line.getPointA(), farthestPoint);
        Line lineBC = new Line(farthestPoint, line.getPointB());

        ArrayList<Point> sublist1 = rightSidePoints(lineAB, pointSet);
        ArrayList<Point> sublist2 = rightSidePoints(lineBC, pointSet);

        quickHull(sublist1, lineAB);
        quickHull(sublist2, lineBC);

    }
}
