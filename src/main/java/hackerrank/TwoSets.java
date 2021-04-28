package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TwoSets {
//Add meg azokat a számokat, amik az Első Listben mindnek többszörösei,
//és a Második Listben minden számnak osztói (Test 4,7 nem fut le)

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(2,6,3));
        System.out.println(a.toString());
        List<Integer> b = new ArrayList<>(List.of(24,36,24,96));
        System.out.println(b.toString());

        System.out.println(getTotalXNemJo(a,b) +" db");
        System.out.println(getTotalXJo(a,b) +" db");
    }

    public static int getTotalXJo(List<Integer> a, List<Integer> b) {
        int f = lcm(a);
        int l = gcd(b);
        int count = 0;
        for(int i = f, j =2; i<=l; i=f*j,j++){
            if(l%i==0){ count++;}
        }
        return count;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int gcd(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = gcd(result, input.get(i));
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = lcm(result, input.get(i));
        }
        return result;
    }


    public static int getTotalXNemJo(List<Integer> a, List<Integer> b) {
        int min = Integer.MAX_VALUE;
        for (int i : b){
            if(i < min){
                min = i;
            }
        }

        List<Integer> commonDividers = new ArrayList<>();
        for (int e = 2; e <= min; e++){
            int i = 0;
            for (i = 0; i < b.size(); i++){
                if (b.get(i) % e != 0){
                    break;
                }
            }
            if( i == b.size()) {
                commonDividers.add(e);
            }
        }
        System.out.println("Közös osztók: "+ commonDividers.toString());
        List<Integer> result = new ArrayList<>();
        for(int c : commonDividers) {
            int i = 0;
            for (i = 0; i < a.size(); i++) {
                if (c % a.get(i) != 0){
                    break;
                }
            }
            if (i == a.size()){
                result.add(c);
                System.out.println("Többszörös: "+ c);
            }
        }
        return result.size();
    }

}
