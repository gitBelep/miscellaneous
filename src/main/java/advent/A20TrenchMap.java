package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class A20TrenchMap {
    private String rule = "";
    List<char[]> trench = new LinkedList<>();

    public int go(Path path, int rounds) {
        readData(path);
        //printTrench();
        for (int r = 1; r <= rounds; r++) {
            convertingPixels();
            //printTrench();
        }
        return countLightningPixels();
    }

    private void readData(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            rule = br.readLine();

            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                trench.add((line).toCharArray());
            }

            addFrame('.');
            addFrame('.');
            addFrame('.');
        } catch (IOException e) {
            System.out.println(" =:-o E0C==| ");
        }
    }

    private void addFrame(char inCh) {
        List<char[]> framed = new LinkedList<>();
        String strCh = String.valueOf(inCh);
        int arrLength = trench.get(0).length;

        framed.add((strCh.repeat(arrLength + 2)).toCharArray());

        for (char[] arr : trench) {
            char[] actual = new char[arrLength + 2];
            actual[0] = inCh;
            System.arraycopy(arr, 0, actual, 1, arrLength);
            actual[arrLength + 1] = inCh;
            framed.add(actual);
        }

        framed.add((strCh.repeat(arrLength + 2)).toCharArray());
        trench = framed;
    }

    private void convertingPixels() {
        List<char[]> convertedTrench = new LinkedList<>();
        char unTouchAbleChar = trench.get(0)[0];
        int listSize = trench.size();
        int arrLength = trench.get(0).length;

        for (int k = 0; k < listSize; k++) {
            char[] actual = new char[arrLength];
            for (int b = 0; b < arrLength; b++) {
                String reversedBinarDigits = getherAdjacentPixels(k, b, listSize, arrLength, unTouchAbleChar);
                int index = findIndex(reversedBinarDigits);
                actual[b] = rule.charAt(index);
            }
            convertedTrench.add(actual);
        }
        trench = convertedTrench;
        addFrame(trench.get(0)[0]);     //the new one
    }

    private int findIndex(String reversedBinarDigits) {
        int power = 0;
        int actualDigit = 0;
        int sum = 0;
        for (char c : reversedBinarDigits.toCharArray()) {
            actualDigit = c == '#' ? 1 : 0;
            sum += actualDigit * Math.pow(2, power);
            power++;
        }
        return sum;
    }

    private String getherAdjacentPixels(int k, int b, int listSize, int arrLength, char c) {
        String unTouchAbleChar = String.valueOf(c);

        StringBuilder sb = new StringBuilder();
        if (0 < b && b < arrLength - 1) {
            if (0 < k && k < listSize - 1) {
                sb.append(trench.get(k - 1)[b - 1]).append(trench.get(k - 1)[b]).append(trench.get(k - 1)[b + 1]);
                sb.append(trench.get(k)[b - 1]).append(trench.get(k)[b]).append(trench.get(k)[b + 1]);
                sb.append(trench.get(k + 1)[b - 1]).append(trench.get(k + 1)[b]).append(trench.get(k + 1)[b + 1]);
            } else if (k == 0) {
                sb.append(unTouchAbleChar.repeat(3));
                sb.append(trench.get(k)[b - 1]).append(trench.get(k)[b]).append(trench.get(k)[b + 1]);
                sb.append(trench.get(k + 1)[b - 1]).append(trench.get(k + 1)[b]).append(trench.get(k + 1)[b + 1]);
            } else if (k == listSize - 1) {
                sb.append(trench.get(k - 1)[b - 1]).append(trench.get(k - 1)[b]).append(trench.get(k - 1)[b + 1]);
                sb.append(trench.get(k)[b - 1]).append(trench.get(k)[b]).append(trench.get(k)[b + 1]);
                sb.append(unTouchAbleChar.repeat(3));
            }
        }
        if (b == 0) {
            if (0 < k && k < listSize - 1) {
                sb.append(unTouchAbleChar).append(trench.get(k - 1)[b]).append(trench.get(k - 1)[b + 1]);
                sb.append(unTouchAbleChar).append(trench.get(k)[b]).append(trench.get(k)[b + 1]);
                sb.append(unTouchAbleChar).append(trench.get(k + 1)[b]).append(trench.get(k + 1)[b + 1]);
            } else if (k == 0) {
                sb.append(unTouchAbleChar.repeat(3));
                sb.append(unTouchAbleChar).append(trench.get(k)[b]).append(trench.get(k)[b + 1]);
                sb.append(unTouchAbleChar).append(trench.get(k + 1)[b]).append(trench.get(k + 1)[b + 1]);
            } else if (k == listSize - 1) {
                sb.append(unTouchAbleChar).append(trench.get(k - 1)[b]).append(trench.get(k - 1)[b + 1]);
                sb.append(unTouchAbleChar).append(trench.get(k)[b]).append(trench.get(k)[b + 1]);
                sb.append(unTouchAbleChar.repeat(3));
            }
        }
        if (b == arrLength - 1) {
            if (0 < k && k < listSize - 1) {
                sb.append(trench.get(k - 1)[b - 1]).append(trench.get(k - 1)[b]).append(unTouchAbleChar);
                sb.append(trench.get(k)[b - 1]).append(trench.get(k)[b]).append(unTouchAbleChar);
                sb.append(trench.get(k + 1)[b - 1]).append(trench.get(k + 1)[b]).append(unTouchAbleChar);
            } else if (k == 0) {
                sb.append(unTouchAbleChar.repeat(3));
                sb.append(trench.get(k)[b - 1]).append(trench.get(k)[b]).append(unTouchAbleChar);
                sb.append(trench.get(k + 1)[b - 1]).append(trench.get(k + 1)[b]).append(unTouchAbleChar);
            } else if (k == listSize - 1) {
                sb.append(trench.get(k - 1)[b - 1]).append(trench.get(k - 1)[b]).append(unTouchAbleChar);
                sb.append(trench.get(k)[b - 1]).append(trench.get(k)[b]).append(unTouchAbleChar);
                sb.append(unTouchAbleChar.repeat(3));
            }
        }
        return sb.reverse().toString();
    }

    private int countLightningPixels() {
        int counter = 0;
        for (char[] arr : trench) {
            for (char c : arr) {
                if (c == '#') counter++;
            }
        }
        return counter;
    }

    private void printTrench(){
        for (char[] arr : trench) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
//With the scanners fully deployed, you turn their attention to mapping the floor of the ocean trench.
//When you get back the image from the scanners, it seems to just be random noise. Perhaps you can combine an image
// enhancement algorithm and the input image (your puzzle input) to clean it up a little.
//For example:
//..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##
//#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###
//.######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#.
//.#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#.....
//.#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#..
//...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.....
//..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#
//
//#..#.
//#....
//##..#
//..#..
//..###
//The first section is the image enhancement algorithm. It is normally given on a single line, but it has been wrapped
// to multiple lines in this example for legibility. The second section is the input image, a two-dimensional grid of
// light pixels (#) and dark pixels (.).
//The image enhancement algorithm describes how to enhance an image by simultaneously converting all pixels in the input
// image into an output image. Each pixel of the output image is determined by looking at a 3x3 square of pixels centered
// on the corresponding input image pixel. So, to determine the value of the pixel at (5,10) in the output image, nine
// pixels from the input image need to be considered: (4,9), (4,10), (4,11), (5,9), (5,10), (5,11), (6,9), (6,10),
// and (6,11). These nine input pixels are combined into a single binary number that is used as an index in the image
// enhancement algorithm string.
//For example, to determine the output pixel that corresponds to the very middle pixel of the input image, the nine
// pixels marked by [...] would need to be considered:
//# . . # .
//#[. . .].
//#[# . .]#
//.[. # .].
//. . # # #
//Starting from the top-left and reading across each row, these pixels are ..., then #.., then .#.; combining these
// forms ...#...#.. By turning dark pixels (.) into 0 and light pixels (#) into 1, the binary number 000100010 can be
// formed, which is 34 in decimal.
//The image enhancement algorithm string is exactly 512 characters long, enough to match every possible 9-bit binary
// number. The first few characters of the string (numbered starting from zero) are as follows:
//0         10        20        30  34    40        50        60        70
//|         |         |         |   |     |         |         |         |
//..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##
//In the middle of this first group of characters, the character at index 34 can be found: #. So, the output pixel in
// the center of the output image should be #, a light pixel.
//This process can then be repeated to calculate every pixel of the output image.
//Through advances in imaging technology, the images being operated on here are infinite in size. Every pixel of the
// infinite output image needs to be calculated exactly based on the relevant pixels of the input image. The small input
// image you have is only a small region of the actual infinite input image; the rest of the input image consists of
// dark pixels (.). For the purposes of the example, to save on space, only a portion of the infinite-sized input and
// output images will be shown.
//The starting input image, therefore, looks something like this, with more dark pixels (.) extending forever in every
// direction not shown here:
//...............
//...............
//...............
//...............
//...............
//.....#..#......
//.....#.........
//.....##..#.....
//.......#.......
//.......###.....
//...............
//...............
//...............
//...............
//...............
//By applying the image enhancement algorithm to every pixel simultaneously, the following output image can be obtained:
//...............
//...............
//...............
//...............
//.....##.##.....
//....#..#.#.....
//....##.#..#....
//....####..#....
//.....#..##.....
//......##..#....
//.......#.#.....
//...............
//...............
//...............
//...............
//Through further advances in imaging technology, the above output image can also be used as an input image! This allows
// it to be enhanced a second time:
//...............
//...............
//...............
//..........#....
//....#..#.#.....
//...#.#...###...
//...#...##.#....
//...#.....#.#...
//....#.#####....
//.....#.#####...
//......##.##....
//.......###.....
//...............
//...............
//...............
//Truly incredible - now the small details are really starting to come through. After enhancing the original input image
// twice, 35 pixels are lit.
//Start with the original input image and apply the image enhancement algorithm twice, being careful to account for the
// infinite size of the images. How many pixels are lit in the resulting image?
//--- Part Two ---
//You still can't quite make out the details in the image. Maybe you just didn't enhance it enough.
//If you enhance the starting input image in the above example a total of 50 times, 3351 pixels are lit in the final output image.
//Start again with the original input image and apply the image enhancement algorithm 50 times. How many pixels are lit
// in the resulting image?
