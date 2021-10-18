package hackerrank;

import java.util.Scanner;

public class Cats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        sc.nextLine();
        for( ; rounds > 0; rounds--){
            String[] animals = sc.nextLine().split(" ");
            int catA = Integer.parseInt(animals[0]);
            int catB = Integer.parseInt(animals[1]);
            int mouse = Integer.parseInt(animals[2]);
            int distanceA = Math.abs(catA - mouse);
            int distanceB = Math.abs(catB - mouse);
            System.out.println( catAndMouse(distanceA, distanceB) );
        }
    }

    private static String catAndMouse(int distanceA, int distanceB) {
        if(distanceA < distanceB){
            return "Cat A";
        } else if(distanceB < distanceA){
            return"Cat B";
        } else {
            return "Mouse C";
        }
    }

}
