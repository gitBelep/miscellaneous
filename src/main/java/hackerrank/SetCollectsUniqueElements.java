package hackerrank;

import java.util.*;

public class SetCollectsUniqueElements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//        Set<String[]> pairs = new HashSet<>();
//        for (int i = 0; i < t; i++){
//            pairs.add( new String[] {pair_left[i], pair_right[i]} );
//            System.out.println(pairs.size());
//            System.out.println(Arrays.deepToString(pairs.toArray()));
//Set beengedett egyforma Arrayeket:   o-:=
// [[j, t], [m, a], [m, a], [j, t], [j, m]]

        Set<List<String>> pairs = new HashSet<>();
        for (int i = 0; i < t; i++) {
            pairs.add(new ArrayList<>(Arrays.asList(pair_left[i], pair_right[i])));
            System.out.println(pairs.size());
            System.out.println(Arrays.deepToString(pairs.toArray()));
        }
    }

}
