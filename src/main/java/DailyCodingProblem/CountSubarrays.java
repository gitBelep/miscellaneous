package DailyCodingProblem;

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

}
