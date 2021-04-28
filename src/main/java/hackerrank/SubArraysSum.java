package hackerrank;
import java.util.Scanner;

public class SubArraysSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];

        String scipEndOfLine = scan.nextLine();

        String[] numbersForArray = scan.nextLine().split(" ");
        scan.close();

        for (int i = 0;  i < n; i++){
            a[i] = Integer.parseInt(numbersForArray[i]);
        }
//        int a[] = new int[]{1, -2, 4, -5, 1};  //9 db
        int counter = 0;
        for (int f = 0; f < a.length; f++) {
            for (int k = f; k < a.length; k++) {
                int sum = 0;
                for (int b = f; b <= k; b++) {
                    sum += a[b];
                }
                if (sum < 0) {
                    counter++;
                }
            }
        }
        System.out.println(counter +" db negatív összegű altömbje van");
    }

}
