package gyak;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class First_non_RecurringCharacter {

    public char findFirtsRecurringChar(String str){
        Set<Character> characters = new HashSet<>();
        int lengthCounter = 0;
        char[] chars = str.toCharArray();
        for(char c : chars){
            characters.add(c);
            if(characters.size() - 1 != lengthCounter){
                return c;
            }
            lengthCounter++;
        }
        throw new IllegalArgumentException("There are no double characters");
    }

    public String findFirstNonRecurringChar(String str){
        Map<Character, Integer> characters = new LinkedHashMap<>();
        for(Character c : str.toCharArray()){
            if(!characters.containsKey(c)){
                characters.put(c, 0);
            }
            characters.put(c, characters.get(c) + 1);
        }
        for(Map.Entry<Character, Integer> e : characters.entrySet()){
            if(e.getValue() == 1){
                return e.getKey().toString();
            }
        }
        return "All characters are at least in pairs";
    }

}
