package DailyCodingProblem;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CountSubarraysTest {

    @Test
    void birthday() {
        CountSubarrays c = new CountSubarrays();
        List<Integer> myList = List.of(1,0,1,1,2,0,4,1,0);

        assertEquals( 2, c.birthday( myList,2,2));
        assertEquals( 2, c.birthday( myList,2,3));
        assertEquals( 2, c.birthday( myList,5,3));
        assertEquals( 1, c.birthday( myList,3,2));
        assertEquals( 0, c.birthday( myList,7,3));
    }

    @Test
    void findNewRecords(){
        CountSubarrays c = new CountSubarrays();
        List<Integer> myList = List.of(10,5,11,0,1,2,10,11,12,0,4);
        List<Integer> myLis2 = List.of(10,5,11,10, 4, 0,1,2,10,11,12,0,-4,12);

        assertEquals(List.of(2,2), c.breakingRecords(myList));
        assertEquals(List.of(2,4), c.breakingRecords(myLis2));
    }

    @Test
    void testNonAdjacent(){
        CountSubarrays c = new CountSubarrays();
        assertEquals(19, c.nonAdjacentMax(List.of(0,10,11,9,1)));  //2+3 ~19
        assertEquals(20, c.nonAdjacentMax(List.of(9,10,11,8,1)));  //1+3 ~20
        assertEquals(27, c.nonAdjacentMax(List.of(8,10,19,9,1)));  //1+4 ~27
        assertEquals(21, c.nonAdjacentMax(List.of(0,10,9,11,5,1)));  //2+1 ~21
        assertEquals(4, c.nonAdjacentMax(List.of(-1,-10,-9,-11,5,0)));  //3+1 ~4
        assertEquals(20, c.nonAdjacentMax(List.of(0,10,11,10,8)));  //2+3 ~20
        assertEquals(16, c.nonAdjacentMax(List.of(8,9,8,-100,-9)));  //2+3 ~16
    }

}
