package gyak;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PairsWithTargetTest {

    @Test
    void reachTheTarget() {
        PairsWithTarget p = new PairsWithTarget();
        int[] a = {8, 5, 3, 2, -1, 9};
        int[] b = {4, 5, 10, 1, 20, 2};
        int target = 24;

        assertEquals(List.of(3, 20), p.reachTheTarget(a, b, target));

        assertEquals(List.of(20, 5), p.reachTheTarget(b, a, target));
    }

}
