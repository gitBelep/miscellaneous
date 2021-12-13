package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class A05Thermal {
    private Map<A05Coordinate, Integer> coordinates = new HashMap<>();
    private int counterOfNonValidCoo = 0;
    int countCoordinates = 0;

    public static void main(String[] args) {
        var t = new A05Thermal();
        t.readFile();
    }

    private void readFile(){
        Path path = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "Thermal.txt");
        Path pTest = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "Thermal-test.txt");
        try(BufferedReader br = Files.newBufferedReader(path)) {
            readCoordinates(br);
            countCoordinatesWithMoreThanOneOverlapping();
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
    }

    private void readCoordinates(BufferedReader br) throws IOException{
        String line;
        while((line = br.readLine()) != null){
            String[] coo = line.trim().split(" -> ");  //2 coordinate
            String[] coo1Str = coo[0].split(",");
            var coo1 = new A05Coordinate(Integer.parseInt(coo1Str[0]), Integer.parseInt(coo1Str[1]));
            String[] coo2Str = coo[1].split(",");
            var coo2 = new A05Coordinate(Integer.parseInt(coo2Str[0]), Integer.parseInt(coo2Str[1]));

            fillCoordinates(coo1, coo2);
        }
    }

    private void fillCoordinates(A05Coordinate coo1, A05Coordinate coo2){
        if(coo1.getX() == coo2.getX()){
            int x = coo1.getX();
            int yS = Math.min(coo1.getY(), coo2.getY());
            int yL = Math.max(coo1.getY(), coo2.getY());
            for(int i = yS; i <= yL; i++){
                var c = new A05Coordinate(x, i);
                if( !coordinates.containsKey(c) ){
                    coordinates.put(c, 0);
                }
                coordinates.put(c, coordinates.get(c) + 1);
            }
        }
        else if(coo1.getY() == coo2.getY()) {
            int y = coo1.getY();
            int xS = Math.min(coo1.getX(), coo2.getX());
            int xL = Math.max(coo1.getX(), coo2.getX());
            for (int i = xS; i <= xL; i++) {
                var c = new A05Coordinate(i, y);
                if ( !coordinates.containsKey(c) ){
                    coordinates.put(c, 0);
                }
                coordinates.put(c, coordinates.get(c) + 1);
            }
        }
        else {
            counterOfNonValidCoo++;
        }
    }

    private void countCoordinatesWithMoreThanOneOverlapping(){
        int counter = 0;
        for(Map.Entry<A05Coordinate,Integer> e : coordinates.entrySet()){
            if(e.getValue() >= 2){
                counter++;
            }
        }

        int c2 = 0;
        int c3 = 0;
        for(int u : coordinates.values()){
            if(u ==2) c2++;
            if(u == 3) c3++;
        }
        System.out.println("2es: "+ c2 +"; 3-as: "+ c3);
        //System.out.println(coordinates.toString());
        System.out.println("Counter of non valid lines: "+ counterOfNonValidCoo
                +"\nMin 2 overlapping: "+ counter);
        System.out.println("Size of coordinates: "+ coordinates.size());

    }

}
//--- Day 5: Hydrothermal Venture ---
//You come across a field of hydrothermal vents on the ocean floor! These vents constantly produce large, opaque clouds,
// so it would be best to avoid them if possible.
//They tend to form in lines; the submarine helpfully produces a list of nearby lines of vents (your puzzle input) for
// you to review. For example:
//0,9 -> 5,9
//8,0 -> 0,8
//9,4 -> 3,4
//2,2 -> 2,1
//7,0 -> 7,4
//6,4 -> 2,0
//0,9 -> 2,9
//3,4 -> 1,4
//0,0 -> 8,8
//5,5 -> 8,2
//Each line of vents is given as a line segment in the format x1,y1 -> x2,y2 where x1,y1 are the coordinates of one end
// the line segment and x2,y2 are the coordinates of the other end. These line segments include the points at both ends. In other words:
//An entry like 1,1 -> 1,3 covers points 1,1, 1,2, and 1,3.
//An entry like 9,7 -> 7,7 covers points 9,7, 8,7, and 7,7.
//For now, only consider horizontal and vertical lines: lines where either x1 = x2 or y1 = y2.
//So, the horizontal and vertical lines from the above list would produce the following diagram:
//.......1..
//..1....1..
//..1....1..
//.......1..
//.112111211
//..........
//..........
//..........
//..........
//222111....
//In this diagram, the top left corner is 0,0 and the bottom right corner is 9,9. Each position is shown as the number of
// lines which cover that point or . if no line covers that point. The top-left pair of 1s, for example, comes from 2,2 -> 2,1;
// the very bottom row is formed by the overlapping lines 0,9 -> 5,9 and 0,9 -> 2,9.
//
//To avoid the most dangerous areas, you need to determine the number of points where at least two lines overlap. In the
// above example, this is anywhere in the diagram with a 2 or larger - a total of 5 points.
//
//Consider only horizontal and vertical lines. At how many points do at least two lines overlap?
//
//Your puzzle answer was 8622.
//
//The first half of this puzzle is complete! It provides one gold star: *
//
//--- Part Two ---
//Unfortunately, considering only horizontal and vertical lines doesn't give you the full picture; you need to also
// consider diagonal lines.
//
//Because of the limits of the hydrothermal vent mapping system, the lines in your list will only ever be horizontal,
// vertical, or a diagonal line at exactly 45 degrees. In other words:
//
//An entry like 1,1 -> 3,3 covers points 1,1, 2,2, and 3,3.
//An entry like 9,7 -> 7,9 covers points 9,7, 8,8, and 7,9.
//Considering all lines from the above example would now produce the following diagram:
//
//1.1....11.
//.111...2..
//..2.1.111.
//...1.2.2..
//.112313211
//...1.2....
//..1...1...
//.1.....1..
//1.......1.
//222111....
//You still need to determine the number of points where at least two lines overlap. In the above example, this is still
// anywhere in the diagram with a 2 or larger - now a total of 12 points.
//Consider all of the lines. At how many points do at least two lines overlap?
//____________
//2es: 8075; 3-as: 529 //Counter of non valid lines: 171 //Size of coordinates: 98486
//Min 2 overlapping: 8622
