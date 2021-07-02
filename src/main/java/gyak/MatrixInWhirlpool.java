package gyak;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatrixInWhirlpool {

    public List<Point> walk(int n, int m) {
        var x = 0;
        var y = 0;
        List<Point> points = new ArrayList<>();

        for (var xx = 0; xx <= n; xx++) {
            y = 0;
            x = xx;

            while (x > y && y < m){             //go right
                points.add(new Point(x, y));
                y++;
            }
            while (x >= 0) {                    //go down
                Point actual = new Point(x, y);
                if(!points.contains(actual)) {  //if n > m, do not write the same
                    points.add(actual);
                }
                x--;
            }
        }
        if(y < m){                             //if n < m, go down
            for(y = y + 1; y <= m; y++){
                for(x = n; x >= 0; x--) {
                    points.add(new Point(x, y));
                }
            }
        }
        System.out.println((n+1) +"x"+ (m+1) +"\n"+ points +"\n¨");
        return points;
    }

}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() { return x + "~" + y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
