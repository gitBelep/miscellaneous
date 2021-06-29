package gyak;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FelbontasOsszegreTest {

    @Test
    @Disabled("Same as the @RepeatedTest")
    void bontsdFel() {
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals(f.howMany(4,6), f.bontsdFel(4,6) );  //10 = 6+3+1
        assertEquals(f.howMany(4,7), f.bontsdFel(4,7) );  //20 = 10+6+3+1
        assertEquals(f.howMany(4,8), f.bontsdFel(4,8) );  //35 = 15+10+6+3+1

        assertEquals( f.howMany(2,6), f.bontsdFel(2,6) );  //5
        assertEquals( f.howMany(2,7), f.bontsdFel(2,7) );  //6
        assertEquals( f.howMany(2,8), f.bontsdFel(2,8) );  //7

        assertEquals(f.howMany(3,6), f.bontsdFel(3,6) );  //10
        assertEquals(f.howMany(3,7), f.bontsdFel(3,7));   //15
        assertEquals(f.howMany(3,8), f.bontsdFel(3,8) );  //21
    }

    private int[][] testValues = {{4,6,10},{4,7,20},{4,8,35},{2,6,5},{2,7,6},{2,8,7},{3,6,10},{3,7,15},{3,8,21}};

    @RepeatedTest(value = 9, name = "felbontás{currentRepetition}/{totalRepetitions}")
    void testBontsdFel(RepetitionInfo ri){
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals( testValues[ri.getCurrentRepetition()-1][2],
                f.bontsdFel(testValues[ri.getCurrentRepetition()-1][0],testValues[ri.getCurrentRepetition()-1][1]) );
    }

    @Test
    @DisplayName("Bigger duty ~ 13 sec")
    void naEztbontsdFel() {
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals(1140, f.bontsdFel(4,21) );
        assertEquals(1176, f.bontsdFel(3,50) );
        assertEquals(1_499_784, f.bontsdFel(4,210) );
    }

    @Test
    @DisplayName("Testing throwing Exceptions")
    void testFalseInput(){
        FelbontasOsszegre f = new FelbontasOsszegre();

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class,
                () -> f.bontsdFel(1,7) );
        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class,
                () -> f.bontsdFel(4,3));

        assertEquals("A tagok száma legalább 2 legfeljebb 4 legyen!", e1.getMessage());
        assertEquals("A felbontandó szám legalább akkora legyen, mint a tagok száma!", e2.getMessage());
    }

}