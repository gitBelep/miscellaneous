package DailyCodingProblem;

import java.util.*;

public class StrReArrange {

    public String rearrange(String text){
        if( text == null || text.length() == 0 ){
            return null;
        }

        Map<Character, Integer> registry = countCharsInText( text );
        List< Map.Entry<Character, Integer> > regList = new ArrayList<>( registry.size() );
        regList.addAll(registry.entrySet());                                      //instead of iteration
        regList.sort((e1, e2) -> e2.getValue() - e1.getValue());                  //instead of Comparator

//        System.out.println("Leggyakoribb: "+ regList.get(0).getValue() +" db:"+ regList.get(0).getKey());
//        int u = regList.size() - 1;
//        System.out.println("Legritkább  : "+ regList.get(u).getValue() +" db:"+ regList.get(u).getKey());

        int maxAmount = text.length() % 2 == 0 ? text.length() / 2 : text.length() / 2 + 1;
        if ( regList.get(0).getValue() > maxAmount ) {                                         //impossible condition
            return null;
        }

        //beletenni
        char[] collector = new char[text.length()];
        int place = 0;
        boolean firstCall = true;
        for ( Map.Entry<Character, Integer> e : regList ){
            for ( int db = 1; db <= e.getValue(); db++ ){
                collector[place] = e.getKey();
//                System.out.println("place:"+ place +" db:"+ db +" value:"+ e.getValue() +"~key:"+ e.getKey());
                if (firstCall) {
                    if ( place < collector.length - 2 ) {
                        place += 2;
                    } else {
                        firstCall = false;
                        place = 1;
                    }
                } else if ( place < collector.length - 2 ) {
                    place += 2;
                } // else { end is reached }
            }
        }
        String result = new String( collector );
//        System.out.println(result);
        return result;
    }

    private Map<Character, Integer> countCharsInText(String txt){
        char[] chars = txt.toCharArray();
        Map<Character, Integer> registry = new HashMap<>();

        for( char c : chars ){
            if( !registry.containsKey(c) ){
                registry.put(c, 0);
            }
            registry.put( c, registry.get(c) + 1 );
        }
        return registry;
    }

}

//Given a string s, rearrange the characters so that any two adjacent characters are not the same.
// If this is not possible, return null.
//For example, if s = yyz then return yzy. If s = yyy then return null.