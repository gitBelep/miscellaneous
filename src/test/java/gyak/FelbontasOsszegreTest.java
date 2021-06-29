package gyak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FelbontasOsszegreTest {

    @Test
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

    

}