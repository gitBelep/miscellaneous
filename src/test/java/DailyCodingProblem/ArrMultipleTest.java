package DailyCodingProblem;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ArrMultipleTest {

    @Test
    public void testMultipleExceptOfI() {
        ArrMultiple m = new ArrMultiple();

        int[] result1 = m.multipleExceptOfI(new int[]{3, 2, 1});
        System.out.println(Arrays.toString(result1));
        assertArrayEquals(new int[]{2, 3, 6}, result1);

        int[] result2 = m.multipleExceptOfI(new int[]{4, 5, 3, 2});
        System.out.println(Arrays.toString(result2));
        assertArrayEquals(new int[]{30, 24, 40, 60}, result2);

        int[] result4 = m.multipleExceptOfI(new int[]{-4, 5, -3, 2});
        System.out.println(Arrays.toString(result4));
        assertArrayEquals(new int[]{-30, 24, -40, 60}, result4);

        int[] result3 = m.multipleExceptOfI(new int[]{4, 5, 3, 2, 0});
        System.out.println(Arrays.toString(result3));
        assertArrayEquals(new int[]{0, 0, 0, 0, 120}, result3);

        int[] result5 = m.multipleExceptOfI(new int[]{0, -5, 150, 2, 0});
        System.out.println(Arrays.toString(result5));
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, result5);
    }

    @Test
    public void testMultipleExceptOfIWithoutDivision() {
        ArrMultiple m = new ArrMultiple();

        int[] result1 = m.multipleExceptOfIWithoutDivision(new int[]{3, 2, 1});
        assertArrayEquals(new int[]{2, 3, 6}, result1);

        int[] result2 = m.multipleExceptOfIWithoutDivision(new int[]{4, 5, 3, 2});
        assertArrayEquals(new int[]{30, 24, 40, 60}, result2);

        int[] result4 = m.multipleExceptOfIWithoutDivision(new int[]{-4, 5, -3, 2});
        assertArrayEquals(new int[]{-30, 24, -40, 60}, result4);

        int[] result3 = m.multipleExceptOfIWithoutDivision(new int[]{4, 5, 3, 2, 0});
        assertArrayEquals(new int[]{0, 0, 0, 0, 120}, result3);

        int[] result5 = m.multipleExceptOfIWithoutDivision(new int[]{0, -5, 150, 2, 0});
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, result5);
    }

    @Test
    public void testUniversalButBadSolution(){
        ArrMultiple m = new ArrMultiple();

        int[] result1 = m.universalButSlowMultipleExceptOfIWithoutDivision(new int[]{3, 2, 1});
        assertArrayEquals(new int[]{2, 3, 6}, result1);

        int[] result2 = m.universalButSlowMultipleExceptOfIWithoutDivision(new int[]{4, 5, 3, 2});
        assertArrayEquals(new int[]{30, 24, 40, 60}, result2);

        int[] result4 = m.universalButSlowMultipleExceptOfIWithoutDivision(new int[]{-4, 5, -3, 2});
        assertArrayEquals(new int[]{-30, 24, -40, 60}, result4);

        int[] result3 = m.universalButSlowMultipleExceptOfIWithoutDivision(new int[]{4, 5, 3, 2, 0});
        assertArrayEquals(new int[]{0, 0, 0, 0, 120}, result3);

        int[] result5 = m.universalButSlowMultipleExceptOfIWithoutDivision(new int[]{0, -5, 150, 2, 0});
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, result5);
    }
}
