package hackerrank;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class QueensAttackTest {

    @Test
    public void qa(){
        List<List<Integer>> actualList = List.of(List.of(5,5), List.of(4,2), List.of(2,3));
        int result = QueensAttack.queensAttack(5, 3, 4, 3, actualList);
        assertEquals(10, result);
    }

    @Test
    public void qb(){
        List<List<Integer>> actualList = null;
        int result = QueensAttack.queensAttack(4, 0, 4, 4, actualList);
        assertEquals(9, result);
    }

}