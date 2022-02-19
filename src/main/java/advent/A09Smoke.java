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
    private final List<Integer> basinAreas = new ArrayList<>();

    public int findSmoke(Path path, String mode) {
        scanSmoke(path);
        findLowestPoints();
        if ("Find only the deepest points".equals(mode)) {
            return sumLowestPoints();
        } else {
            sumUpBasinsAreas();
            return multipleThe3BiggestBasins();
        }
    }

    private void sumUpBasinsAreas() {
        for (A09BasinPoint lowestPoint : lowestPoints) {
            areaPoints = new LinkedList<>();
            areaPoints.add(lowestPoint);
            summing(lowestPoint);
            basinAreas.add(areaPoints.get(0).getBasinParts());
        }
        System.out.println("basinAreas: " + basinAreas);
    }

    private void summing(A09BasinPoint point) {
        int c = point.getC();
        int r = point.getR();
        int rowLength = sMap.get(0).length;
        int fileLength = sMap.size();

        List<int[]> possiblePoints = List.of(
                new int[]{Math.max(r - 1, 0), c},
                new int[]{Math.min(r + 1, fileLength - 1), c},
                new int[]{r, Math.max(c - 1, 0)},
                new int[]{r, Math.min(c + 1, rowLength - 1)});
        //possiblePoints.stream().forEach(arr -> System.out.print(Arrays.toString(arr) +" "));

        for (int[] i : possiblePoints) {
            int y = i[0];
            int x = i[1];
            int value = sMap.get(y)[x];
            if (value != 9 && !areaPoints.contains(new A09BasinPoint(y, x, value))) {
                areaPoints.add(new A09BasinPoint(y, x, value));
                areaPoints.get(0).addBasinPart();
                summing(new A09BasinPoint(y, x, value));        //recursive
            }
        }
    }

    private int multipleThe3BiggestBasins() {
        basinAreas.sort(Comparator.reverseOrder());
        return basinAreas.stream()
                .limit(3)
                .reduce(1, (multipl, in) -> multipl * in);
    }

    private void findLowestPoints() {
        int rowLength = sMap.get(0).length;
        int fileLength = sMap.size();

        for (int r = 0; r < fileLength; r++) {
            for (int c = 0; c < rowLength; c++) {
                int actual = sMap.get(r)[c];
                if (       (c == rowLength - 1 || actual < sMap.get(r)[c + 1] )
                        && (c == 0 || actual < sMap.get(r)[c - 1] )
                      //&& (actual < sMap.get(r)[Math.max(0, c - 1)] || c == 0 )        //if c==0,then skip this row :-)
                        && (r == fileLength - 1 || actual < sMap.get(r + 1)[c] )
                        && (r == 0 || actual < sMap.get(r - 1)[c] )
                ){
                    lowestPoints.add(new A09BasinPoint(r, c, actual));
                }
            }
        }
    }

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
//These caves seem to be lava tubes. Parts are even still volcanically active; small hydrothermal vents release smoke
// into the caves that slowly settles like rain.
//If you can model how the smoke flows through the caves, you might be able to avoid it and be that much safer. The
// submarine generates a heightmap of the floor of the nearby caves for you (your puzzle input).
//Smoke flows to the lowest point of the area it's in. For example, consider the following heightmap:
//2199943210
//3987894921
//9856789892
//8767896789
//9899965678
//Each number corresponds to the height of a particular location, where 9 is the highest and 0 is the lowest a location can be.
//Your first goal is to find the low points - the locations that are lower than any of its adjacent locations. Most
// locations have four adjacent locations (up, down, left, and right); locations on the edge or corner of the map have
// three or two adjacent locations, respectively. (Diagonal locations do not count as adjacent.)
//In the above example, there are four low points, all highlighted: two are in the first row (a 1 and a 0), one is in
// the third row (a 5), and one is in the bottom row (also a 5). All other locations on the heightmap have some lower
// adjacent location, and so are not low points.
//The risk level of a low point is 1 plus its height. In the above example, the risk levels of the low points
// are 2, 1, 6, and 6. The sum of the risk levels of all low points in the heightmap is therefore 15.
//Find all of the low points on your heightmap. What is the sum of the risk levels of all low points on your heightmap?
//Your puzzle answer was 575.
//--- Part Two ---
//Next, you need to find the largest basins so you know what areas are most important to avoid.
//A basin is all locations that eventually flow downward to a single low point. Therefore, every low point has a basin,
// although some basins are very small. Locations of height 9 do not count as being in any basin, and all other locations
// will always be part of exactly one basin.
//The size of a basin is the number of locations within the basin, including the low point. The example above has four basins.
//The top-left basin, size 3:
//2199943210
//3987894921
//9856789892
//8767896789
//9899965678
//The top-right basin, size 9:
//2199943210
//3987894921
//9856789892
//8767896789
//9899965678
//The middle basin, size 14:
//2199943210
//3987894921
//9856789892
//8767896789
//9899965678
//The bottom-right basin, size 9:
//2199943210
//3987894921
//9856789892
//8767896789
//9899965678
//Find the three largest basins and multiply their sizes together. In the above example, this is 9 * 14 * 9 = 1134.
//What do you get if you multiply together the sizes of the three largest basins?
