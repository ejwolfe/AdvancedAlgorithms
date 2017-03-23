import java.util.*;

public final class GrahamScan {

    public List<Point> result;

    public GrahamScan(List<Point> points)
    {
        this.result = getConvexHull(points);
    }

    private List<Point> getConvexHull(List<Point> points) {
        List<Point> sorted = new ArrayList<Point>(getSortedPointSet(points));
        if(sorted.size() < 3)
            System.out.println("You have to have more than 3 points");
        Stack<Point> stack = new Stack<Point>();
        stack.push(sorted.get(0));
        stack.push(sorted.get(1));
        for (int i = 2; i < sorted.size(); i++)
        {
            Point top = sorted.get(i);
            Point mid = stack.pop();
            Point bottom = stack.peek();
            int turn = getRotation(bottom, mid, top);
            switch(turn)
            {
                case -1:
                    i--;
                    break;
                case 0:
                    stack.push(top);
                    break;
                case 1:
                    stack.push(mid);
                    stack.push(top);
                    break;
            }
        }
        return new ArrayList<Point>(stack);
    }

    private Point getLow(List<Point> points) {
        Point low = points.get(0);
        for(int i = 1; i < points.size(); i++) {
            Point temp = points.get(i);
            if(temp.getY() < low.getY() || (temp.getY() == low.getY() && temp.getX() < low.getX()))
                low = temp;
        }
        return low;
    }

    private Set<Point> getSortedPointSet(List<Point> points) {

        Point low = getLow(points);

        TreeSet<Point> set = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b)
            {
                if(a == b)
                    return 0;

                double tA = Math.atan2(a.getY() - low.getY(), a.getX() - low.getX());
                double tB = Math.atan2(b.getY() - low.getY(), b.getX() - low.getX());

                if(tA < tB)
                    return -1;
                else if(tA > tB)
                    return 1;
                else
                {
                    double distanceA = Math.sqrt(((low.getX() - a.getX()) * (low.getX() - a.getX())) +
                            ((low.getY() - a.getY()) * (low.getY() - a.getY())));
                    double distanceB = Math.sqrt(((low.getX() - b.getX()) * (low.getX() - b.getX())) +
                            ((low.getY() - b.getY()) * (low.getY() - b.getY())));
                    if(distanceA < distanceB)
                        return -1;
                    else
                        return 1;
                }
            }
        });
        set.addAll(points);
        return set;
    }

    private int getRotation(Point a, Point b, Point c)
    {
        int cp = ((b.getX() - a.getX()) * (c.getY() - a.getY())) - ((b.getY() - a.getY()) * (c.getX() - a.getX()));
        if(cp > 0)
            return 1;
        else if(cp < 0)
            return -1;
        else
            return 0;
    }
}