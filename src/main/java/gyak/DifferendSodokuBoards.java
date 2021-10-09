package gyak;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DifferendSodokuBoards {
    private static Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;
    Map<String, Integer> statistics = new HashMap<>();

    public static void main(String[] args) {
        DifferendSodokuBoards sodoku = new DifferendSodokuBoards();
        sodoku.countBoards(Path.of("d:", "Sodokus.txt"));
    }

    public void countBoards(Path path) {
        List<List<Integer>> actualBoard;
        while (!(actualBoard = readFromFile(path)).isEmpty()) {
            gainStatisticsAboutLeftUpperNr(actualBoard);
            gainStatisticsAboutLeftBottomNr(actualBoard);
        }
        System.out.println("End of file \n \n Statistics:");
        printStatistics();
    }

    private List<List<Integer>> readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path, CHARSET_UTF_8)) {
            return readNextBoard(br);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private List<List<Integer>> readNextBoard(BufferedReader br) throws IOException {
        List<List<Integer>> board = new ArrayList<>(9);
        String line;

        skipTheEmptyLine(br);
        for (int i = 0; i <= 8; i++) {
            line = br.readLine();
            if (line != null) {
                board.add(makeRow(line));
            } else {
                return Collections.emptyList();
            }
        }
        return board.size() == 9 ? board : Collections.emptyList();
    }

    private List<Integer> makeRow(String line) {
        List<Integer> oneRow = new ArrayList<>(9);
        String[] strArr = line.split(",");
        for (String s : strArr) {
            oneRow.add(Integer.parseInt(s.trim()));
        }
        return oneRow;
    }

    private void gainStatisticsAboutLeftUpperNr(List<List<Integer>> board) {
        Integer u = board.get(0).get(0);
        StringBuilder collector = new StringBuilder(8);
        for (int i = 1; i <= 8; i++) {
            collector.append(board.get(i).indexOf(u));
        }
        writeToStatistics(collector);
        System.out.println("lUp: "+ collector);                      //@
    }

    private void gainStatisticsAboutLeftBottomNr(List<List<Integer>> board) {
        Integer b = board.get(8).get(0);
        StringBuilder collector = new StringBuilder(8);
        for (int columnNr = 1; columnNr <= 8; columnNr++) {
            for(int rowNr = 0; rowNr <= 8; rowNr++){
                if(board.get(rowNr).indexOf(b) == columnNr){
                    collector.append(8 - rowNr);
                    break;
                }
            }
        }
        writeToStatistics(collector);
        System.out.println("lBo:"+ collector);                      //@
    }

    private void printStatistics() {
    }

    private void writeToStatistics(StringBuilder collector) {
        String actualKey = collector.toString();
        if (!statistics.containsKey(actualKey)) {
            statistics.put(actualKey, 0);
        }
        statistics.put(actualKey, statistics.get(actualKey) + 1);
    }

    private void skipTheEmptyLine(BufferedReader br) throws IOException {
        br.readLine();
    }
}
// Feladat: különböznek-e a Sodoku tábla kitöltések?
// Darabokban file olvasás. Táblánként.
// Bal felső szám (0. row) hányadik indexen (column) fordul elő egyes sorokban?
// Bal alsó átszámítása (u.az a megoldás, ha elforgatom a mátrixot):
//  egyes columnokban a 8 mínusz hányadik rowban szerepel adott szám.

