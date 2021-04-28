package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WalkJumpRobot {

    private boolean canWin(int leap, int[] game) {
        int T = 0;
        int U = 1;
//Kezdeti feltételek:
        if (game.length <= 1) return true;
        if (game[0] == U) return false;
//Vannak nagyobb U sorok, mint amit át tudna ugrani?
        int egyes = 0;
        int maxEgyes = 0;
        for (int i : game) {
            if (i == 1) {
                egyes++;
            } else {
                if (egyes > maxEgyes) {
                    maxEgyes = egyes;
                }
                egyes = 0;
            }
        }
        //Ha csupa T-ből áll a sor, 0-ás ugrással is végigmegy rajta.
        if (maxEgyes >= leap && 0 < leap) {
            return false;
        }
//A lényeg:
        int place = 0;
        int h = game.length;
//U-ra változtatom, amiről vissza kellett lépnem. De ha erre ugrással érkeztem, akkor -ha más
//lehetőségek elfogytak-, ki kell próbálnom, mi lett volna, ha nem is ugrom ide. Feljegyzem.
        List<Integer> jumpTo = new ArrayList<>();
        List<Integer> returnPlace = new ArrayList<>();
        while (place < h) {
            if ((place + 1 < h && game[place + 1] == T) || place + 1 == h) {
                place = place + 1;
            } else if ((place + leap < h && game[place + leap] == T && leap > 0) || place + leap >= h) {
                place = place + leap;
                jumpTo.add(place);
            } else if (place - 1 >= 0 && game[place - 1] == T) {
                if (jumpTo.contains(place)){
                    returnPlace.add(place-leap);
                }
                game[place] = U;
                place = place - 1;
            } else if (place - leap >= 0 && game[place - leap] == T && leap > 0) {
                game[place] = U;
                place = place - leap;
            } else if(returnPlace.size() > 0){
                place = returnPlace.remove(returnPlace.size()-1);
            }else {
                return false;   //minden lépéslehetőség elfogyott
            }
        }
        return true;  //túljutottam a végén
    }

    public List<Boolean> readTasks() {
        List<Boolean> solution = readSolution();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(WalkJumpRobot.class.getResourceAsStream("/hackerrank/feladatok.txt")))) {
            for (int round = 0; round < 5000; round++) {
                String line = br.readLine();
                String[] data = line.split(" ");
                int[] game = new int[Integer.parseInt(data[0].trim())];
                int leap = Integer.parseInt(data[1].trim());

                line = br.readLine();
                String[] gameStr = line.split(" ");
                for (int i = 0; i < gameStr.length; i++) {
                    game[i] = Integer.parseInt(gameStr[i].trim());
                }
//itt hívom meg
                if (canWin(leap, game) == solution.get(round)) {
                    System.out.print(".");
                } else {
                    System.out.print(" " + round + " " + game.length + " " + leap + " elvárt:"+ solution.get(round) + Arrays.toString(game));
                }
                if ((round + 1) % 30 == 0) System.out.println();
            }
            return solution;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read feladatok"+ ioe.getMessage());
        }
    }

    private List<Boolean> readSolution() {
        try (BufferedReader brMo = new BufferedReader(new InputStreamReader
                (WalkJumpRobot.class.getResourceAsStream("/hackerrank/megoldas.txt")))) {
            String line;
            List<Boolean> solution = new ArrayList<>();
            while ((line = brMo.readLine()) != null) {
                Boolean b = line.trim().equals("YES") ? true : false;
                solution.add(b);
            }
            return solution;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read megoldasok", ioe);
        }
    }

    public static void main(String[] args) {
// A)
//        Scanner scan = new Scanner(System.in);
//        int q = scan.nextInt();
//        while (q-- > 0) {
//            int n = scan.nextInt();
//            int leap = scan.nextInt();
//
//            int[] game = new int[n];
//            for (int i = 0; i < n; i++) {
//                game[i] = scan.nextInt();
//            }
//
//            System.out.println((canWin(leap, game)) ? "YES" : "NO");
//        }
//        scan.close();
// B)
//        int leap = 4;
//        int[] game = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0};
//        System.out.println((canWin(leap, game)) ? "YES" : "NO");
        WalkJumpRobot robot = new WalkJumpRobot();
        robot.readTasks();
    }

}
// Let's play a game on an array! You're standing at index 0 of an n-element array named game. From some index i
// (where 0<= i <= n), you can perform one of the following moves:
//Move Backward: If cell i-1 exists and contains a 0, you can walk back to cell i-1.
//Move Forward:
//If cell i+1 contains a zero, you can walk to cell .
//If cell i+leap contains a zero, you can jump to cell .
//You can walk or jump off the end of the array and win the game.
//In other words, you can move from index i to index i+1, i-1, or i+leap as long as the destination index
// is a cell containing a 0.
//Given  leap and game, complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).
//Input Format
//The first line contains an integer, n, denoting the number of queries (i.e., function calls).
//The  subsequent 2xq lines describe each query over two lines:
//The first line contains two space-separated integers describing the respective values of  and .
//The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
//Return true if you can win the game; otherwise, return false.
//
//Sample Input:
//4
//5 3
//0 0 0 0 0
//6 5
//0 0 0 1 1 1
//6 3
//0 0 1 1 1 0
//3 1
//0 1 0

//Sample Output:
//YES
//YES
//NO
//NO
//Explanation  We perform the following  queries:
//For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
//For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
//For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
//For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.
