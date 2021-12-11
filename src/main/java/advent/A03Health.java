package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class A03Health {
    private List<char[]> bitsList = new LinkedList<>();

    public static void main(String[] args) {
        Path pp = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "health.txt");
        A03Health h = new A03Health();
        try(BufferedReader br  = Files.newBufferedReader(pp)){
            h.fillBitsList(br);
            // a)
            System.out.println("Leggyakoribb és ellentét bitből képzett DEC szorzata: "+ h.countBits());
            // b)
            System.out.println("Leggyakoribb és legritkább előfordulásokat tartalmazó szám szorzata: "+ h.bestAndWorst());
        } catch(IOException ioe){
            throw new IllegalArgumentException(" |==0O> o-:E ..< áá@ÁÁ! > ", ioe);
        }
    }

    private int countBits() {
        List<char[]> bits = new LinkedList<>(bitsList);

        int bitLength = bits.get(0).length;
        StringBuilder binaryDigits = new StringBuilder(bitLength);
        for(int k = 0; k < bitLength; k++){
            int counter0 = 0;
            int counter1 = 0;

            for(int i = 0; i < bits.size(); i++){
                if ((bits.get(i)[k] == '0')) {
                    counter0++;
                } else {
                    counter1++;
                }
            }
            if(counter0 > counter1){
                binaryDigits.append("0");
            } else {
                binaryDigits.append("1");
            }
        }
    //    System.out.println("common Bits: "+ binaryDigits);
        int decNr = Integer.parseInt(binaryDigits.toString(), 2);
        //int decNr = Integer.valueOf(binaryDigits.toString(),2);        //the same

        StringBuilder oppositBits = new StringBuilder(bitLength);
        for(char c : binaryDigits.toString().toCharArray()){
            oppositBits.append( c == '0' ? "1" : "0");
        }
    //    System.out.println("opposit Bits: "+ oppositBits);
        int oppositNr =  Integer.parseInt(oppositBits.toString(), 2);
    //    System.out.println("decNr: "+ decNr + "; oppositNr: "+ oppositNr);
        return decNr * oppositNr;
    }

    private int bestAndWorst(){
        int bestNr  = Integer.parseInt(new String( best()  ), 2);
        int worstNr = Integer.parseInt(new String( worst() ), 2);
        System.out.println("bestNr: "+ bestNr +"; worstNr: "+ worstNr);
        return bestNr * worstNr;
    }

    private char[] best() {
        List<char[]> bits = new LinkedList<>(bitsList);

        for(int i = 0; i < bits.get(0).length; i++) {
            int counter1 = 0;
            for (char[] cArr : bits) {
                if (cArr[i] == '1') {
                    counter1++;
                }
            }
            char searched = counter1 >= (bits.size() - counter1) ? '1' : '0';

            Iterator<char[]> it = bits.iterator();
            while (it.hasNext()) {
                char[] actualArr = it.next();
                if (actualArr[i] != searched) {
                    it.remove();
                }
            }
        }
        return bits.get(0);
    }

    private char[] worst() {
        List<char[]> bits = new LinkedList<>(bitsList);
        for(int i = 0; i < bits.get(0).length; i++) {
    //        System.out.println(i +". size: "+ bits.size());  //1000,494,242,112,56,27,11,5,2
            int counter1 = 0;
            for (char[] cArr : bits) {
                if (cArr[i] == '1') {
                    counter1++;
                }
            }
            char searched = counter1 >= (bits.size() - counter1) ? '0' : '1';  //swapped

            Iterator<char[]> it = bits.iterator();
            while (it.hasNext()) {
                char[] actualArr = it.next();
                if (actualArr[i] != searched) {
                    it.remove();
                }
            }
            if(bits.size() == 1){
                return bits.get(0);
            }
        }
        return bits.get(0);
    }

    private void fillBitsList(BufferedReader br) throws  IOException{
        String line;
        while((line = br.readLine()) != null){
            char[] chars = line.trim().toCharArray();
    //        System.out.println("chars"+ Arrays.toString(chars));
            bitsList.add(chars);
        }
    }

}
//The submarine has been making some odd creaking noises, so you ask it to produce a diagnostic report just in case.
//
//The diagnostic report (your puzzle input) consists of a list of binary numbers which, when decoded properly, can tell you many useful things about the conditions of the submarine. The first parameter to check is the power consumption.
//
//You need to use the binary numbers in the diagnostic report to generate two new binary numbers (called the gamma rate and the epsilon rate). The power consumption can then be found by multiplying the gamma rate by the epsilon rate.
//
//Each bit in the gamma rate can be determined by finding the most common bit in the corresponding position of all numbers in the diagnostic report. For example, given the following diagnostic report:
//
//00100
//11110
//10110
//10111
//10101
//01111
//00111
//11100
//10000
//11001
//00010
//01010
//Considering only the first bit of each number, there are five 0 bits and seven 1 bits. Since the most common bit is 1, the first bit of the gamma rate is 1.
//
//The most common second bit of the numbers in the diagnostic report is 0, so the second bit of the gamma rate is 0.
//
//The most common value of the third, fourth, and fifth bits are 1, 1, and 0, respectively, and so the final three bits of the gamma rate are 110.
//
//So, the gamma rate is the binary number 10110, or 22 in decimal.
//
//The epsilon rate is calculated in a similar way; rather than use the most common bit, the least common bit from each position is used. So, the epsilon rate is 01001, or 9 in decimal. Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.
//
//Use the binary numbers in your diagnostic report to calculate the gamma rate and epsilon rate, then multiply them together. What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)
//
//Your puzzle answer was 2261546.
//
//The first half of this puzzle is complete! It provides one gold star: *
//
//--- Part Two ---
//Next, you should verify the life support rating, which can be determined by multiplying the oxygen generator rating by the CO2 scrubber rating.
//
//Both the oxygen generator rating and the CO2 scrubber rating are values that can be found in your diagnostic report - finding them is the tricky part. Both values are located using a similar process that involves filtering out values until only one remains. Before searching for either rating value, start with the full list of binary numbers from your diagnostic report and consider just the first bit of those numbers. Then:
//
//Keep only numbers selected by the bit criteria for the type of rating value for which you are searching. Discard numbers which do not match the bit criteria.
//If you only have one number left, stop; this is the rating value for which you are searching.
//Otherwise, repeat the process, considering the next bit to the right.
//The bit criteria depends on which type of rating value you want to find:
//
//To find oxygen generator rating, determine the most common value (0 or 1) in the current bit position, and keep only numbers with that bit in that position. If 0 and 1 are equally common, keep values with a 1 in the position being considered.
//To find CO2 scrubber rating, determine the least common value (0 or 1) in the current bit position, and keep only numbers with that bit in that position. If 0 and 1 are equally common, keep values with a 0 in the position being considered.
//For example, to determine the oxygen generator rating value using the same example diagnostic report from above:
//
//Start with all 12 numbers and consider only the first bit of each number. There are more 1 bits (7) than 0 bits (5), so keep only the 7 numbers with a 1 in the first position: 11110, 10110, 10111, 10101, 11100, 10000, and 11001.
//Then, consider the second bit of the 7 remaining numbers: there are more 0 bits (4) than 1 bits (3), so keep only the 4 numbers with a 0 in the second position: 10110, 10111, 10101, and 10000.
//In the third position, three of the four numbers have a 1, so keep those three: 10110, 10111, and 10101.
//In the fourth position, two of the three numbers have a 1, so keep those two: 10110 and 10111.
//In the fifth position, there are an equal number of 0 bits and 1 bits (one each). So, to find the oxygen generator rating, keep the number with a 1 in that position: 10111.
//As there is only one number left, stop; the oxygen generator rating is 10111, or 23 in decimal.
//Then, to determine the CO2 scrubber rating value from the same example above:
//
//Start again with all 12 numbers and consider only the first bit of each number. There are fewer 0 bits (5) than 1 bits (7), so keep only the 5 numbers with a 0 in the first position: 00100, 01111, 00111, 00010, and 01010.
//Then, consider the second bit of the 5 remaining numbers: there are fewer 1 bits (2) than 0 bits (3), so keep only the 2 numbers with a 1 in the second position: 01111 and 01010.
//In the third position, there are an equal number of 0 bits and 1 bits (one each). So, to find the CO2 scrubber rating, keep the number with a 0 in that position: 01010.
//As there is only one number left, stop; the CO2 scrubber rating is 01010, or 10 in decimal.
//Finally, to find the life support rating, multiply the oxygen generator rating (23) by the CO2 scrubber rating (10) to get 230.
//
//Use the binary numbers in your diagnostic report to calculate the oxygen generator rating and CO2 scrubber rating, then multiply them together. What is the life support rating of the submarine? (Be sure to represent your answer in decimal, not binary.)
