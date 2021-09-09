package gyak;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OneGreaterTest {

    @Test
    void testOneGreater() {
        OneGreater g = new OneGreater();
        assertEquals(Arrays.asList(1, 2, 3, 2), g.getOneGreater(new int[]{1, 2, 2, 3}));
        assertEquals(Arrays.asList(1, 3, 2, 2), g.getOneGreater(new int[]{1, 2, 3, 2}));
        assertEquals(Arrays.asList(2, 1, 2, 3), g.getOneGreater(new int[]{1, 3, 2, 2}));
        assertEquals(Arrays.asList(2, 1, 3, 2), g.getOneGreater(new int[]{2, 1, 2, 3}));
        assertEquals(Arrays.asList(2, 2, 1, 3), g.getOneGreater(new int[]{2, 1, 3, 2}));

        assertEquals(Arrays.asList(4, 5, 1, 1, 2, 5), g.getOneGreater(new int[]{4, 2, 5, 5, 1, 1}));
    }

}
