package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A20TrenchMapTest {

    @Test
    void go() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "20TrenchMap.txt");
        A20TrenchMap t = new A20TrenchMap();

        assertEquals(4873, t.go(path, 2));
    }

}
