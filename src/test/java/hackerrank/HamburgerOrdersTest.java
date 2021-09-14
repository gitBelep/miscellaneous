package hackerrank;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HamburgerOrdersTest {

    @Test
    void testOrders() {
        HamburgerOrders h = new HamburgerOrders();

        List<List<Integer>> durations = List.of(
            List.of(0, 5), List.of(0, 4), List.of(1, 4), List.of(1, 2), List.of(2, 2)
        );

        List<Integer> result = h.reciving(durations);
        System.out.println(result);
        assertEquals(List.of(4, 2, 5, 1, 3), result);
    }
// start, duration = end  place(assertion)
// 1. ~ 0, 5 	= 5  4th
// 2. ~ 0, 4 	= 4  2nd
// 3. ~ 1, 4 	= 5  5th
// 4. ~ 1, 2 	= 3  1st
// 5. ~ 2, 2 	= 4  3rd
}
