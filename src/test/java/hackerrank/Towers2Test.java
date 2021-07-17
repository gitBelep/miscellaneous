package hackerrank;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Towers2Test {

    @Test
    void equalStacks() {
        Towers2 t = new Towers2();
        List<Integer> a = List.of(2, 1, 3, 1);
        List<Integer> b = List.of(2, 1, 2, 2, 1);
        List<Integer> v = List.of(1, 2, 2, 1, 1);
        List<Integer> o = List.of(0);
        List<Integer> c = List.of(3, 1, 1, 3, 1);
        List<Integer> d = List.of(2, 1, 2, 2, 1);
        List<Integer> e = List.of(4, 4, 1, 1);

        assertEquals(1, t.equalStacks2(a, b, v));
        assertEquals(6, t.equalStacks2(c, d, e));
        assertEquals(1, t.equalStacks2(v, b, a));
        assertEquals(6, t.equalStacks2(d, e, c));
        assertEquals(0, t.equalStacks2(d, e, null));
        assertEquals(0, t.equalStacks2(o, d, c));
        assertEquals(0, t.equalStacks2(d, c, o));
        assertEquals(0, t.equalStacks2(d, o, c));
    }

}
