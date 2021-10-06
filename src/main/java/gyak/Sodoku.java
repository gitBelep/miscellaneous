package gyak;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Sodoku {
    private static int SODOKU_SIZE = 9;
    private Path path = Path.of("d:", "Sodokus.txt");
    private Random rnd = new Random();
    private int[][] board;
    private List<Integer> columnList;
    private List<Integer> rowList;
    private List<Integer> square;

    public static void main(String[] args) {
        Sodoku sodoku = new Sodoku();
        for(int eger = 0; eger < 5; eger++){
            sodoku.buildSodokuBoard();
        }
    }


    public void buildSodokuBoard() {
        fillFirstRow();

        for (int rowNr = 1; rowNr < SODOKU_SIZE; rowNr++) {
            System.out.println("\nbuilding the row No. " + rowNr);          //@
            int returnedRowNr = buildMostOfColumns(rowNr);
            if(returnedRowNr < rowNr){
                rowNr = returnedRowNr;
                continue;
            }

            int rest = getNumberForLastColumn(board[rowNr]);
            System.out.println("actual row: " + Arrays.toString(board[rowNr]).substring(1, Arrays.toString(board[rowNr]).length() - 2) +" + "+ rest);  //@

            fillRowLists(rowNr, SODOKU_SIZE - 1);
            fillColumnLists(rowNr, SODOKU_SIZE - 1);
            fillSquare(rowNr, SODOKU_SIZE - 1);
            System.out.println("forbidden: " + columnList + " & " + square);               //@

            rowNr = reviseLastNumber(rowNr, rest);
        }
        System.out.println("\nThe Sodoku board:");
        writeSodokuBoardToFile();
    }

    private int reviseLastNumber(int rowNr, int rest) {
        if (!columnList.contains(rest) && !square.contains(rest)) {
            board[rowNr][SODOKU_SIZE - 1] = rest;
            return rowNr;
        } else {
            goBackToThisRow(rowNr);
        }
        return rowNr - 1;
    }

    private void goBackToThisRow(int rowNr){
        System.out.println("go back to this row: "+ rowNr);     //@
        for (int k = 0; k < SODOKU_SIZE; k++) {
            board[rowNr][k] = 0;
        }
    }

    private int getNumberForLastColumn(int[] row) {
        List<Integer> numbers = getNumbers();
        for (int k : row) {
            if (numbers.contains(k)) {
                numbers.remove((Integer) k);
            }
        }
        return numbers.get(0);
    }

    private int buildMostOfColumns(int rowNr) {
        for (int colNr = 0; colNr < SODOKU_SIZE - 1; colNr++) {
            fillRowLists(rowNr, colNr);
            fillColumnLists(rowNr, colNr);
            fillSquare(rowNr, colNr);
            int counter = 0;

            while (board[rowNr][colNr] == 0) {
                int x = rnd.nextInt(SODOKU_SIZE) + 1;
                counter++;
                if (!rowList.contains(x) && !columnList.contains(x) && !square.contains(x)) {
                    board[rowNr][colNr] = x;
                    break;
                }
                if(counter > 25) {
                    if (totallyImpossible()) {
                        goBackToThisRow(rowNr);
                        goBackToThisRow(rowNr - 1);
                        System.out.println("totally impossible: erase also the row before");  //@
                        return rowNr - 2;
                    }
                    if (impossibleThisWay()) {
                        goBackToThisRow(rowNr);
                        System.out.println("impossible: erase this row");             //@
                        return rowNr - 1;
                    }
                }
            }
        }
        return rowNr;
    }

    private boolean impossibleThisWay() {
        Set<Integer> set = new HashSet<>(rowList);
        set.addAll(columnList);
        set.addAll(square);
        return set.containsAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private boolean totallyImpossible() {
        Set<Integer> set = new HashSet<>(columnList);
        set.addAll(square);
        return set.containsAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private void fillRowLists(int rowNr, int colNr) {
        rowList = new ArrayList<>(colNr);
        for (int ci = 0; ci < colNr; ci++) {
            rowList.add(board[rowNr][ci]);
        }
    }

    private void fillColumnLists(int rowNr, int colNr) {
        columnList = new ArrayList<>(rowNr);
        for (int ri = 0; ri < rowNr; ri++) {
            columnList.add(board[ri][colNr]);
        }
    }

    private void fillSquare(int rowNr, int colNr) {
        square = new ArrayList<>(SODOKU_SIZE);
        int[] rs;
        int[] cs;

        if (rowNr % 3 == 0) {
            rs = new int[]{rowNr, rowNr + 1, rowNr + 2};
        } else if (rowNr % 3 == 1) {
            rs = new int[]{rowNr - 1, rowNr, rowNr + 1};
        } else {
            rs = new int[]{rowNr - 2, rowNr - 1, rowNr};
        }
        if (colNr % 3 == 0) {
            cs = new int[]{colNr, colNr + 1, colNr + 2};
        } else if (colNr % 3 == 1) {
            cs = new int[]{colNr - 1, colNr, colNr + 1};
        } else {
            cs = new int[]{colNr - 2, colNr - 1, colNr};
        }

        for (int r : rs) {
            for (int c : cs) {
                square.add(board[r][c]);
            }
        }
    }

    private List<Integer> getNumbers() {
        List<Integer> numberList = new ArrayList<>();
        for (int f = 1; f <= SODOKU_SIZE; f++) {
            numberList.add(f);
        }
        return numberList;
    }

    private void fillFirstRow() {
        List<Integer> firstRow = getNumbers();
        board = new int[SODOKU_SIZE][SODOKU_SIZE];
        Collections.shuffle(firstRow);
        for (int i = 0; i < SODOKU_SIZE; i++) {
            board[0][i] = firstRow.get(i);
        }
        System.out.println("row No. 0: " + Arrays.toString(board[0]));  // @
    }

    private void writeSodokuBoardToFile(){
        Charset ch = StandardCharsets.UTF_8;
        StandardOpenOption oo = StandardOpenOption.APPEND;
        try (BufferedWriter writer = Files.newBufferedWriter(path, ch, oo)){
            writeLines(writer);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    private void writeLines(BufferedWriter bw) throws IOException{
        String[] lines = Arrays.deepToString(board).split("], \\[");
        String line;
        for(int i = 0; i < lines.length; i++){
            if(i == 0){
                line = "\n"+ lines[i].substring(2);
            } else if(i == lines.length - 1){
                line = lines[i].substring(0, lines[i].length() - 2);
            }else{
                line = lines[i];
            }
            bw.write(line + "\n");
            System.out.println(line);           //@
        }
    }

}
