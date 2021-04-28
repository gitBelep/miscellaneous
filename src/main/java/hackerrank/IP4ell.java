package hackerrank;

import java.util.Scanner;

public class IP4ell {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}
class MyRegex{
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    final String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}
//Az alsó jó a tesztjeivel, a felső többet tud.
//class MyRegex{
//    final String pattern = "((([0-2]{1}\\d\\d)|([1-9]\\d)|([1-9]))[\\.]){3}(([0-2]{1}\\d\\d)|([1-9]\\d)|([1-9]))";
//}
// ( 0|1|2 bármelyik,x1; \d számjegy vagy dd vagy d pont) x3 és (még x1, de nincs mögötte pont)
//000.12.12.034        //true elvárt
//121.234.12.12        //true
//23.45.12.56          //true
//00.12.123.123123.123 //false
//122.23               //false
//Hello.IP             //false
