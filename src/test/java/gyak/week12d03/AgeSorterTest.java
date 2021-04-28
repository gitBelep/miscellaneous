package gyak.week12d03;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class AgeSorterTest {

    @Test
    void sortAges() {
        AgeSorter ageSorter = new AgeSorter();
        int[] alap = {7, 4, 10, 89, 3, 101, 5, 4, 10};

        int[] atadott = Arrays.copyOf(alap, alap.length);
        int[] returned = ageSorter.sortAges(atadott);
        int[] eredeti = Arrays.copyOf(alap, alap.length);
        Arrays.sort(alap);

        assertArrayEquals(alap, returned);

        System.out.println("eredeti:   "+Arrays.toString(eredeti));
        System.out.println("atadott:   "+Arrays.toString(atadott));
        System.out.println("alap.sort: "+Arrays.toString(alap));
        System.out.println("returned:  "+Arrays.toString(returned));
    }
}
