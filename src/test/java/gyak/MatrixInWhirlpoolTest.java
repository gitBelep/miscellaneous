package gyak;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixInWhirlpoolTest {

    @Test
    void walk() {
        MatrixInWhirlpool w = new MatrixInWhirlpool();

        List<Point> l1 = w.walk(3,3);
        List<Point> l2 = w.walk(2,4);;

        assertEquals(16, l1.size());
        assertEquals(new Point(0,3), l1.get( l1.size()-1));

        assertEquals(15, l2.size());
        assertEquals(new Point(0,4), l2.get( l2.size()-1));

        assertEquals(15, w.walk(4,2).size());
        assertEquals(1, w.walk(0,0).size());
        assertEquals(5, w.walk(0,4).size());
        assertEquals(5, w.walk(4,0).size());

        assertEquals(Collections.EMPTY_LIST, w.walk(-3,-2));
    }

}
