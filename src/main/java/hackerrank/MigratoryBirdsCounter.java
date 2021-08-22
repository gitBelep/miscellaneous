package hackerrank;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MigratoryBirdsCounter {

    public static int migratoryBirds(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return 0;

        Map<Integer, Integer> map = new TreeMap<>(); //bird id, how many times
        for(Integer i : arr){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i, map.get(i) + 1);
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > max){
                max = e.getValue();
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() == max){
                return e.getKey();
            }
        }
        return 0;
    }

}
