package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A11OctopusTest {

    @Test
    void goTest() {
        A11Octopus o = new A11Octopus();
        A11Octopus t = new A11Octopus();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "11OctopusTest.txt");

        assertEquals( 204, o.go(path, "normal",  10));
        assertEquals(1656, t.go(path, "normal", 100));
    }

    @Test
    void goLive() {
        A11Octopus o = new A11Octopus();
        A11Octopus t = new A11Octopus();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "11Octopus.txt");

        assertEquals(1729, t.go(path, "normal", 100));
    }


}