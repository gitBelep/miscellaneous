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
    private List<String> statistics = new ArrayList<>();
    private List<String> sameMusters = new ArrayList<>();

    //Control
    public void makeStatisticsAboutCornerElements(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path, CHARSET_UTF_8)) {

            List<List<Integer>> actualBoard;
            while (!(actualBoard = readNextBoard(br)).isEmpty()) {
                gainStatistics(actualBoard);
                actualBoard = Collections.emptyList();
            }
            printStatistics();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Read file
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

    private void skipTheEmptyLine(BufferedReader br) throws IOException {
        br.readLine();
    }

    //Statistic
    private void gainStatistics(List<List<Integer>> actualBoard){
        gainStatisticsAboutLeftUpperNr(actualBoard);
        gainStatisticsAboutLeftBottomNr(actualBoard);
        gainStatisticsAboutRightUpperNr(actualBoard);
        gainStatisticsAboutRightBottomNr(actualBoard);
    }

    private void gainStatisticsAboutLeftUpperNr(List<List<Integer>> board) {
        Integer u = board.get(0).get(0);
        StringBuilder collector = new StringBuilder(8);
        for (int rowNr = 1; rowNr <= 8; rowNr++) {
            collector.append(board.get(rowNr).indexOf(u));
        }
        writeToStatistics(collector.toString());
    }

    private void gainStatisticsAboutLeftBottomNr(List<List<Integer>> board) {
        Integer b = board.get(8).get(0);
        StringBuilder collector = new StringBuilder(8);
        for (int columnNr = 1; columnNr <= 8; columnNr++) {
            for(int rowNr = 0; rowNr <= 7; rowNr++){
                if(board.get(rowNr).indexOf(b) == columnNr){
                    collector.append(8 - rowNr);
                    break;
                }
            }
        }
        writeToStatistics(collector.toString());
    }

    private void gainStatisticsAboutRightUpperNr(List<List<Integer>> board) {
        Integer ru = board.get(0).get(8);
        StringBuilder collector = new StringBuilder(8);
        for(int columnNr = 7; columnNr >= 0; columnNr--){
            for (int rowNr = 1; rowNr <= 8; rowNr++) {
                if(board.get(rowNr).get(columnNr) == ru){
                    collector.append(rowNr);
                    break;
                }
            }
        }
        writeToStatistics(collector.toString());
    }

    private void gainStatisticsAboutRightBottomNr(List<List<Integer>> board) {
        Integer rb = board.get(8).get(8);
        StringBuilder collector = new StringBuilder(8);
        for(int rowNr = 7; rowNr >= 0; rowNr--){
            for (int columnNr = 7; columnNr >= 0; columnNr--) {
                if(board.get(rowNr).get(columnNr) == rb){
                    collector.append(8 - columnNr);
                    break;
                }
            }
        }
        writeToStatistics(collector.toString());
    }

    private void writeToStatistics(String collector) {
        for(int j = 0; j < statistics.size(); j++){
            if(statistics.get(j).equals(collector)){
                String firstOccurrence = statText(j);
                String actualOccurrence = statText(statistics.size()).substring(3);
                sameMusters.add("\nSame muster: "+ collector + firstOccurrence +" & "+ actualOccurrence);
            }
        }
        statistics.add(collector);
    }

    private String statText(int index){
        int indexOfBoard =  index / 4;
        int indexOfCorner = index % 4;
        String cornerName = "";
        switch (indexOfCorner){
            case 0:
                cornerName = "left  upper  corner";
                break;
            case 1:
                cornerName = "left  bottom corner";
                break;
            case 2:
                cornerName = "right upper  corner";
                break;
            case 3:
                cornerName = "right bottom corner";
                break;
        }
        return " ~ in the "+ indexOfBoard +"th "+ cornerName;
    }

    //Output
    private void printStatistics() {
        System.out.println("Statistics:");
        for(int i = 1; i <= statistics.size(); i++){
            System.out.print(statistics.get(i - 1) +", ");
            if(i % 4 == 0){
                System.out.print("  | ");
            }
            if(i % 8 == 0){
                System.out.println();
            }
        }
        System.out.println();
        for(String s : sameMusters){
            System.out.print(s);
        }
    }

    public List<String> getStatistics() {
        return statistics;
    }

    public List<String> getSameMusters() {
        return sameMusters;
    }

}
// Feladat:
// (+) előfordul-e a táblákban ugyanaz a mintázat a sarkokban? (Tábla elforgatásával)
// Darabokban file olvasás. Táblánként.
// Bal felső szám (0. row) hányadik indexen (column) fordul elő egyes sorokban?
// Bal alsó átszámítása: egyes columnokban a 8 mínusz hányadik rowban szerepel adott szám. ..
// ----------------------------------------
// (-) Are there two boards that are the same?
// Minden tábláról, az első sor minden számáról, minden elforgatásban, tükrözésben statisztika.
// 9 index * 9 nr * 4 rotation * 2 mirroring = 648 String / board
