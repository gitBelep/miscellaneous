package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.*;

public class A13paper {
    private final List<A13Fold> folds = new ArrayList<>();
    private Set<A13Coordinate> coordinates = new HashSet<>();

    public int go(Path path, String mode) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            buildCoordinateAndInstructionLists(br);
            return makeFolds(mode);
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
        return 0;
    }

    private void buildCoordinateAndInstructionLists(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {                    //EOF
            String tr = line.trim();
            if( tr.length() > 2 &&  !tr.contains("fold along") ) {  //coordinate
                String[] cooArr = tr.split(",");
                coordinates.add(new A13Coordinate(Integer.parseInt(cooArr[0]), Integer.parseInt(cooArr[1])));
            }
            if(tr.contains("fold along")) {    //folding instruction
                if(tr.contains("x")){
                    folds.add(new A13Fold('x', Integer.parseInt(tr.split("=")[1])));
                } else{
                    folds.add(new A13Fold('y', Integer.parseInt(tr.split("=")[1])));
                }
            }                                                        //empty line
        }
    }

    private int makeFolds(String mode){
        int rounds = "first".equals(mode) ? 0 : folds.size();
        for(int k = 0; k < rounds; k++) {
            int foldNr = folds.get(k).getPlace();
            if (folds.get(k).getAxe() == 'x') {
                folding(foldNr, c -> c.getX(), (coo, i) -> coo.setX(i));
            } else {
                folding(foldNr, A13Coordinate::getY, A13Coordinate::setY);
            }
        }
        drawCryptography();
        return coordinates.size();
    }

    private void folding(int foldNr, ToIntFunction<A13Coordinate> func, ObjIntConsumer<A13Coordinate> ac) {
        for (Iterator<A13Coordinate> it = coordinates.iterator(); it.hasNext(); ){
            A13Coordinate actual = it.next();
            if(func.applyAsInt(actual) == foldNr) {
                it.remove();
            } else if(func.applyAsInt(actual) > foldNr){
                ac.accept( actual, 2 * foldNr - func.applyAsInt(actual) );
            }
        }
        coordinates = new HashSet<>(coordinates);       //hier disappear repeating elements
        //System.out.println(coordinates.toString() + "\n" + coordinates.size() +"\n");
    }

    private void drawCryptography(){
        char[][] drawing = new char[6][39];
        for(char[] c : drawing){
            for(int i = 0; i < c.length; i++){
                c[i] = '.';
            }
        }
        int x;
        int y;
        for(A13Coordinate c : coordinates){
            y = c.getX();
            x = c.getY();
            drawing[x][y] = '8';
        }
        for(char[] c : drawing){
            System.out.println(Arrays.toString(c));
        }
    }

}
//You reach another volcanically active part of the cave. It would be nice if you could do some kind of thermal imaging so you could tell ahead of time which caves are too hot to safely enter.
//
//Fortunately, the submarine seems to be equipped with a thermal camera! When you activate it, you are greeted with:
//
//Congratulations on your purchase! To activate this infrared thermal imaging
//camera system, please enter the code found on page 1 of the manual.
//Apparently, the Elves have never used this feature. To your surprise, you manage to find the manual; as you go to open it, page 1 falls out. It's a large sheet of transparent paper! The transparent paper is marked with random dots and includes instructions on how to fold it up (your puzzle input). For example:
//
//6,10
//0,14
//9,10
//0,3
//10,4
//4,11
//6,0
//6,12
//4,1
//0,13
//10,12
//3,4
//3,0
//8,4
//1,10
//2,14
//8,10
//9,0
//
//fold along y=7
//fold along x=5
//The first section is a list of dots on the transparent paper. 0,0 represents the top-left coordinate. The first value, x, increases to the right. The second value, y, increases downward. So, the coordinate 3,0 is to the right of 0,0, and the coordinate 0,7 is below 0,0. The coordinates in this example form the following pattern, where # is a dot on the paper and . is an empty, unmarked position:
//
//...#..#..#.
//....#......
//...........
//#..........
//...#....#.#
//...........
//...........
//...........
//...........
//...........
//.#....#.##.
//....#......
//......#...#
//#..........
//#.#........
//Then, there is a list of fold instructions. Each instruction indicates a line on the transparent paper and wants you to fold the paper up (for horizontal y=... lines) or left (for vertical x=... lines). In this example, the first fold instruction is fold along y=7, which designates the line formed by all of the positions where y is 7 (marked here with -):
//
//...#..#..#.
//....#......
//...........
//#..........
//...#....#.#
//...........
//...........
//-----------
//...........
//...........
//.#....#.##.
//....#......
//......#...#
//#..........
//#.#........
//Because this is a horizontal line, fold the bottom half up. Some of the dots might end up overlapping after the fold is complete, but dots will never appear exactly on a fold line. The result of doing this fold looks like this:
//
//#.##..#..#.
//#...#......
//......#...#
//#...#......
//.#.#..#.###
//...........
//...........
//Now, only 17 dots are visible.
//
//Notice, for example, the two dots in the bottom left corner before the transparent paper is folded; after the fold is complete, those dots appear in the top left corner (at 0,0 and 0,1). Because the paper is transparent, the dot just below them in the result (at 0,3) remains visible, as it can be seen through the transparent paper.
//
//Also notice that some dots can end up overlapping; in this case, the dots merge together and become a single dot.
//
//The second fold instruction is fold along x=5, which indicates this line:
//
//#.##.|#..#.
//#...#|.....
//.....|#...#
//#...#|.....
//.#.#.|#.###
//.....|.....
//.....|.....
//Because this is a vertical line, fold left:
//
//#####
//#...#
//#...#
//#...#
//#####
//.....
//.....
//The instructions made a square!
//
//The transparent paper is pretty big, so for now, focus on just completing the first fold. After the first fold in the example above, 17 dots are visible - dots that end up overlapping after the fold is completed count as a single dot.
//
//How many dots are visible after completing just the first fold instruction on your transparent paper?
//
//Your puzzle answer was 745.
//
//The first half of this puzzle is complete! It provides one gold star: *
//
//--- Part Two ---
//Finish folding the transparent paper according to the instructions.
// The manual says the code is always eight capital letters.
//  "Thanks" for crypto game
//What code do you use to activate the infrared thermal imaging camera system?
//ABKJFBGC