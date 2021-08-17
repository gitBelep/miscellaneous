package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Towers3Test {

    @Test
    void equalStacks() {
        Towers3 t = new Towers3();
        List<Integer> a = List.of(2, 1, 3, 1);
        List<Integer> b = List.of(2, 1, 2, 2, 1);
        List<Integer> v = List.of(1, 2, 2, 1, 1);
        List<Integer> o = List.of(0);
        List<Integer> c = List.of(3, 1, 1, 3, 1);
        List<Integer> d = List.of(2, 1, 2, 2, 1);
        List<Integer> e = List.of(4, 4, 1, 1);

        assertEquals(1, t.equalStacks(a, b, v));
        assertEquals(6, t.equalStacks(c, d, e));
        assertEquals(1, t.equalStacks(v, b, a));
        assertEquals(6, t.equalStacks(d, e, c));
        assertEquals(0, t.equalStacks(d, e, null));
        assertEquals(0, t.equalStacks(o, d, c));
        assertEquals(0, t.equalStacks(d, c, o));
        assertEquals(0, t.equalStacks(d, o, c));
    }
}