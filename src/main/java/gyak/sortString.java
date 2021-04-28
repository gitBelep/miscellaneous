package gyak;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class sortString {

    public static void main(String[] args) {
        int n = 10;
        String[]  s = {"9", "-100", "50","0","56.6","90","0.12",".12","02.34","000.000", null, null};
//Ezt rendezd, de maradjanak Stringek. Write your code here:
// 1.)
//        String[] u = new String[s.length-2];
//        System.arraycopy(s,0, u, 0,s.length-2);
//System.out.println(Arrays.toString(u));
//        s = u;
//        String temp = "";
//        for (int j = 0; j < s.length-1; j++) {
//            for (int i = 0; i < s.length -1 - j; i++) {
//                BigDecimal a = new BigDecimal(s[i + 1]);
//                BigDecimal b = new BigDecimal(s[i]);
//                if ( a.compareTo(b) > 0) {
//                    temp = s[i+1]; //kicsitől a nagy felé
//                    s[i+1] = s[i];
//                    s[i] = temp;
//                }
//            }
//        }
// 2.)
    Comparator<String> customComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            BigDecimal a = new BigDecimal(s1);
            BigDecimal b = new BigDecimal(s2);
            return b.compareTo(a); // descending order
        }
    };
    Arrays.sort(s, 0, n, customComparator);

//Output
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] +" ");
        }
    }
}
