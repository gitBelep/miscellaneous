package gyak;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DifferendSodokuBoardsTest {

    @Test
    void testWithOneBoard(){
        DifferendSodokuBoards sodoku = new DifferendSodokuBoards();
        sodoku.makeStatisticsAboutCornerElements(Path.of(
                "c:", "training", "miscellaneous", "src","main","resources","Sodoku-oneBoard.txt"));

        assertEquals(List.of("63841752", "84137562", "75824361", "85137246"), sodoku.getStatistics());
        assertEquals(Collections.emptyList(), sodoku.getSameMusters());
    }

    @Test
    void testWithTwoBoardsTwoTimesSameMuster(){
        DifferendSodokuBoards sodoku = new DifferendSodokuBoards();
        sodoku.makeStatisticsAboutCornerElements(Path.of(
                "c:", "training", "miscellaneous", "src","main","resources","Sodoku-twoBoards.txt"));

        assertEquals(List.of("63841752", "84137562", "75824361", "85137246",
                "41235876", "7654231", "63841752", "75824361"), sodoku.getStatistics());
        assertEquals(2, sodoku.getSameMusters().size());
    }

    @Test
    void runWithLotsOfBoards(){
        DifferendSodokuBoards sodoku = new DifferendSodokuBoards();
        sodoku.makeStatisticsAboutCornerElements(Path.of(
                "c:", "training", "miscellaneous", "src","main","resources","Sodoku-lotsOfBoards.txt"));
    }

}
