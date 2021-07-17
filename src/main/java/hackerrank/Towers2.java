package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Towers2 {
    List<List<Integer>> towers2;

    public int equalStacks2(List<Integer> a, List<Integer> b, List<Integer> c) {
        if (a == null || b == null || c == null || a.isEmpty() || b.isEmpty() || c.isEmpty()) return 0;
        towers2 = new ArrayList<>();
        towers2.add(new ArrayList<>(a));
        towers2.add(new ArrayList<>(b));
        towers2.add(new ArrayList<>(c));
        return cutter();
    }

    private int cutter() {
        towers2.sort((t1, t2) -> sum(t2) - sum(t1));
        while (sum(towers2.get(0)) != sum(towers2.get(2))) {
            towers2.get(0).remove(0);
            towers2.sort((t1, t2) -> sum(t2) - sum(t1));
        }
        return sum(towers2.get(0));
    }

    private int sum(List<Integer> x) {
        int sum = 0;
        for (int i : x) {
            sum += i;
        }
        return sum;
    }

}
