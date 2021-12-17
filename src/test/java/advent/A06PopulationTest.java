package advent;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class A06PopulationTest {

// today       4,1
// 1           3,0
// 2           2,6,8
// 3           1,5,7
// 4           0,4,6
// 5           6,3,5,8

    @Test
    void simulateFishPopulationTest() {
        Path tank = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "popFishTank.hal");
        A06Population testExperiment = new A06Population();

        long testResult1 = testExperiment.simulateFishPopulation(tank, 1, "small");
        //System.out.println(testExperiment.getFishList().toString());
        long testResult2 = testExperiment.simulateFishPopulation(tank, 2, "small");
        //System.out.println(testExperiment.getFishList().toString());
        long testResult4 = testExperiment.simulateFishPopulation(tank, 4, "small");
        //System.out.println(testExperiment.getFishList().toString());
        long testResult5 = testExperiment.simulateFishPopulation(tank, 5, "small");
        //System.out.println(testExperiment.getFishList().toString());

        assertEquals(2, testResult1);
        assertEquals(3, testResult2);
        assertEquals(3, testResult4);
        assertEquals(4, testResult5);
    }

    @Test
    void simulateFishPopulation() {
        A06Population experiment = new A06Population();

        Path sea = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "population.hal");
        long sizeOfPopulation = experiment.simulateFishPopulation(sea, 80, "small");
        assertEquals(358214, sizeOfPopulation);
    }

    @Test
    void simulateBigFishPopulationTest() {
        Path tank = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "popFishTank.hal");
        A06Population testExperiment = new A06Population();

        long testResult1 = testExperiment.simulateFishPopulation(tank, 1, "big");
        System.out.println(testExperiment.getFishPopulation().toString());
        long testResult2 = testExperiment.simulateFishPopulation(tank, 2, "big");
        System.out.println(testExperiment.getFishPopulation().toString());
        long testResult4 = testExperiment.simulateFishPopulation(tank, 4, "big");
        System.out.println(testExperiment.getFishPopulation().toString());
        long testResult5 = testExperiment.simulateFishPopulation(tank, 5, "big");
        System.out.println(testExperiment.getFishPopulation().toString());

        assertEquals(2, testResult1);
        assertEquals(3, testResult2);
        assertEquals(3, testResult4);
        assertEquals(4, testResult5);
    }

    @Test
    void simulateAVeryBigFishPopulation() {
        A06Population experiment = new A06Population();

        Path ocean = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "population.hal");
        long sizeOfPopulation = experiment.simulateFishPopulation(ocean, 256, "big");
        assertEquals(1622533344325L, sizeOfPopulation);
    }

}