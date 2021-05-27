package hackerrank;

import java.io.*;
import java.util.*;

@FunctionalInterface //függvény interfész
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    //call one of MyMath's methods
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation a(){
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                return false;
            }
        };
    }

    public PerformOperation isOdd() {
        return a -> a % 2 == 0;
    }

    public PerformOperation isPrime() {
        return a -> {
            for (int i = 2; i <= a / 2; i++) {
                if (a % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            char[] ach = Integer.toString(a).toCharArray();
            for (int i = 0; i < ach.length / 2; i++) {
                if (ach[i] != ach[ach.length - i - 1]) {
                    return false;
                }
            }
            return true;
        };
    }
}

public class LambdaExpr {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }

}
