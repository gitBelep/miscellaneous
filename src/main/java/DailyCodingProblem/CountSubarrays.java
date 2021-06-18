package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class CountSubarrays {

    //count subarrays where length of these = "length" & in where sum = "target".
    public int birthday(List<Integer> list, int target, int length) {
        int counter = 0;
        for(int i = 0; i <= list.size()-length; i++){
            int sum = 0;
            for(int j = i; j < i+length; j++){
                sum += list.get(j);
            }
            if(sum == target){
                counter++;
            }
        }
        return counter;
    }

    //return in a List, how many times I find a new min and a new max
    public List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> result = new ArrayList<>();
        int min = scores.get(0);
        int mincounter = 0;
        int max = scores.get(0);
        int maxcounter = 0;
        for(int i : scores){
            if(i < min){
                min = i;
                mincounter++;
            }
            if(i > max){
                max = i;
                maxcounter++;
            }
        }
        result.add(maxcounter);
        result.add(mincounter);
        return result;
    }

}
