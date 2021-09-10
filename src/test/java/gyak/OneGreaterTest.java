package gyak;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OneGreaterTest {

    @Test
    @Disabled("Returning value changed to int")
    void testOneGreaterToList() {
        OneGreater g = new OneGreater();
        assertEquals(Arrays.asList(1, 2, 3, 2), g.getOneGreater(new int[]{1, 2, 2, 3}));
        assertEquals(Arrays.asList(1, 3, 2, 2), g.getOneGreater(new int[]{1, 2, 3, 2}));
        assertEquals(Arrays.asList(2, 1, 2, 3), g.getOneGreater(new int[]{1, 3, 2, 2}));
        assertEquals(Arrays.asList(2, 1, 3, 2), g.getOneGreater(new int[]{2, 1, 2, 3}));
        assertEquals(Arrays.asList(2, 2, 1, 3), g.getOneGreater(new int[]{2, 1, 3, 2}));

        assertEquals(Arrays.asList(4, 5, 1, 1, 2, 5), g.getOneGreater(new int[]{4, 2, 5, 5, 1, 1}));
    }

    @Test
    void testOneGreaterToInt() {
        OneGreater g = new OneGreater();
        assertEquals(1232, g.getOneGreater(new int[]{1, 2, 2, 3}));
        assertEquals(1322, g.getOneGreater(new int[]{1, 2, 3, 2}));
        assertEquals(2123, g.getOneGreater(new int[]{1, 3, 2, 2}));
        assertEquals(2132, g.getOneGreater(new int[]{2, 1, 2, 3}));
        assertEquals(2213, g.getOneGreater(new int[]{2, 1, 3, 2}));

        assertEquals(451125, g.getOneGreater(new int[]{4, 2, 5, 5, 1, 1}));
    }

    @Test
    void testOneGreaterWithMax() {
        OneGreater g = new OneGreater();
        assertEquals(1223, g.getOneGreater(new int[]{3, 2, 2, 1}));
        assertEquals(112455, g.getOneGreater(new int[]{5, 5, 4, 2, 1, 1}));
    }

}
