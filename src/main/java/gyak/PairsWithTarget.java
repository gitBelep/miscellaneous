package gyak;
//2 Arrays, same length, with integers, and a target number.
// return the best pair (one int from both arrays) whose sum is nearest to the target.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithTarget {

    public List<Integer> reachTheTarget(int[] a, int[] b, int target){
        List<Integer> bestPair = new ArrayList<>();
        int sum;
        int i = 0;
        int k = b.length - 1;
        int missing = Integer.MAX_VALUE;

        Arrays.sort(a);
        Arrays.sort(b);
        while(i < a.length && k >= 0){
            sum = a[i] + b[k];
            if( Math.abs(target - sum) < missing){
                missing = Math.abs( target - sum );
                bestPair = List.of(a[i], b[k]);
                System.out.println(bestPair.toString());
            }
            if(sum == target){
                return bestPair;
            }
            if (target < sum){
                k = k-1;
            }
            if(sum < target){
                i = i+1;
            }
        }
        return bestPair;
    }

}
