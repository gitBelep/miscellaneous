package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class A14Polymer {
    //List<Character> polymer = new LinkedList<>();         //after 12 iterations slows down and dies
    Map<List<Character>, Character> rules = new HashMap<>();
    Map<List<Character>, Long> relations = new LinkedHashMap<>();
    char lastChar;

    public Long go(Path path, int round) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            readPolymerRelationsAndRules(br);
            for (int i = 0; i < round; i++) {
                insertRelations();
                //System.out.println(i +": "+ relations);
            }
            return substract();
        } catch (IOException e) {
            System.out.println(" |==0O> o-:E ..< áá@ÁÁ! > /n" + e.getMessage());
        }
        return -1L;
    }

    private void readPolymerRelationsAndRules(BufferedReader br) throws IOException {
        String line = br.readLine();
        lastChar = line.charAt(line.length()-1);
        char[] ground = line.toCharArray();              //ground polymer
        List<Character> key;
        for (int k = 1; k < ground.length; k++) {
            key = List.of(ground[k - 1], ground[k]);
            if (!relations.containsKey(key)) {
                relations.put(key, 0L);
            }
            relations.put(key, relations.get(key) + 1);
            //System.out.println(key +" key: "+ relations.get(key));//oK
        }
        br.readLine();                              //empty line

        while ((line = br.readLine()) != null) {    //listing the rules
            String[] part = line.split(" ");
            char neighbour1 = part[0].toCharArray()[0];
            char neighbour2 = part[0].toCharArray()[1];
            char newNeighbour = part[2].toCharArray()[0];
            rules.put(List.of(neighbour1, neighbour2), newNeighbour);
                                                    //collect all kind of relations
            if( !relations.containsKey(List.of(neighbour1,neighbour2))){
                relations.put(List.of(neighbour1, neighbour2), 0L);
            }                                       //all kind of relations for inserting new ones
            if( !relations.containsKey(List.of('X',neighbour1,neighbour2))){
                relations.put(List.of('X',neighbour1, neighbour2), 0L);
            }
        }
    }

    private void insertRelations() {                                         //NN~C  ==> NC + CN
        long value1;
        long value2;
        for (List<Character> cl : relations.keySet()) {                       //NN
            if (cl.size() == 2) {
                char insertChar = rules.get(cl);                              //C
                value1 = relations.get( List.of('X', cl.get(0), insertChar) ) + relations.get(cl);
                value2 = relations.get( List.of('X', insertChar, cl.get(1)) ) + relations.get(cl);
                relations.put(cl, 0L);                                        //NN=0
                relations.put(List.of('X', cl.get(0), insertChar), value1);    //XNC =1
                relations.put(List.of('X', insertChar, cl.get(1)), value2);    //XCN =1
            }
        }
        for (List<Character> cl : relations.keySet()) {                       //NC = XNC
            if (cl.size() == 3) {
                relations.put( List.of(cl.get(1), cl.get(2)), relations.get(cl)); //NC =1
                relations.put(cl, 0L);                                          //XNC =0
            }
        }
    }

    private long substract() {
        Map<Character, Long> sum = new HashMap<>();                 //list of chars
        for (Map.Entry<List<Character>, Character> e : rules.entrySet()) {
            if(!sum.containsKey(e.getValue())){
                sum.put(e.getValue(), 0L);
            }
        }
        for (Map.Entry<List<Character>, Long> e : relations.entrySet()) {  //count chars except last
            char actualChar = e.getKey().get(0);
            if(e.getKey().size() == 2 && actualChar != lastChar) {
                sum.put(actualChar, sum.get(actualChar) + e.getValue());
            }
        }
        for (Map.Entry<List<Character>, Long> e : relations.entrySet()) {  //count last char
            char actualChar = e.getKey().get(1);
            if(e.getKey().size() == 2 && actualChar == lastChar) {
                sum.put(lastChar, sum.get(lastChar) + e.getValue());
            }
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(char c : sum.keySet()){
            if(sum.get(c) > max) max = sum.get(c);
            if(sum.get(c) < min) min = sum.get(c);
        }
        System.out.println("max: "+ max +"; min: "+ min);
        return max - min;
    }

}
//    private void insertAtoms() {              //Did not work over 12 iteration..
//        List<Character> newpolymer = new LinkedList<>();
//        for (int i = 1; i < polymer.size(); i++) {
//            newpolymer.add(polymer.get(i - 1));
//            if (rules.containsKey(List.of(polymer.get(i - 1), polymer.get(i)))) {
//                newpolymer.add(rules.get(List.of(polymer.get(i - 1), polymer.get(i))));
//            }
//        }
//        newpolymer.add(polymer.get(polymer.size() - 1));
//        polymer = newpolymer;
//    }

//The incredible pressures at this depth are starting to put a strain on your submarine. The submarine has polymerization
// equipment that would produce suitable materials to reinforce the submarine, and the nearby volcanically-active caves
// should even have the necessary input elements in sufficient quantities.
//The submarine manual contains instructions for finding the optimal polymer formula; specifically, it offers a polymer
// template and a list of pair insertion rules (your puzzle input). You just need to work out what polymer would result
// after repeating the pair insertion process a few times.
//For example:
//NNCB
//
//CH -> B
//HH -> N
//CB -> H
//NH -> C
//HB -> C
//HC -> B
//HN -> C
//NN -> C
//BH -> H
//NC -> B
//NB -> B
//BN -> B
//BB -> N
//BC -> B
//CC -> N
//CN -> C
//The first line is the polymer template - this is the starting point of the process.
//The following section defines the pair insertion rules. A rule like AB -> C means that when elements A and B are
// immediately adjacent, element C should be inserted between them. These insertions all happen simultaneously.
//So, starting with the polymer template NNCB, the first step simultaneously considers all three pairs:
//The first pair (NN) matches the rule NN -> C, so element C is inserted between the first N and the second N.
//The second pair (NC) matches the rule NC -> B, so element B is inserted between the N and the C.
//The third pair (CB) matches the rule CB -> H, so element H is inserted between the C and the B.
//Note that these pairs overlap: the second element of one pair is the first element of the next pair. Also, because
// all pairs are considered simultaneously, inserted elements are not considered to be part of a pair until the next step.
//After the first step of this process, the polymer becomes NCNBCHB.
//Here are the results of a few steps using the above rules:
//Template:     NNCB
//After step 1: NCNBCHB
//After step 2: NBCCNBBBCBHCB
//After step 3: NBBBCNCCNBBNBNBBCHBHHBCHB
//After step 4: NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB
//This polymer grows quickly. After step 5, it has length 97; After step 10, it has length 3073. After step 10,
// B occurs 1749 times, C occurs 298 times, H occurs 161 times, and N occurs 865 times; taking the quantity of the
//most common element (B, 1749) and subtracting the quantity of the least common element (H, 161) produces 1749 - 161 = 1588.
//Apply 10 steps of pair insertion to the polymer template and find the most and least common elements in the result.
// What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?
//
//Your puzzle answer was 2584.
//--- Part Two ---
//The resulting polymer isn't nearly strong enough to reinforce the submarine. You'll need to run more steps of the pair
// insertion process; a total of 40 steps should do it.
//In the above example, the most common element is B (occurring 2192039569602 times) and the least common element
// is H (occurring 3849876073 times); subtracting these produces 2188189693529.
//Apply 40 steps of pair insertion to the polymer template and find the most and least common elements in the result.
//What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?
