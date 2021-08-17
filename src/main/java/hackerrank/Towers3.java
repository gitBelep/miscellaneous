package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Towers3 {

    public int equalStacks(List<Integer> a, List<Integer> b, List<Integer> c) {
        if (a == null || b == null || c == null || a.size() == 0 || b.size() == 0 || c.size() == 0) return 0;
        List<Integer> aHeights = new ArrayList<>(a.size());
        List<Integer> bHeights = new ArrayList<>(b.size());
        List<Integer> cHeights = new ArrayList<>(c.size());
        aHeights = sumHeights(a, aHeights);
        bHeights = sumHeights(b, bHeights);
        cHeights = sumHeights(c, cHeights);
        aHeights.retainAll(bHeights);
        aHeights.retainAll(cHeights);
        if (aHeights.size() == 0) {
            return 0;
        }
        return aHeights.get(aHeights.size() - 1);
    }

    private List<Integer> sumHeights(List<Integer> x, List<Integer> heights) {
        Integer before = 0;
        for (Integer i = x.size() - 1; i > -1; i--) {
            heights.add(before + x.get(i));
            before += x.get(i);
        }
        return heights;
    }

}
