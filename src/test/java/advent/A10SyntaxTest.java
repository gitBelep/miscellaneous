package advent;

import gyak.A;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class A10SyntaxTest {

    @Test
    void clearSyntax() {
        A10Syntax sy = new A10Syntax();
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "10Syntax.txt");
        assertEquals(288_291, sy.clearSyntax(path) );
        //vigyázat, a zárójelek és a pont os bír regex jelentéssel !
    }




}