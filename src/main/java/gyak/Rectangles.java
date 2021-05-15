package gyak;

import java.util.*;

public class Rectangles {
    List<int[]> pairs = new ArrayList<>();

    public int countRectangles(List<int[]> arrs) {
        Collections.sort(arrs, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o2[0] < o1[0]) {
                return 1;
            }
            return Integer.compare(o1[1], o2[1]);
        });

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int[] i : arrs) {
            xs.add(i[0]);
            ys.add(i[1]);
            pairs.add(i);
        }
        System.out.println(xs.toString());
        System.out.println(ys.toString());

        int max = xs.size();
        int rectCounter = 0;

        for (int i = 0; i < max; i++) {
            int x1 = xs.get(i);
            int y1 = ys.get(i);
            int x1i2;
            int prevX1i2 = i;
            while ((x1i2 = xs.subList(prevX1i2 + 1, max).indexOf(x1)) > -1) {
                int y2 = ys.get(x1i2 + prevX1i2 + 1);
                int y2i2;
                int prevY2i2 = x1i2 + prevX1i2 + 1;
                prevX1i2 = x1i2 + prevX1i2 + 1;
                while ((y2i2 = ys.subList(prevY2i2 + 1, max).indexOf(y2)) > -1) {
                    int x2 = xs.get(y2i2 + prevY2i2 + 1);
                    int[] fourth = new int[]{x2, y1};
                    if (pairsContainsFourthPoint(fourth)) {
                        System.out.println("X1,Y1(" + x1 + ", " + y1 + ")  X2,Y2(" + x2 + ", " + y2 + ")");
                        rectCounter++;
                    }
                    prevY2i2 = y2i2 + prevY2i2 + 1;
                }
            }
        }
        return rectCounter;
    }

    public boolean pairsContainsFourthPoint(int[] f) {
        for (int[] arr : pairs) {
            if (f[0] == arr[0] && f[1] == arr[1]) {
                return true;
            }
        }
        return false;
    }

}
