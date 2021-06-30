package gyak;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FelbontasOsszegreTest {

    @Test
    @Disabled("Same as the @RepeatedTest")
    void bontsdFel() {
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals(f.howMany(4,6), f.bontsdFel1(4,6) );  //10 = 6+3+1
        assertEquals(f.howMany(4,7), f.bontsdFel1(4,7) );  //20 = 10+6+3+1
        assertEquals(f.howMany(4,8), f.bontsdFel1(4,8) );  //35 = 15+10+6+3+1

        assertEquals( f.howMany(2,6), f.bontsdFel1(2,6) );  //5
        assertEquals( f.howMany(2,7), f.bontsdFel1(2,7) );  //6
        assertEquals( f.howMany(2,8), f.bontsdFel1(2,8) );  //7

        assertEquals(f.howMany(3,6), f.bontsdFel1(3,6) );  //10
        assertEquals(f.howMany(3,7), f.bontsdFel1(3,7));   //15
        assertEquals(f.howMany(3,8), f.bontsdFel1(3,8) );  //21
    }

    private int[][] testValues = {{4,6,10},{4,7,20},{4,8,35},{2,6,5},{2,7,6},{2,8,7},{3,6,10},{3,7,15},{3,8,21}};

    @RepeatedTest(value = 9, name = "felbontás{currentRepetition}/{totalRepetitions}")
    void testBontsdFel(RepetitionInfo ri){
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals( testValues[ri.getCurrentRepetition()-1][2],
                f.bontsdFel1(testValues[ri.getCurrentRepetition()-1][0],testValues[ri.getCurrentRepetition()-1][1]) );
    }

    @Test
    @DisplayName("Bigger duty 1 ~ 6-13 sec")
    void naEztbontsdFel1() {
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals(1_499_784, f.bontsdFel1(4,210) );
    }

    @Test
    @DisplayName("Bigger duty 3 ~ 67 sec")
    void naEztbontsdFel3() {
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals(1_499_784, f.bontsdFel3(4,210) );
    }

    @Test
    @DisplayName("Bigger duty 2 ~ 6-13 sec")
    void naEztbontsdFel2() {
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertEquals(1_499_784, f.bontsdFel2(4,210) );
    }


    @Test
    @DisplayName("Testing throwing Exceptions")
    void testFalseInput(){
        FelbontasOsszegre f = new FelbontasOsszegre();

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class,
                () -> f.bontsdFel1(1,7) );
        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class,
                () -> f.bontsdFel1(4,3));

        assertEquals("A tagok száma legalább 2 legfeljebb 4 legyen!", e1.getMessage());
        assertEquals("A felbontandó szám legalább akkora legyen, mint a tagok száma!", e2.getMessage());
    }

    @Test
    @Tag("Competition")
    void testCompetition2(){
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertAll(
                () -> assertEquals(1140, f.bontsdFel2(4,21) ),
                () -> assertEquals(19_600, f.bontsdFel1(4,51) ),
                () -> assertEquals(1176, f.bontsdFel2(3,50) ));
    }

    @Test
    @Tag("Competition")
    void testCompetition1(){
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertAll(
                () -> assertEquals(1140, f.bontsdFel1(4,21) ),
                () -> assertEquals(19_600, f.bontsdFel1(4,51) ),
                () -> assertEquals(1176, f.bontsdFel1(3,50) ));
    }

    @Test
    @Tag("Competition")
    void testCompetition3(){
        FelbontasOsszegre f = new FelbontasOsszegre();
        assertAll(
                () -> assertEquals(1140, f.bontsdFel3(4,21) ),
                () -> assertEquals(19_600, f.bontsdFel1(4,51) ),
                () -> assertEquals(1176, f.bontsdFel3(3,50) ));
    }

}