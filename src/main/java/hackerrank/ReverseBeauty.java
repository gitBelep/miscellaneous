package hackerrank;

public class ReverseBeauty {
    public static void main(String[] args) {
        System.out.println( beautifulDays(20,30,6) + " numbers are beautiful between 20 & 30");

        System.out.println("\n" + "25 generations: "+ viralAdvertising(25));
    }

    public static int beautifulDays(int i, int j, int k) {
        int counter = 0;
        for(int c = i; c <= j; c++){
            int rev = reverseNum(c);
            if( (c - rev) % k == 0 ){
                System.out.println(c +" - "+ rev+" is beautiful, divideable by: " + k);
                counter++;
            }
        }
        return counter;
    }

    public static int reverseNum(Integer c){
        StringBuilder s = new StringBuilder(c.toString());
        s = s.reverse();
        return Integer.parseInt(s.toString());
    }


    public static int viralAdvertising(int n) {
        int counter = 0;
        int p = 5;
        int senders;
        for(int i = 1; i <= n; i++){
            senders = p/2;
            counter += senders;
            p = senders * 3;
            System.out.print(counter +"; ");
        }
        return counter;
    }

}
