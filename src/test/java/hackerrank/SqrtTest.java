package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    void sq(){
        assertEquals(3, Sqrt.squares( 35,70));
        assertEquals(22, Sqrt.squares( 100,1000));
        assertEquals(2,Sqrt.squares( 4,10));
        assertEquals(2, Sqrt.squares(3,9));
    }

}
