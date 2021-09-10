package gyak;
/* Challenge: U'll get some digits in an int[] array. U could make many Integer numbers from them.
Make a number from them as they are given in the array, and return the next greater variant.
If U are given the greatest variant, return the smallest variant.   */

import java.util.ArrayList;
import java.util.List;

public class OneGreater {

    public int getOneGreater(int[] arr) {
        List<Integer> ground = changeToList(arr);
        int i;
        for (i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                int smaller = arr[i - 1];
                List<Integer> right = new ArrayList<>(arr.length - i + 1);
                for (int z = i - 1; z < arr.length; z++) {
                    right.add(arr[z]);
                }
                right.sort(null);
                int nextBiggerNumber = right.remove(right.lastIndexOf(smaller) + 1);
                ground.set(i - 1, nextBiggerNumber);

                int s = 0;
                for (; i < arr.length; i++) {
                    ground.set(i, right.get(s));
                    s++;
                }
                break;
            }
        }

        if (i == 0) {
            ground.sort(null);
//          System.out.println("Result: " + ground);
            return makeNumberFromList(ground);
        }

//      System.out.println("Result: " + ground);
        return makeNumberFromList(ground);
    }

    private List<Integer> changeToList(int[] a) {
        List<Integer> result = new ArrayList<>(a.length);
        for (int i : a) {
            result.add(i);
        }
        return result;
    }

    private int makeNumberFromList(List<Integer> list){
        StringBuilder sb = new StringBuilder(list.size());
        for(int i : list){
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

}
/* MEGOLDÁS: Hátulról nézegetem a jegyeket. Ha a balra lévő nagyobb, megyek előrébb.
Ha elfogynak, ez a legnagyobb kirakható szám. Ha találok kisebbet, akkor annak a helyére
jön a nagyságban következő számjegy, mögötte minden növekvő sorrendbe kerül.   */
