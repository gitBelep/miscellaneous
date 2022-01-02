package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class A14PolymerTest {

    @Test
    void TestFirstMap() {
        A14Polymer p1 = new A14Polymer();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "14poly.txt");

        assertEquals(1588, p1.go(path, 10));
    }

    @Test
    void realMap10() {
        A14Polymer p1 = new A14Polymer();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "14polymer.txt");

        assertEquals(2584, p1.go(path, 10));
    }

    @Test
    void realMap40() {
        A14Polymer p1 = new A14Polymer();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "14polymer.txt");

        assertEquals("3816397135460", p1.go(path, 40).toString());
    }

}
