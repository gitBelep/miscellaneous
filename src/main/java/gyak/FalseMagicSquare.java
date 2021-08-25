//Income: 3x3 number in a List<List<Integer>>.
//Make a FalseMagicSquare (sum of all numbers in all rows & all columns is the same).
//We can convert any digit A to any other digit B at cost of Math.abs(A-B).
//Return the minimal total cost of converting the input square into a FalseMagicSquare.
package gyak;

import java.util.*;

public class FalseMagicSquare {

    public static int formingMagicSquare(List<List<Integer>> income) {
        List<List<Integer>> in = new ArrayList<>(income);
        int r1;
        int r2;
        int r3;
        int c1;
        int c2;
        int c3;
        int cMin;
        int rMin;
        int rMiddle;
        int rMax;
        int cMax;
        int counter = 0;

        do {
            r1 = in.get(0).get(0) + in.get(0).get(1) + in.get(0).get(2);
            r2 = in.get(1).get(0) + in.get(1).get(1) + in.get(1).get(2);
            r3 = in.get(2).get(0) + in.get(2).get(1) + in.get(2).get(2);
            System.out.println(in);                                      //+
            System.out.println("R: " + r1 + " " + r2 + " " + r3);        //+
            List<Integer> rows = new ArrayList<>();
            rows.add(r1);
            rows.add(r2);
            rows.add(r3);
            rows.sort(null);
            rMin = rows.get(0);
            rMiddle = rows.get(1);
            rMax = rows.get(2);

            c1 = in.get(0).get(0) + in.get(1).get(0) + in.get(2).get(0);
            c2 = in.get(0).get(1) + in.get(1).get(1) + in.get(2).get(1);
            c3 = in.get(0).get(2) + in.get(1).get(2) + in.get(2).get(2);
            System.out.println("C: " + c1 + " " + c2 + " " + c3);        //+
            List<Integer> columns = new ArrayList<>();
            columns.add(c1);
            columns.add(c2);
            columns.add(c3);
            columns.sort(null);
            cMin = columns.get(0);
            cMax = columns.get(2);

            if (rMin != rMiddle) {
                if (rMin == r1 && cMin == c1) {
                    in.get(0).set(0, in.get(0).get(0) + 1);
                    counter++;
                }
                if (rMin == r1 && cMin == c2) {
                    in.get(0).set(1, in.get(0).get(1) + 1);
                    counter++;
                }
                if (rMin == r1 && cMin == c3) {
                    in.get(0).set(2, in.get(0).get(2) + 1);
                    counter++;
                }

                if (rMin == r2 && cMin == c1) {
                    in.get(1).set(0, in.get(1).get(0) + 1);
                    counter++;
                }
                if (rMin == r2 && cMin == c2) {
                    in.get(1).set(1, in.get(1).get(1) + 1);
                    counter++;
                }
                if (rMin == r2 && cMin == c3) {
                    in.get(1).set(2, in.get(1).get(2) + 1);
                    counter++;
                }

                if (rMin == r3 && cMin == c1) {
                    in.get(2).set(0, in.get(2).get(0) + 1);
                    counter++;
                }
                if (rMin == r3 && cMin == c2) {
                    in.get(2).set(1, in.get(2).get(1) + 1);
                    counter++;
                }
                if (rMin == r3 && cMin == c3) {
                    in.get(2).set(2, in.get(2).get(2) + 1);
                    counter++;
                }
            }

            if (rMax != rMiddle) {
                if (rMax == r1 && cMax == c1) {
                    in.get(0).set(0, in.get(0).get(0) - 1);
                    counter++;
                }
                if (rMax == r1 && cMax == c2) {
                    in.get(0).set(1, in.get(0).get(1) - 1);
                    counter++;
                }
                if (rMax == r1 && cMax == c3) {
                    in.get(0).set(2, in.get(0).get(2) - 1);
                    counter++;
                }

                if (rMax == r2 && cMax == c1) {
                    in.get(1).set(0, in.get(1).get(0) - 1);
                    counter++;
                }
                if (rMax == r2 && cMax == c2) {
                    in.get(1).set(1, in.get(1).get(1) - 1);
                    counter++;
                }
                if (rMax == r2 && cMax == c3) {
                    in.get(1).set(2, in.get(1).get(2) - 1);
                    counter++;
                }

                if (rMax == r3 && cMax == c1) {
                    in.get(2).set(0, in.get(2).get(0) - 1);
                    counter++;
                }
                if (rMax == r3 && cMax == c2) {
                    in.get(2).set(1, in.get(2).get(1) - 1);
                    counter++;
                }
                if (rMax == r3 && cMax == c3) {
                    in.get(2).set(2, in.get(2).get(2) - 1);
                    counter++;
                }
            }
        } while (rMin != rMax && cMax != cMin);
        System.out.println("The END!  counter: " + counter);  //+
        return counter;
    }

}
