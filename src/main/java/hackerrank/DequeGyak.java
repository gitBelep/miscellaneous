package hackerrank;

import java.util.*;
import java.util.Scanner;

public class DequeGyak {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        List<Integer> l = new ArrayList<>(n);
//        int max = 0;
//        int m = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//            l.add(num);
//        }
//        for (int i = 0; i < n - m + 1; i++) {
//            Set<Integer> set = new HashSet<>(m);
//            for (int k = i; k < i + m; k++) {
//                set.add(l.get(k));
//            }
//            if (set.size() > max) {
//                max = set.size();
//            }
//        }
//        System.out.println(max);
//    }
// vagy Deque-t és Setet végigcsúsztatni
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            deque.add(input);
            set.add(input);
            if (deque.size() == m) {
                if (set.size() > max) {
                    max = set.size();
                }
                int first = deque.remove();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        System.out.print(max);
    }
}
