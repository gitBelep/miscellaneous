package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A25SeaCucumbersTest {

    @Test
    void parkingTestGiven() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "25cuccTest.txt");
        A25SeaCucumbers cuc = new A25SeaCucumbers();

        assertEquals(58, cuc.parking(path));
    }

    @Test
    void parkingTest() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "25cucumber.txt");
        A25SeaCucumbers cuc = new A25SeaCucumbers();

        assertEquals(378, cuc.parking(path));
    }

}