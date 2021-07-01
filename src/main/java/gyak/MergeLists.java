package gyak;
//Given two lists of integers a and b sorted in ascending order, merge them into one large sorted list.
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeLists {
    List<Integer> merged;

    public List<Integer> mergeLists(List<Integer> a, List<Integer> b) {
        int al = a.size();
        int bl = b.size();
        int k = 0;
        int i = 0;
        merged = new ArrayList<>();

        while (true) {
            if (a.get(i) < b.get(k)) {
                merged.add(a.get(i));
                if (i < al - 1) {
                    i++;
                } else {
                    fillRest(k, b);
                    break;
                }
            }
            if (b.get(k) <= a.get(i)) {
                merged.add(b.get(k));
                if (k < bl - 1) {
                    k++;
                } else {
                    fillRest(i, a);
                    break;
                }
            }
        }
        return merged;
    }

    private void fillRest(int x, List<Integer> z) {
        for (; x < z.size(); x++) {
            merged.add(z.get(x));
        }
    }

    public List<Integer> mergeListsWithStream(List<Integer> a, List<Integer> b) {
        Stream<Integer> both = Stream.concat(a.stream(), b.stream());
        return both
                .sorted()
                .collect(Collectors.toList());
    }

}
