package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A08DisplayTest {

    @Test
    void testTestImpulses(){
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "8Test_5db.txt");
        A08Display display = new A08Display();

        assertEquals(5, display.clearDigits(path, "onlyFewNumbers"));
    }

    @Test
    void testImpulses(){
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "8impulses.txt");
        A08Display display = new A08Display();

        assertEquals(330, display.clearDigits(path, "1,4,7,8"));
    }

    @Test
    void testOneTestImpulses(){ //9,5,2,1
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "8impTest1Line.txt");
        A08Display display = new A08Display();

        assertEquals(9521, display.clearDigits(path, "all"));
    }

    @Test
    void testAllImpulses(){
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "8impulses.txt");
        A08Display display = new A08Display();

        assertEquals(1010472, display.clearDigits(path, "all"));
    }

}
