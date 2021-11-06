package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> results = new ArrayList<>();
        for(int p : player){
            List<Integer> ranked2 = new ArrayList<>(ranked);
            ranked2.add(p);
            ranked2.sort(Comparator.reverseOrder());
            int rank = 0;
            int valueBefore = Integer.MAX_VALUE;
            for(int r : ranked2){
                if(r != valueBefore){
                    rank++;
                }
                valueBefore = r;
                if(p == r){
                    results.add(rank);
                    break;
                }
            }
        }
        return results;
    }

}
