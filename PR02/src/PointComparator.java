/**
 * Created by GlitchRebel on 3/22/2017.
 */

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

    public int compare(Point o1, Point o2) {
        double dif = o1.getY() - o2.getY();
        double errorTolerance = 0.001;
        if (dif < -errorTolerance) {
            return -1;
        } else if (dif>errorTolerance) {
            return 1;
        } else{
            dif = o1.getX() - o2.getX();

            if (dif < -errorTolerance) {
                return -1;
            } else if (dif > errorTolerance) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}