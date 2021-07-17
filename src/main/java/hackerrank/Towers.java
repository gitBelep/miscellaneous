package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Towers {
    List<Triple> towers;

    public int equalStacks(List<Integer> a, List<Integer> b, List<Integer> c) {
        if (a == null || b == null || c == null || a.isEmpty() || b.isEmpty() || c.isEmpty()) return 0;
        towers = new ArrayList<>();
        makeTriple(a);
        makeTriple(b);
        makeTriple(c);
        return cutter();
    }

    private int cutter() {
        towers.sort((t1, t2) -> t2.totalHeight - t1.totalHeight);
        while (towers.get(0).totalHeight != towers.get(2).totalHeight) {
            decrease(towers.get(0));
            towers.sort((t1, t2) -> t2.totalHeight - t1.totalHeight);
        }
        return towers.get(0).totalHeight;
    }

    private void makeTriple(List<Integer> x) {
        Triple triple = new Triple();
        triple.elements = new LinkedList<>(x);
        triple.piece = x.size();
        int sum = 0;
        for (int i : x) {
            sum += i;
        }
        triple.totalHeight = sum;
        towers.add(triple);
    }

    private void decrease(Triple t) {
        t.elements.remove(0);
        t.piece = t.piece - 1;
        int sum = 0;
        for (int i : t.elements) {
            sum += i;
        }
        t.totalHeight = sum;
    }


    class Triple {
        int piece;
        int totalHeight;
        List<Integer> elements;

        public int getTotalHeight() {
            return totalHeight;
        }
    }

}
