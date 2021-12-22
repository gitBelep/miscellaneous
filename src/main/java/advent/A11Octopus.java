package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class A11Octopus {
    private int[][] octopusses = new int[10][];
    private List<List<Integer>> flashes;
    private int flashCounter = 0;

    public int go(Path path, int rounds) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            watchOctopuses(br);
                return flashing(rounds);
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
        return 0;
    }

    private void watchOctopuses(BufferedReader br) throws IOException {
        int counter = 0;
        String line;
        int[] thisLineOfOctopusses;
        while ((line = br.readLine()) != null) {
            thisLineOfOctopusses = new int[10];
            char[] loadings = line.toCharArray();
            for (int i = 0; i < line.length(); i++) {
                thisLineOfOctopusses[i] = Integer.parseInt(String.valueOf(loadings[i]));
            }            //System.out.println(counter +". >> "+ Arrays.toString(thisLineOfOctopusses));
            octopusses[counter] = thisLineOfOctopusses;
            counter++;
        }
    }

    private int flashing(int rounds) {
        for (int r = 1; r <= rounds; r++) {
            if(flashes != null && flashes.size() == 100){
                return r - 1;               //returns when flashing all octopusses at the same time
            }
            flashes = new ArrayList<>();
            increaseByOne();
            flashingAndIncreasingEnvironment();
            // print out the matrix after any rounds:
            //    for (int[] arr : octopusses) {
            //        System.out.println(r + ": " + Arrays.toString(arr));
            //    }   System.out.println(" ");
        }
        return flashCounter;                //returns the flashes after 100 rounds
    }

    private void increaseByOne() {
        for (int[] arr : octopusses) {
            for (int a = 0; a < 10; a++) {
                arr[a] = arr[a] + 1;
            }
            //System.out.println("+1: " + Arrays.toString( arr));
        }
    }

    private void flashingAndIncreasingEnvironment() {
        boolean octopusWithLoadingOver9 = true;
        while (octopusWithLoadingOver9) {
            for (int k = 0; k < 10; k++) {
                for (int b = 0; b < 10; b++) {
                    if (octopusses[k][b] > 9 && !flashes.contains(List.of(k, b))) {
                        octopusses[k][b] = 0;                                         // flash
                        flashes.add(List.of(k, b));
                        flashCounter++;

                        if (b > 0 && !flashes.contains(List.of(k, b - 1))) {       //environment changes
                            octopusses[k][b - 1] = octopusses[k][b - 1] + 1;       //only if they didnt flash
                        }
                        if (b < 9 && !flashes.contains(List.of(k, b + 1))) {
                            octopusses[k][b + 1] = octopusses[k][b + 1] + 1;
                        }
                        if (k > 0) {
                            if (!flashes.contains(List.of(k - 1, b))) {
                                octopusses[k - 1][b] = octopusses[k - 1][b] + 1;
                            }
                            if (b > 0 && !flashes.contains(List.of(k - 1, b - 1))) {
                                octopusses[k - 1][b - 1] = octopusses[k - 1][b - 1] + 1;
                            }
                            if (b < 9 && !flashes.contains(List.of(k - 1, b + 1))) {
                                octopusses[k - 1][b + 1] = octopusses[k - 1][b + 1] + 1;
                                //System.out.println("k-1,b+1: "+ (k - 1) +"; "+ (b + 1) );
                            }
                        }
                        if (k < 9) {
                            if (!flashes.contains(List.of(k + 1, b))) {
                                octopusses[k + 1][b] = octopusses[k + 1][b] + 1;
                            }
                            if (b > 0 && !flashes.contains(List.of(k + 1, b - 1))) {
                                octopusses[k + 1][b - 1] = octopusses[k + 1][b - 1] + 1;
                            }
                            if (b < 9 && !flashes.contains(List.of(k + 1, b + 1))) {
                                octopusses[k + 1][b + 1] = octopusses[k + 1][b + 1] + 1;
                            }
                        }
                    }
                }
            }
            octopusWithLoadingOver9 = reviseOctopusesLoading();
        }
    }

    private boolean reviseOctopusesLoading() {
        for (int k = 0; k < 10; k++) {
            for (int b = 0; b < 10; b++) {
                if (octopusses[k][b] > 9 && !flashes.contains(List.of(k, b))) {
                    return true;
                }
            }
        }
        return false;
    }

}
