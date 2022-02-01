package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A09SmokeTest {

    @Test
    void points() {
            Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "9Smoke.txt");
            A09Smoke sm = new A09Smoke();
            assertEquals(575, sm.findSmoke(path, "Find only the deepest points"));
    }

    @Test
    void givenAreaMultiplikation() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "9SmokeTest.txt");
        A09Smoke sm = new A09Smoke();
        assertEquals(1134, sm.findSmoke(path, "Multiple the 3 biggest basins area"));
    } //x > 14*9*9

    @Test
    void areaMultiplikation() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "9Smoke.txt");
        A09Smoke sm = new A09Smoke();
        assertEquals(575, sm.findSmoke(path, "Multiple the 3 biggest basins area"));
    } //x > 25 172

}
