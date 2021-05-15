package gyak;
//Find in a sorted ARRAY (int) (-; 0; +)
// one pair of Numbers (U can also double elements)
// which gives together the given SUM.
//Linear solution
import java.util.ArrayList;
import java.util.List;

public class SumInSortedArray {

    public List<int[]> findSumInArray(int[] arr, int sum){
        List<int[]> pairs = new ArrayList<>();
        int small = 0;
        int large = arr.length - 1;
        int temp;
        while (small <= large){
            temp = arr[small] + arr[large];
            if(temp == sum){
                pairs.add(new int[]{arr[small], arr[large]});
                break;
            } else if( temp < sum){
                small++;
            } else {
                large--;
            }
        }
        return pairs;
    }

}
