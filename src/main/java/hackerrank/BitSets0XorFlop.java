package hackerrank;

import java.util.Scanner;
import java.util.BitSet;

public class BitSets0XorFlop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        BitSet[] bitset = new BitSet[3];    //Array of BiitSets
        bitset[1] = b1;
        bitset[2] = b2;

        while (0 < m--) {
            String option = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            switch (option) {
                case "AND":
                    bitset[x].and(bitset[y]);   //bitset with bitset
                    break;
                case "OR":
                    bitset[x].or(bitset[y]);
                    break;
                case "XOR":
                    bitset[x].xor(bitset[y]);
                    break;
                case "SET":
                    bitset[x].set(y);  //bit
                    break;
                case "FLIP":
                    bitset[x].flip(y);  //bit
            }
            System.out.println(b1.cardinality() +" "+ b2.cardinality());
        }
    }

}
