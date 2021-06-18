package gyak;

import java.util.Scanner;

public class Universe42 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rounds = 0;
        if (sc.hasNext()) {
            rounds = sc.nextInt();
        }
        while (rounds-- >= 0) {
            String s = sc.nextLine();
            int fours = 0;
            for (char c : s.toCharArray()) {
                if (c == '4') {
                    fours++;
                }
            }
            System.out.println(fours);
        }
    }

}
