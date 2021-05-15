package gyak;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class RectanglesTest {

    @Test
    public void countRectangles1() {
        List<int[]> points = List.of(
                new int[]{0, -1},
                new int[]{4, 2},
                new int[]{4, 1},
                new int[]{3, 3},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{1, 4},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, 0},
                new int[]{2, 2},
                new int[]{2, 1}
        );  //immutable List
        Rectangles rectangles = new Rectangles();
        int result = rectangles.countRectangles(new ArrayList<>(points));
        System.out.println(result + "db tengelyekkel ||-os téglalapot tartalmaznak a megadott pontok.\n");
        assertEquals(5, result);
    }

    @Test
    public void countRectangles2() {
        List<int[]> points = List.of(
                new int[]{-1, 2},
                new int[]{-1, 0},
                new int[]{0, -1},
                new int[]{-10, -10},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, -2},
                new int[]{20, -1},
                new int[]{2, 2},
                new int[]{-1, -1},
                new int[]{0, 0},
                new int[]{0, -2},
                new int[]{2, -1},
                new int[]{1, 3},
                new int[]{2, 1}
        );
        Rectangles rectangles = new Rectangles();
        int result = rectangles.countRectangles(new ArrayList<>(points));
        System.out.println(result + "db tengelyekkel ||-os téglalapot tartalmaznak a megadott pontok.\n");
        assertEquals(4, result);
    }

}
