package DailyCodingProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//myList.size() > 2  !
    public int nonAdjacentMax(List<Integer> myList){
        if(myList.size() == 3){
            return myList.get(0) * myList.get(2);
        }

        Map<Integer, Integer> maxes = new HashMap<>();
        for(int i = 1; i <= 4; i++){
            int actualMax = Integer.MIN_VALUE;
            int maxPlace = -1;
            for(int k = 0; k < myList.size(); k++){
                if(k > actualMax){
                    actualMax = k;

                }

            }
            
        }
    }

}
