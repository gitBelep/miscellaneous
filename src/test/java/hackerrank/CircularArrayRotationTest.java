package hackerrank;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CircularArrayRotationTest {

    @Test
    void testRotatoin() {
        List<Integer> a1 = List.of(1, 2, 3);
        int rotation1 = 2;       //2, 3, 1
        List<Integer> q1 = List.of(0, 1, 2);

        List<Integer> a2 = List.of(0, 1, 2, 3, 4, 5, 6);
        int rotation2 = 3;       //4, 5, 6, 0, 1, 2, 3
        List<Integer> q2 = List.of(0, 2, 18);

        assertEquals(List.of(2, 3, 1), CircularArrayRotation.circularArrayRotation(a1, rotation1, q1));
        assertEquals(List.of(4, 6, 1), CircularArrayRotation.circularArrayRotation(a2, rotation2, q2));
    }

}
