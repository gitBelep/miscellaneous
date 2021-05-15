package gyak;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class SumInSortedArrayTest {

    @Test
    public void findSumInArray() {
        SumInSortedArray s = new SumInSortedArray();
        int[] arr3 = new int[]{-10, -9, 1, 2, 3, 4, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 77, 1001, 1002};

        List<int[]> list9 = s.findSumInArray(arr3, -19);
        System.out.println("-19: " + Arrays.toString( list9.get(0) ));
        assertEquals(1, list9.size());
    }

    @Test
    public void testFindSumInArray() {
        SumInSortedArray s = new SumInSortedArray();
        int[] arr1 = new int[]{-10, 1,1,1,4,10,12,15,15,1001};

        List<int[]> list1 = s.findSumInArray(arr1, 14);
        System.out.println("14: " + Arrays.toString( list1.get(0) ));
        assertEquals(1, list1.size());

        List<int[]> list2 = s.findSumInArray(arr1, 9);
        System.out.println("9: " + list2.size());
        assertEquals(0, list2.size());
    }
}