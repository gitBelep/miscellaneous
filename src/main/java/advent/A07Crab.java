package advent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class A07Crab {
    private List<Integer> crabList = new ArrayList<>();

    public int simulateCrabPositions(Path path, String model) {
        String crabsPos = readFile(path);
        makeCrabList(crabsPos);
        if("exponential".equals(model)){
            return findBestPosExp();
        } else {
            return findBestPos();
        }
    }

    private String readFile(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void makeCrabList(String crabs) {
        String[] arr = crabs.split(",");
        for (String s : arr) {
            crabList.add(Integer.parseInt(s.trim()));
        }
    }

    private int findBestPos() {
        int felirtI = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : crabList) {
            if (i < min)  min = i;
            if (i > max)  max = i;
        }

        for (int i = min; i <= max; i++) {
            int sum = 0;
            for (int b : crabList) {
                sum += Math.abs(i - b);
            }
            if (sum < result) {
                result = sum;
                felirtI = i;
            }
        }
        System.out.println(felirtI +": "+ result);
        return result;
    }

    public int findBestPosExp(){
        int coordinate = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int moves;
        int fuel;
        int sum;

        for (int i : crabList) {
            if (i < min)  min = i;
            if (i > max)  max = i;
        }

        for (int i = min; i <= max; i++) {
            sum = 0;

            for (int b : crabList) {
                fuel = 0;
                moves = Math.abs(i - b);
                for(int x = 1; x <= moves; x++){
                    fuel += x;
                }
                sum += fuel;
            }

            if (sum < result) {
                result = sum;
                coordinate = i;
            }
        }
        System.out.println(coordinate +": "+ result);
        return result;
    }

}
