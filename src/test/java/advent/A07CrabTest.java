package advent;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class A07CrabTest {

//    @Test
//        List<Integer> l1 = new ArrayList<>(List.of(-1000, 3, 4, 5, 4));         //3: 1006
//        List<Integer> l2 = new ArrayList<>(List.of(3, 4, 5));                   //4: 2
//        List<Integer> l3 = new ArrayList<>(List.of(-1000, -900, 3, 4, 5, 4));   //3: 1910
//    }

    @Test
    void simulatePositions() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "CrabSubmarinesPos.txt");
        A07Crab c = new A07Crab();
        assertEquals(343605, c.simulateCrabPositions(path, "normal"));  //345: 343 605
    }


    @Test
    void simulatePosByExponentialFuelneeds() {
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "CrabSubmarinesPos.txt");
        A07Crab c = new A07Crab();
        assertEquals(96744904, c.simulateCrabPositions(path, "exponential"));     //475: 96 744 904
    }

}