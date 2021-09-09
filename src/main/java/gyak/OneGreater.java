package gyak;

import java.util.ArrayList;
import java.util.List;

public class OneGreater {

    public List<Integer> getOneGreater(int[] arr) {
        List<Integer> ground = changeToList(arr);

        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                int smaller = arr[i - 1];
                List<Integer> right = new ArrayList<>(arr.length - i + 1);
                for (int z = i - 1; z < arr.length; z++) {
                    right.add(arr[z]);
                }
                right.sort(null);
                int nextBiggerNumber = right.remove(right.lastIndexOf(smaller) + 1);
                ground.set(i - 1, nextBiggerNumber);
                int s = 0;
                for ( ; i < arr.length; i++) {
                    ground.set(i, right.get(s));
                    s++;
                }
                break;
            }
        }
//        System.out.println("Result: " + ground);
        return ground;
    }

    private List<Integer> changeToList(int[] a) {
        List<Integer> result = new ArrayList<>(a.length);
        for (int i : a) {
            result.add(i);
        }
        return result;
    }

}
