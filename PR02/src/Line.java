/**
 * Created by GlitchRebel on 3/22/2017.
 */
public class Line {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line()
    {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public Line(Point a, Point b)
    {
        this.x1 = a.getX();
        this.y1 = a.getY();
        this.x2 = b.getX();
        this.y2 = b.getY();
    }

    public Point getPointA() {
        return new Point(x1,y1);
    }

    public Point getPointB() {
        return new Point(x2,y2);
    }

    public double distanceFromLine(Point p3) {
        return (x1*y2) + (p3.getX()*y1) + (x2*p3.getY()) - (p3.getX()*y2) - (x2*y1) - (x1*p3.getY());
    }

    public boolean isOnRight(Point p3) {
        return (distanceFromLine(p3) >= 0) ? false : true;
    }

    public int compareTo(Point point) {
        double sign = (y2 - y1)*point.getX() + (x1 - x2)*point.getY() - (x1*y2 - y1*x2);
        return (sign < 0) ? -1 : (sign == 0) ? 0 : 1;
    }
}
