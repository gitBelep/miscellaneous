package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class A09Smoke {
    private List<int[]> sMap = new LinkedList<>();
    private List<Integer> lowestPoints = new LinkedList<>();

    public int findSmoke(Path path) {
        scanSmoke(path);
        findBasins();
        return sumLowestPoints();
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
                            lowestPoints.add(actual);
                        }
                    } else if (c == rowLength - 1) { //last column
                        if (actual < sMap.get(0)[c - 1]
                                && actual < sMap.get(1)[c]) {
                            lowestPoints.add(actual);
                        }
                    } else {                        //inbetween
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r + 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    }
                } else if (r == fileLength - 1) {       //LAST ROW
                    if (c == 0) {                     //1. column
                        if (actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    } else if (c == rowLength - 1) { //last column
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    } else {                        //inbetween
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    }
                } else {                                //ROWs INBETWEEN
                    if (c == 0) {                     //1. column
                        if (actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]
                                && actual < sMap.get(r + 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    } else if (c == rowLength - 1) { //last column
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r + 1)[c]
                                && actual < sMap.get(r - 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    } else {                        //inbetween
                        if (actual < sMap.get(r)[c - 1]
                                && actual < sMap.get(r)[c + 1]
                                && actual < sMap.get(r - 1)[c]
                                && actual < sMap.get(r + 1)[c]) {
                            lowestPoints.add(actual);
                        }
                    }
                }
            }
        }
    }

    private int sumLowestPoints() {
        return lowestPoints.stream()
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
