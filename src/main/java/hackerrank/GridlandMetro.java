package hackerrank;

import java.io.*;
import java.util.*;

public class GridlandMetro {

//Filtering. Remélem,nincs olyan, h egy sorban két különálló vonal van
    //Test OK: 0~4
    static int gridlandMetro1(int n, int m, int k, int[][] track) {
        if(k == 0){
            return n * m;
        }
        List<List<Integer>> free = new ArrayList<>();
        if(k > 1) {
            free.add(new ArrayList<>(Arrays.asList(track[0][0], track[0][1], track[0][2])));
            for (int sor = 1; sor < k; sor++) {
                int key = track[sor][0];
                int e = track[sor][1];
                int u = track[sor][2];

                for (int i = 0; i < free.size(); i++) {
                    if (free.get(i).get(0) == key) {
                        if (free.get(i).get(1) > e) {
                            free.get(i).set(1, e);
                        }
                        if (free.get(i).get(2) < u) {
                            free.get(i).set(2, u);
                        }
                        break;
                    }
                    if (i == free.size() - 1) {
                        free.add(new ArrayList<>(Arrays.asList(key, e, u)));
                    }
                    System.out.println(free.toString());
                }
            }
        }
        System.out.println(free.toString());
        int sum = 0;
        for (List<Integer> l : free){
            sum += l.get(1) - 1 + ( m - l.get(2));
        }
        sum += (n - free.size()) * m;
        System.out.println("szabad: "+ sum);
        return sum;
    }

//Lassú
    //Test OK: 0~5
    static int gridlandMetro2(int n, int m, int k, int[][] track) {
        int[][] orszag = new int[n][m];
        System.out.println(Arrays.deepToString(orszag));
        for (int i = 0; i < k; i++){
            int sor = track[i][0]-1;
            int e = track[i][1];
            int u = track[i][2];
            for (int x = e-1; x<u;x++){
                orszag[sor][x]=1;
            }
        }
        String egesz = Arrays.deepToString(orszag);
        System.out.println(egesz);
        char[] cc = egesz.toCharArray();
        int counter = 0;
        for(char c : cc){
            if (c == '0'){
                counter++;
            }
        }
        System.out.println("szabad: "+ counter);
        return counter;
    }

    public static void main(String[] args) throws IOException {
        int n = 4;
        int m = 4;
        int k = 4;
        int[][] track = {{2, 2, 3}, {3, 1, 4}, {1, 4, 4}, {2,3,4}};
        int result1 = gridlandMetro1(n, m, k, track);
        int result2 = gridlandMetro2(n, m, k, track);
    }

}
