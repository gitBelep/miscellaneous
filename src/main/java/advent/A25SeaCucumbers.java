package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class A25SeaCucumbers {
    char[][] cucumbers;

    public int parking(Path path) {
        int fileLength = scanMap(path);
        scanCucumbers(path, fileLength);
        return waiting(fileLength);
    }

    private int waiting(int fileLength) {
        int arrLength = cucumbers[0].length;
        int move = 1;
        int rounds = -1;
        //draw(rounds);
        while (move > 0) {
            move = moveRight(fileLength, arrLength);
            move += moveDown(fileLength, arrLength);
            rounds++;
            //draw(rounds);
        }
        return rounds + 1; //First step on which no sea cucumbers move
    }

    private void draw(int round) {
        System.out.println(round + 1 + ":");
        for (char[] arr : cucumbers) {
            System.out.println(Arrays.toString(arr).replace(',', ' '));
        }
    }

    private int moveRight(int fileLength, int arrLength) {
        int moving = 0;
        for (int r = 0; r < fileLength; r++) {
            int maxColumn = arrLength;
            for (int c = 0; c < maxColumn; c++) {
                if (cucumbers[r][c] == '>') {
                    if (c < arrLength - 1) {
                        if (cucumbers[r][c + 1] == '.') {
                            cucumbers[r][c] = '.';
                            cucumbers[r][c + 1] = '>';
                            moving++;
                            if(c == 0) maxColumn--; //dont jump over if the 0th element was there
                            c++;
                        }
                    } else {                        //last column
                        if (cucumbers[r][0] == '.') {
                            cucumbers[r][c] = '.';
                            cucumbers[r][0] = '>';
                            moving++;
                        }
                    }
                }
            }
        }
        return moving;
    }

    private int moveDown(int fileLength, int arrLength) {
        int moving = 0;
        for (int c = 0; c < arrLength; c++) {
            int maxRow = fileLength;
            for (int r = 0; r < maxRow; r++) {
                if (cucumbers[r][c] == 'v') {
                    if (r < fileLength - 1) {
                        if (cucumbers[r+1][c] == '.') {
                            cucumbers[r][c] = '.';
                            cucumbers[r+1][c] = 'v';
                            moving++;
                            if(r == 0) maxRow--;    //dont jump to 0 if the 0th element was there
                            r++;                    //jump ower the moved element
                        }
                    } else {                        //last column
                        if (cucumbers[0][c] == '.') {
                            cucumbers[r][c] = '.';
                            cucumbers[0][c] = 'v';
                            moving++;
                        }
                    }
                }
            }
        }
        return moving;
    }

    private int scanMap(Path path) {
        int counter = 0;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while (br.readLine() != null) {
                counter++;
            }
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
        return counter;     //137 rows
    }

    private void scanCucumbers(Path path, int fileLength) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            int lineCounter = 0;
            cucumbers = new char[fileLength][];

            while ((line = br.readLine()) != null) {
                cucumbers[lineCounter] = line.toCharArray();
                lineCounter++;
            }
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
    }

}
