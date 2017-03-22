import java.util.*;

public final class GrahamScan {

    public List<Point> stack;

    public GrahamScan(List<Point> points)
    {
        this.stack = getConvexHull(points);
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
            Point head = sorted.get(i);
            Point middle = stack.pop();
            Point tail = stack.peek();
            int turn = getTurn(tail, middle, head);
            switch(turn)
            {
                case -1:
                    i--;
                    break;
                case 0:
                    stack.push(head);
                    break;
                case 1:
                    stack.push(middle);
                    stack.push(head);
                    break;
            }
        }
        return new ArrayList<Point>(stack);
    }

    private Point getLowestPoint(List<Point> points) {
        Point lowest = points.get(0);
        for(int i = 1; i < points.size(); i++) {
            Point temp = points.get(i);
            if(temp.getY() < lowest.getY() || (temp.getY() == lowest.getY() && temp.getX() < lowest.getX()))
                lowest = temp;
        }
        return lowest;
    }

    private Set<Point> getSortedPointSet(List<Point> points) {

        Point lowest = getLowestPoint(points);

        TreeSet<Point> set = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b)
            {
                if(a == b)
                    return 0;

                double tA = Math.atan2(a.getY() - lowest.getY(), a.getX() - lowest.getX());
                double tB = Math.atan2(b.getY() - lowest.getY(), b.getX() - lowest.getX());

                if(tA < tB)
                    return -1;
                else if(tA > tB)
                    return 1;
                else
                {
                    double distanceA = Math.sqrt(((lowest.getX() - a.getX()) * (lowest.getX() - a.getX())) +
                            ((lowest.getY() - a.getY()) * (lowest.getY() - a.getY())));
                    double distanceB = Math.sqrt(((lowest.getX() - b.getX()) * (lowest.getX() - b.getX())) +
                            ((lowest.getY() - b.getY()) * (lowest.getY() - b.getY())));

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

    private int getTurn(Point a, Point b, Point c)
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