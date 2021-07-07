package DailyCodingProblem;
//Given an integer k and a string s, find the length of the longest substring
// that contains at most k distinct characters.
//For example, given s = "abcba" and k = 2,
// the longest substring with k distinct characters is "bcb" -> 3.
import java.util.HashMap;
import java.util.Map;

public class DistinctSubstring {

    public int findLongestSubstringWithMaxDstinctChars(int n, String s) {
        checkData(n, s);

        Map<Character, Integer> charMap;
        char[] chars = s.toCharArray();
        int counter;
        int max = 0;

        for (int first = 0; first < s.length() - n + 1; first++) {
            charMap = new HashMap<>();
            counter = 0;

            for (int i = first; i < s.length(); i++) {
                if (charMap.size() < n ) {
                    if (!charMap.containsKey(chars[i])) {
                        charMap.put(chars[i], 0);
                    }
                    charMap.put(chars[i], charMap.get(chars[i]) + 1);
                    counter++;
                } else{
                    if (!charMap.containsKey(chars[i])) {
                        i = s.length();
                    } else {
                        charMap.put(chars[i], charMap.get(chars[i]) + 1);
                        counter++;
                    }
                }
            }

            if (max < counter) {
                max = counter;
            }
        }
        System.out.println("Text: "+ s +"\n"+ n + " féle charactert tartalmazó substring max hossza: "+ max);
        return max;
    }

    private void checkData(int n, String s) {
        if (s == null || s.length() < 2) {
            throw new IllegalArgumentException("Text is too short!");
        }
        if (n < 2 || 1000 < n) {
            throw new IllegalArgumentException("Number of distinct characters should be between 2 & 1000!");
        }
        if (s.length() < n) {
            throw new IllegalArgumentException("Number of distinct characters cannot be more than characters in text!");
        }
    }

}
