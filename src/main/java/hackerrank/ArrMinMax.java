package hackerrank;

import java.util.List;

public class ArrMinMax {

    public static int maxMin(int k, List<Integer> arr) {
        arr.sort(null);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (arr.size() - k + 1); i++) {
            if (arr.get(i + k - 1) - arr.get(i) < min) {
                min = arr.get(i + k - 1) - arr.get(i);
            }
            //System.out.println(i + " " + arr.get(i + k - 1) + " " + arr.get(i) + " " + min);
        }
        return min;
    }

}
