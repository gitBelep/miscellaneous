package hackerrank;

public class ThreeXFive {

    public static void decentNumber(int n) {
        if(n < 3){
            System.out.println("-1");
            return;
        }

        boolean wasWritten = false;
        int i = n / 3;
        for( ; i >= 0; i--){
            if( (n - (i * 3)) % 5 == 0){
                write(i * 3, n - i * 3);
                wasWritten = true;
                break;
            }
        }
        if(!wasWritten) System.out.println("-1");
    }

    public static void write(int fives, int threes){
        StringBuilder s = new StringBuilder();
        for(int i = 1; i <= fives; i++){
            s.append("5");
        }
        for(int i = 1; i <= threes; i++){
            s.append("3");
        }
        System.out.println(s.toString());
    }


    public static void main(String[] args) {
        for(int n = -3; n < 40; n++){
            System.out.print(n + " ~ ");
            ThreeXFive.decentNumber(n);
        }
    }

}
//Sherlock Holmes suspects his archenemy Professor Moriarty is once again plotting something diabolical. Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.
//Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast with a virus. He also gives him a clue: an integer. Sherlock determines the key to removing the virus is to find the largest Decent Number having that number of digits.
//A Decent Number has the following properties:
//*Its digits can only be 3's and/or 5's.
//*The number of 3's it contains is divisible by 5.
//*The number of 5's it contains is divisible by 3.
//*It is the largest such number for its length.
//Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is to help Sherlock find the key before The Beast is destroyed!
//
//For example, the numbers 555_33333 and 555_555 are both decent numbers because there are 3x 5's and 5x 3's in the first, and 2x3x 5's in the second. They are the largest values for those length numbers that have proper divisibility of digit occurrences.
//
//Function Description
//decentNumber has the following parameter(s):
//int n: the length of the decent number to create
//Print the decent number for the given length, or -1 if a decent number of that length cannot be formed. No return value is expected.
//-------------------------------
//My notice: All n > 8 are decent. Blocks of 3's (at the end 'cause we want the biggest nr) repeat 1x, 2x, 0x, 1x 2x ..
