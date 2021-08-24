package hackerrank;

import java.util.LinkedList;
import java.util.List;

public class CircularArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> result = new LinkedList<>();
        if(a == null || queries == null || a.isEmpty() || queries.isEmpty()){
            return result;
        }
        int size = a.size();

        for (int i : queries) {    //(k % size) because else the whole amount could get negative
            result.add(a.get(( size + i - (k % size)) % size ));
        }
        return result;
    }

}
