package DailyCodingProblem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DistinctSubstringTest {
    DistinctSubstring d = new DistinctSubstring();
    String str0 = null;
    String str1 = "";
    String str2 = "a";
    String str3 = "baaaa";
    String str4 = "baaaa..999";
    String str5 = "Aa bBBbBBBn";
    String str6 = "úúúllll88××××====?";
    String str7 = "aaabbabbaaabbaabbbbb";
    String str8 = "abcba";
    String str9 = "abcbccbba";


    @Test
    void findLongestSubstringWithMaxDstinctChars2() {
        assertEquals(5, d.findLongestSubstringWithMaxDstinctChars(2, str3));  //
        assertEquals(6, d.findLongestSubstringWithMaxDstinctChars(2, str4));  //
        assertEquals(7, d.findLongestSubstringWithMaxDstinctChars(2, str5));  //bBBbBBB
        assertEquals(3, d.findLongestSubstringWithMaxDstinctChars(2, str8));  //bcb
        assertEquals(7, d.findLongestSubstringWithMaxDstinctChars(2, str9));  //bcbccbb

        assertEquals(10, d.findLongestSubstringWithMaxDstinctChars(3, str6));  //4+2+4
        assertEquals(20, d.findLongestSubstringWithMaxDstinctChars(3, str7));   //2+2+5
    }

    @Test
    void findLongestSubstringWithMaxDstinctChars4() {
        assertEquals(9, d.findLongestSubstringWithMaxDstinctChars(4,str5));
        assertEquals(14, d.findLongestSubstringWithMaxDstinctChars(4,str6));
        assertEquals(20, d.findLongestSubstringWithMaxDstinctChars(4,str7));

        assertEquals(5, d.findLongestSubstringWithMaxDstinctChars(5, str8));//5
    }

    @Test
    void testEdgeCases(){
        assertThrows(IllegalArgumentException.class, () -> d.findLongestSubstringWithMaxDstinctChars(3,str0));
        assertThrows(IllegalArgumentException.class, () -> d.findLongestSubstringWithMaxDstinctChars(2,str1));
        assertThrows(IllegalArgumentException.class, () -> d.findLongestSubstringWithMaxDstinctChars(3,str2));

        assertThrows(IllegalArgumentException.class, () -> d.findLongestSubstringWithMaxDstinctChars(1,str5));
    }

}
