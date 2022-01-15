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
        printTrench();
        for (int r = 1; r <= rounds; r++) {
            convertingPixels();
            printTrench();
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
