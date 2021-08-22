package hackerrank;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MigratoryBirdsCounterTest {

    @Test
    void migration(){
        //3x "2" && 3x "4"
        List<Integer> ll= List.of(1,2,3,2,3,4,4,4,1001,1,2);
        //4x "1"
        List<Integer> l2= List.of(1,2,3,2,3,4,1, 4,1,4,1001,1,2);

        assertEquals(2, MigratoryBirdsCounter.migratoryBirds(ll));
        assertEquals(1, MigratoryBirdsCounter.migratoryBirds(l2));
    }

}
