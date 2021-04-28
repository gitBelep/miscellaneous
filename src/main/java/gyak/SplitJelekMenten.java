package gyak;

import java.util.Scanner;

public class SplitJelekMenten {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        StringBuilder a = new StringBuilder();
        char before = ' ';

        for (char i : cs) {
            if (Character.isLetter(i) || (i == ' ' && Character.isLetter(before))) {
                a.append(i);
                before = i;
            } else {
                if (before != ' ') {
                    a.append(' ');
                    before = ' ';
                }
            }
        }

        String res = a.toString().trim();
        if (res.length() == 0 ){
            System.out.println(0);
        } else {
            String[] parts = a.toString().split(" ");

            System.out.println(parts.length);
            for (String f : parts) {
                System.out.println(f);
            }
        }
        sc.close();
    }

}
//Írj ki minden betűhalmazt külön sorba (ami nem betűhalmaz, azt -ill. szüneteket- ne),
// és a halamzok számát előre.
//Elválasztójel bármi, ami nem betű.
