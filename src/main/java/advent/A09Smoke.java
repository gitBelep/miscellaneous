package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class A09Smoke {
    private final List<int[]> sMap = new LinkedList<>();
    private final List<A09BasinPoint> lowestPoints = new LinkedList<>();
    private List<A09BasinPoint> areaPoints;
    private List<Integer> basinAreas = new ArrayList<>();

    public int findSmoke(Path path, String mode) {
        scanSmoke(path);
        findBasins();
        if ("Find only the deepest points".equals(mode)) {
            return sumLowestPoints();
        } else {
            sumUpBasinsAreas();
            return findThe3BiggestBasins();
        }
    }

    private void sumUpBasinsAreas() {
        for (A09BasinPoint lowestPoint : lowestPoints) {
            areaPoints = new LinkedList<>();
            areaPoints.add(lowestPoint);
            summing(lowestPoint);
            basinAreas.add(areaPoints.get(0).getBasinParts());
            //System.out.println("pts: "+ areaPoints.get(0).getBasinParts());
        }
        System.out.println("basinAreas: " + basinAreas);
    }

    private void summing(A09BasinPoint point) {
        int c = point.getC();
        int r = point.getR();
       // System.out.print("r,c~"+ r +" "+ c +": ");
        int rowLength = sMap.get(0).length;
        int fileLength = sMap.size();

        List<int[]> possiblePoints = List.of(
                new int[]{Math.max(r - 1, 0), c},
                new int[]{Math.min(r + 1, fileLength - 1), c},
                new int[]{r, Math.max(c - 1, 0)},
                new int[]{r, Math.min(c + 1, rowLength - 1)}
        );
//        System.out.println("\npossible points list: ");
//        possiblePoints.stream().forEach(arr -> System.out.print(Arrays.toString(arr) +" "));
        for (int[] i : possiblePoints) {
            int y = i[0];
            int x = i[1];
            //System.out.println("yx"+ y +" "+ x);
            int value = sMap.get(y)[x];
            if (value != 9 && !areaPoints.contains(new A09BasinPoint(y, x, value))) {
                areaPoints.add(new A09BasinPoint(y, x, value));
               // System.out.println("\nmErre hívom meg"+ new A09BasinPoint(y, x, value));
                summing(new A09BasinPoint(y, x, value));        //recursive
            }
            areaPoints.get(0).addBasinPart();
        }
        possiblePoints = null;
    }

    private int findThe3BiggestBasins() {
        basinAreas.sort(Comparator.reverseOrder());
        return basinAreas.stream()
                .limit(3)
                .peek(System.out::println)
                .reduce(1, (multipl, in) -> multipl * in);
    }

    private void findBasins() {
        int rowLength = sMap.get(0).length;
        int fileLength = sMap.size();

        for (int r = 0; r < fileLength; r++) {
            for (int c = 0; c < rowLength; c++) {
                int actual = sMap.get(r)[c];
                if (r == 0) {                         //FIRST ROW
                    if (c == 0) {                     //1. column
                        if (actual < sMap.get(0)[1]
                                && actual < sMap.get(1)[0]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    } else if (c == rowLength - 1) { //last column
                        if (actual < sMap.get(0)[c - 1]
                                && actual < sMap.get(1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    } else {                        //inbetween
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r + 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    }
                } else if (r == fileLength - 1) {       //LAST ROW
                    if (c == 0) {                     //1. column
                        if (actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    } else if (c == rowLength - 1) { //last column
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    } else {                        //inbetween
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    }
                } else {                                //ROWs INBETWEEN
                    if (c == 0) {                     //1. column
                        if (actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]
                                && actual < sMap.get(r + 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    } else if (c == rowLength - 1) { //last column
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r + 1)[c]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    } else {                        //inbetween
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]
                                && actual < sMap.get(r + 1)[c]) {
                            lowestPoints.add(new A09BasinPoint(r, c, actual));
                        }
                    }
                }
            }
        }
    }

//    private void sumUpBasinsAreas() {
//        int rowLength = sMap.get(0).length;
//        int fileLength = sMap.size();
//
//        for (A09BasinPoint lowestPoint : lowestPoints) {
//            int r = lowestPoint.getR();
//            int c = lowestPoint.getC();
//            int counter = 0;
//
//            for (int i = r; i < fileLength; i++) {
//                if (sMap.get(i)[c] < 9) {
//                    counter++;
//                } else {
//                    break;
//                }
//            }
//            for (int i = r; i >= 0; i--) {
//                if (sMap.get(i)[c] < 9) {
//                    counter++;
//                } else {
//                    break;
//                }
//            }
//            for (int i = c; i < rowLength; i++) {
//                if (sMap.get(r)[i] < 9) {
//                    counter++;
//                } else {
//                    break;
//                }
//            }
//            for (int i = c; i >= 0; i--) {
//                if (sMap.get(r)[i] < 9) {
//                    counter++;
//                } else {
//                    break;
//                }
//            }
//            lowestPoint.addBasinParts(counter);
//            System.out.println(lowestPoint);
//        }
//    }

    private int sumLowestPoints() {
        return lowestPoints.stream()
                .map(A09BasinPoint::getValue)
                .map(e -> e + 1)
                .reduce(0, Integer::sum);
    }

    private void scanSmoke(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            char[] arr;
            int[] row;

            while ((line = br.readLine()) != null) {
                row = new int[line.length()];
                arr = line.toCharArray();
                for (int i = 0; i < line.length(); i++) {
                    row[i] = Integer.parseInt(String.valueOf(arr[i]));
                }
                sMap.add(row);
            }
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
    }

}
