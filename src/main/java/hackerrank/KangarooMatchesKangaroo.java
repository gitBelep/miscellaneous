package hackerrank;

public class KangarooMatchesKangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) {
            return "YES";
        }
        if ((x1 < x2 && v1 < v2) || (x1 > x2 && v1 > v2) || x1 != x2 && v1 == v2) {
            return "NO";
        }
        int before = Integer.MAX_VALUE;
        while (Math.abs(x1 - x2) < before) {
            before = Math.abs(x1 - x2);
            System.out.println(before);
            x1 += v1;
            x2 += v2;
            if (x1 == x2) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] argh) {
        System.out.println(kangaroo(0, 3, 4, 2));
    }

}
