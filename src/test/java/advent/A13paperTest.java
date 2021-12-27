package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A13paperTest {

    @Test
    void TestFirst() {
        A13paper p = new A13paper();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "13TestPaper.txt");

        assertEquals( 17, p.go(path,"first"));
    }

    @Test
    void doFirst() {
        A13paper p = new A13paper();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "13Paper.txt");

        assertEquals( 745, p.go(path, "first"));
    }

    @Test
    void doAll() {
        A13paper p = new A13paper();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "13Paper.txt");

        assertEquals( 99, p.go(path, "all"));
    }

}
