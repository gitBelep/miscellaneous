package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    @Test
    void v1(){
        List<Integer> result = Leaderboard.climbingLeaderboard(
                new ArrayList<>(List.of(100,80)),
                List.of(10,80,90,100,120));

        System.out.println(result);
        assertEquals(List.of(3,2,2,1,1), result);
    }

}
