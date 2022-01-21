package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A09SmokeTest {

    @Test
    void parking() {
            Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "9Smoke.txt");
            A09Smoke sm = new A09Smoke();
            assertEquals(575, sm.findSmoke(path));
    }

}
