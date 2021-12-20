package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class A08Display {
    int sum = 0;
    char _1;    //  1
    char _2;    //2   3
    char _3;    //  4
    char _4;    //5   6
    char _5;    //  7
    char _6;
    char _7;
    Set<Character> nr1;
    Set<Character> nr2;
    Set<Character> nr3;
    Set<Character> nr4;
    Set<Character> nr5;
    Set<Character> nr6;
    Set<Character> nr7;
    Set<Character> nr8;
    Set<Character> nr9;
    Set<Character> nr0;
    List<Set<Character>> numberList;

    public int clearDigits(Path path, String mode){
        int result = 0;
        try(BufferedReader br = Files.newBufferedReader(path)) {
            if("all".equals(mode)) {
                result = readAllImpulses(br);
            } else {
                result = readImpulses1478(br);
            }
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
        return result;
    }

    private int readImpulses1478(BufferedReader br) throws IOException{
        int counter = 0;
        String line;
        while((line = br.readLine()) != null){
            String[] parts   = line.split("\\|");  //2 parts
            String[] numbers = parts[1].split(" ");
            for(String s : numbers){
                int ll = s.trim().length();
                if(ll == 2 || ll == 3 || ll == 4 || ll == 7){
                    counter++;
                }
            }
        }
        System.out.println(">> "+ counter +" << ");
        return counter;
    }

    private int readAllImpulses(BufferedReader br) throws IOException{
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split("\\|");        //2 parts
            mapLines(parts[0]);
            countLines(parts[0]);
            restOfLines();
            otherDigits();
            fillNumberList();
            classifyTheNumbers(parts[1]);
        }
        return sum;
    }

    private void mapLines(String stock){
        Map<Character, Integer> map = new HashMap<>(8);
        for(char ch : stock.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        //System.out.println(map.toString());
        _5 = map.toString().substring(map.toString().indexOf("=4") - 1, map.toString().indexOf("=4")).toCharArray()[0];
        _2 = map.toString().substring(map.toString().indexOf("=6") - 1, map.toString().indexOf("=6")).toCharArray()[0];
        _6 = map.toString().substring(map.toString().indexOf("=9") - 1, map.toString().indexOf("=9")).toCharArray()[0];
    }

    private void countLines(String stock) {
        String[] numbers = stock.split(" ");
        for (String s : numbers) {
            int ll = s.trim().length();
            char[] cArr = s.toCharArray();
            List chars = new LinkedList();
            for(char ch : cArr){
                chars.add(ch);
            }
            switch (ll){
                case 2: nr1 = new HashSet<>(chars); break;
                case 3: nr7 = new HashSet<>(chars); break;
                case 4: nr4 = new HashSet<>(chars); break;
                case 7: nr8 = new HashSet<>(chars); break;
                default:  break;
            }
        }
    }

    private void restOfLines(){
        Set<Character> m7 = new HashSet<>(nr7);
        Set<Character> m1 = new HashSet<>(nr1);
        Set<Character> m4 = new HashSet<>(nr4);
        Set<Character> m8 = new HashSet<>(nr8);
        m7.removeAll(m1);
        _1 = new ArrayList<>(m7).get(0);
        m1.remove(_6);
        _3 = new ArrayList<>(m1).get(0);
        m4.removeAll(nr1);
        m4.remove(_2);
        _4 = new ArrayList<>(m4).get(0);
        m8.removeAll(nr4);
        m8.remove(_1);
        m8.remove(_5);
        _7 = new ArrayList<>(m8).get(0);
        //System.out.println("1"+_1+"2"+_2+"3"+_3+"4"+_4+"5"+_5+"6"+_6+"7"+_7);
    }

    private void otherDigits(){
        nr2 = new HashSet<>(Set.of(_1,_3,_4,_5,_7));
        nr3 = new HashSet<>(Set.of(_1,_3,_4,_6,_7));
        nr5 = new HashSet<>(Set.of(_1,_2,_4,_6,_7));
        nr6 = new HashSet<>(Set.of(_1,_2,_4,_6,_7,_5));
        nr9 = new HashSet<>(nr8);
        nr9.remove(_5);
        nr0 = new HashSet<>(nr8);
        nr0.remove(_4);
    }

    private void fillNumberList(){
        numberList = new ArrayList<>(10);
        numberList.add(nr0);
        numberList.add(nr1);
        numberList.add(nr2);
        numberList.add(nr3);
        numberList.add(nr4);
        numberList.add(nr5);
        numberList.add(nr6);
        numberList.add(nr7);
        numberList.add(nr8);
        numberList.add(nr9);
    }

    private void classifyTheNumbers(String numbersStr){
        String[] numbers = numbersStr.trim().split(" ");
        //System.out.println("numbers"+ Arrays.toString(numbers));
        Set<Character> actualNr;
        StringBuilder sb = new StringBuilder();
        for(String s : numbers){
            actualNr = new HashSet<>();
            for (char c : s.trim().toCharArray()){
                actualNr.add(c);
                //System.out.println("char: "+ c);
            }
            for(int i = 0; i < numberList.size(); i++){
                if(actualNr.equals(numberList.get(i))){
                    sb.append(i);
                    //System.out.println("i: "+ i);
                }
            }
        }
        sum += Integer.parseInt(sb.toString().trim());
    }

}
