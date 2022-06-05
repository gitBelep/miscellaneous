package DailyCodingProblem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AscSubArrayTest {

    AscSubArray a = new AscSubArray();

    @Test
    void testBeginingOfLongestAscendingSubArray() {
        assertEquals(0, a.beginingOfLongestAscendingSubArray( new int[]{69} ));
        assertEquals(0, a.beginingOfLongestAscendingSubArray( new int[]{69,2} ));
        assertEquals(0, a.beginingOfLongestAscendingSubArray( new int[]{69,2,0} ));
        assertEquals(2, a.beginingOfLongestAscendingSubArray( new int[]{69,69,2,2,2,2} ));
        assertEquals(6, a.beginingOfLongestAscendingSubArray( new int[]{8,-7,2,-6,2,3,-5,2,3,4,5,-4,2,3,4} ));
        assertEquals(6, a.beginingOfLongestAscendingSubArray( new int[]{8,-5,2,-6,-6,3,-7,-7,-7,-7,5,-4,2,3,4} ));
    }

    @Test
    void testFalseDataByBegining() {
        assertEquals( -2, a.beginingOfLongestAscendingSubArray(null) );
        assertEquals(-1, a.beginingOfLongestAscendingSubArray( new int[0] ));
    }

    @Test
    void testLengthOfLongestAscendingSubArray() {
        assertEquals(1, a.lengthOfLongestAscendingSubArray( new int[]{69} ));
        assertEquals(1, a.lengthOfLongestAscendingSubArray( new int[]{69,2} ));
        assertEquals(1, a.lengthOfLongestAscendingSubArray( new int[]{69,2,0} ));
        assertEquals(4, a.lengthOfLongestAscendingSubArray( new int[]{69,69,2,2,2,2} ));
        assertEquals(5, a.lengthOfLongestAscendingSubArray( new int[]{8,-7,2,-6,2,3,-5,2,3,4,5,-4,2,3,4} ));
        assertEquals(5, a.lengthOfLongestAscendingSubArray( new int[]{8,-5,2,-6,-6,3,-7,-7,-7,-7,5,-4,2,3,4} ));
    }

    @Test
    void testFalseDataByLength() {
        assertEquals( -2, a.lengthOfLongestAscendingSubArray(null) );
        assertEquals(-1, a.lengthOfLongestAscendingSubArray( new int[0] ));
    }

}
