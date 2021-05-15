package gyak;

import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumInSortedArrayDTest {

    @Test
    public void findSumInArray() {
        SumInSortedArrayD d = new SumInSortedArrayD();

        int[] arr1 = new int[]{-5, -5, -5,-3,-1,-1,-1};

        Map<Integer, Integer> r1 = d.findSumInArray(arr1, -20);
        System.out.println(-20 + r1.toString());
        assertEquals(0 , r1.size());

        Map<Integer, Integer> r2 = d.findSumInArray(arr1, -8);
        System.out.println(-8 + r2.toString());
        assertEquals(1 , r2.size());

        Map<Integer, Integer> r4 = d.findSumInArray(arr1, 0);
        System.out.println(0 + r4.toString());
        assertEquals(0 , r4.size());

        Map<Integer, Integer> r3 = d.findSumInArray(arr1, -2);
        System.out.println(-2 + r3.toString());
        assertEquals(1 , r3.size());
    }

    @Test
    public void findSumInArray2() {
        SumInSortedArrayD d = new SumInSortedArrayD();

        int[] arr1 = new int[]{-2, 0, 1, 2, 3, 5, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 71, 77};

        Map<Integer, Integer> r1 = d.findSumInArray(arr1, 3);
        System.out.println(3 + r1.toString());
        assertEquals(3, r1.size());

        Map<Integer, Integer> r2 = d.findSumInArray(arr1, 2);
        System.out.println(2 + r2.toString());
        assertEquals(2, r2.size());

        Map<Integer, Integer> r4 = d.findSumInArray(arr1, 148);
        System.out.println(148 + r4.toString());
        assertEquals(1, r4.size());

        Map<Integer, Integer> r5 = d.findSumInArray(arr1, 55);
        System.out.println(55 + r5.toString());
        assertEquals(0, r5.size());

    }

    @Test
    public void findSumInArray3() {
        SumInSortedArrayD d = new SumInSortedArrayD();

        int[] arr1 = new int[]{-2, 0, 1, 2, 3, 77};

        Map<Integer, Integer> r3 = d.findSumInArray(arr1, -2);
        System.out.println(-2 + r3.toString());
        assertEquals(1, r3.size());

        Map<Integer, Integer> r2 = d.findSumInArray(arr1, 77);
        System.out.println(77 + r2.toString());
        assertEquals(1, r2.size());

        Map<Integer, Integer> r1 = d.findSumInArray(arr1, 75);
        System.out.println(75 + r1.toString());
        assertEquals(1, r1.size());

        Map<Integer, Integer> r4 = d.findSumInArray(arr1, 80);
        System.out.println(80 + r4.toString());
        assertEquals(1, r4.size());

        Map<Integer, Integer> r5 = d.findSumInArray(arr1, 800);
        System.out.println(800 + r5.toString());
        assertEquals(0, r5.size());

    }
}