package hackerrank;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ArrMinMaxTest {

    @Test
    void testArrays() {
        List<Integer> l1 = Arrays.asList(10, 100, 300, 200, 1000, 20, 30);
        List<Integer> l2 = Arrays.asList(200, 100, 40, 30, 20, 10, 4, 3, 2, 1);
        List<Integer> l3 = Arrays.asList(1, 2, 1, 2, 1);
        List<Integer> l4 = Arrays.asList(10, 20, 30, 31, 32);

        assertEquals(20, ArrMinMax.maxMin(3, l1));
        assertEquals(3, ArrMinMax.maxMin(4, l2));
        assertEquals(0, ArrMinMax.maxMin(2, l3));
        assertEquals(2, ArrMinMax.maxMin(3, l4));
    }

}
