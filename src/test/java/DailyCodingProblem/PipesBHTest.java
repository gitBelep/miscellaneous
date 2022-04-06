package DailyCodingProblem;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PipesBHTest {

    @Test
    void findCheapestVariation1() {
        Map<String, Map<String, Integer>> wholeWeb = Map.of(
                "plant", Map.of("C",1, "B",70, "A",71));
        List<House> pWeb = new PipesBH().findCheapestVariation(wholeWeb);
        pWeb.sort(null);
        System.out.println(pWeb);

        Map<String, Map<String, Integer>> wholeWeb1 = Map.of(
                "plant", Map.of("A",1),
                "B", Map.of("C", 70),
                "A", Map.of("B",69));
        List<House> pWeb1 = new PipesBH().findCheapestVariation(wholeWeb1);
        System.out.println(pWeb1);
    }

    @Test
    void findCheapestVariation2() {
        Map<String, Map<String, Integer>> wholeWeb1 = Map.of(
                "plant", Map.of("A", 10),
                "Z", Map.of("A", 69),
                "B", Map.of("A", 7),
                "R", Map.of("A", 8)
        );
        List<House> pWeb1 = new PipesBH().findCheapestVariation(wholeWeb1);
        System.out.println(pWeb1);
    }

    @Test
    void findCheapestVariation3() {
        Map<String, Map<String, Integer>> wholeWeb = Map.of(
                "plant", Map.of("A",1, "B",70, "C",71), //A1
                "A", Map.of("B",69, "C", 2, "D",70),        //C2, B69
                "B", Map.of("A",1, "C", 70, "D", 70),       //A1
                "Q", Map.of("A",70, "C",70),                       //
                "C", Map.of("B",70, "Q",20, "D",2)          //Q20,D2
        );
        List<House> pWeb = new PipesBH().findCheapestVariation(wholeWeb);
        System.out.println(pWeb);
      //  assertEquals();
    }

    //if there is no plant ?? :-)

}