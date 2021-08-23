package hackerrank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoStacksTest {

    @Test
    void testMixing(){
        int[] b1 = {17,1,1,1,8};
        int[] a1 = {8,8, 4,5,9};
        int max = 20;
        TwoStacks s = new TwoStacks();

        assertEquals(4, s.takeElements(a1,b1,max));

    }

}
