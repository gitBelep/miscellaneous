package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class A05ThermalTest {

    @Test
    void horizontalAndVerticalLines() {
        var t = new A05Thermal();
        Path pTest = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "Thermal-test.txt");
        int resultTest = t.readFile(pTest, 'n');
        assertEquals(5, resultTest);       //Min 2 overlapping

        t = new A05Thermal();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "Thermal.txt");
        int result = t.readFile(path, 'n');
        assertEquals(8622, result);        //Min 2 overlapping:
    }

    @Test
    void also45DegreeDiagonalLines(){
        var t = new A05Thermal();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "Thermal.txt");
        int result = t.readFile(path, 'd');
        assertEquals(22037, result);        //Min 2 overlapping:
    }

}