package hackerrank;

public class Sqrt {

    public static int squares(int a, int b) {
        int bb = (int)(Math.sqrt(b));
        int aa = (int)(Math.sqrt(a));
        return  Math.sqrt(a) == aa ? bb - aa + 1 : bb - aa;
    }

}
