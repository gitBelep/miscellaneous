package gyak;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FalseMagicSquareTest {

    @Test
    void testMagic1(){
        List<Integer> r01 = Arrays.asList(2,2,2);
        List<Integer> r02 = Arrays.asList(2,3,2);
        List<Integer> r03 = Arrays.asList(2,2,0);
        List<List<Integer>> sq1 = Arrays.asList(r01, r02, r03);

        assertEquals(3, FalseMagicSquare.formingMagicSquare(sq1) );
    }

    @Test
    void testMagic2(){
        List<Integer> r01 = Arrays.asList(4,9,2);
        List<Integer> r02 = Arrays.asList(3,5,7);
        List<Integer> r03 = Arrays.asList(8,1,5);
        List<List<Integer>> sq2 = Arrays.asList(r01, r02, r03);

        assertEquals(1, FalseMagicSquare.formingMagicSquare(sq2) );
    }

    @Test
    void testMagic3(){
        List<Integer> r01 = Arrays.asList(4,8,2);
        List<Integer> r02 = Arrays.asList(4,5,7);
        List<Integer> r03 = Arrays.asList(6,1,6);
        List<List<Integer>> sq2 = Arrays.asList(r01, r02, r03);

        //expectation: sum=14, costs=3; method makes sum=15, costs=4
        assertEquals(3, FalseMagicSquare.formingMagicSquare(sq2) );
    }

}
