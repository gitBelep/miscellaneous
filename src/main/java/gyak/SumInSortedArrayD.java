package gyak;
//Find in a sorted ARRAY (int) (-; 0; +)
// all pairs of Numbers (U can also double elements)
// which gives together the given SUM.
//Quadratic solution

import java.util.*;

public class SumInSortedArrayD {
    Map<Integer, Integer> pairs;

    public Map<Integer, Integer> findSumInArray(int[] arr, int sum) {
        pairs = new TreeMap<>();

        if(thereIsNothingToDo(arr) || sumIsNotReachable(arr, sum)){
            return pairs;
        }

        List<Integer> whole = getRidOfSameNumbers(arr);

        doublingAllowed(whole, sum);

        if(sum < whole.get(0)){
            searchNegatives(whole, sum);
        } else if(whole.get(whole.size() - 1) < sum){
            searchPositives(whole, sum);
        } else {
            fullSearch(whole, sum);
        }

        return pairs;
    }

    private void fullSearch(List<Integer> whole, int sum) {
        int last = whole.size() - 1;
        for (int i = 0; i <= last && whole.get(i) <= sum; i++) {
            for (int k = last; i < k && sum <= whole.get(i) + whole.get(k); k--) {
                if (whole.get(i) + whole.get(k) == sum) {
                    pairs.put(whole.get(i), whole.get(k));
                    break;
                }
            }
        }
    }

    private void searchNegatives(List<Integer> whole, int sum) {
        List<Integer> negatives = new ArrayList<>();
        for(Integer i : whole){
            if(i < 0) {
                negatives.add(i);
            }
        }
        int last = negatives.size() - 1;
        for (int i = 0; i <= last; i++) {
            for (int k = last; i < k; k--) {
                if (negatives.get(i) + negatives.get(k) == sum) {
                    pairs.put(negatives.get(i), negatives.get(k));
                    break;
                }
            }
        }
    }

    private void searchPositives(List<Integer> whole, int sum) {
        List<Integer> positives = new ArrayList<>();
        for(Integer i : whole){
            if (0 < i) {
                positives.add(i);
            }
        }
        int last = positives.size() - 1;
        for (int i = 0; i <= last; i++) {
            for (int k = last; i < k; k--) {
                if (positives.get(i) + positives.get(k) == sum) {
                    pairs.put(positives.get(i), positives.get(k));
                    break;
                }
            }
        }
    }

    private boolean thereIsNothingToDo(int[] arr){
        return arr == null || arr.length == 0;
    }

    private boolean sumIsNotReachable(int[] arr, int sum){
        int last = arr.length - 1;
        return ((arr[last] < sum && (arr[last] <= 0 || arr[last] * 2 < sum))
                || (sum < arr[0] && (0 <= arr[0] || sum < arr[0] * 2)));
    }

    private List<Integer> getRidOfSameNumbers(int[] arr) {
        Set<Integer> sett = new TreeSet<>();
        for (int u : arr) {
            sett.add(u);
        }
        return new ArrayList<>(sett);
    }

    private void doublingAllowed(List<Integer> whole, int sum) {
        if (sum % 2 == 0 && whole.contains(sum / 2)) {
            pairs.put(sum / 2, sum / 2);
        }
    }

}
