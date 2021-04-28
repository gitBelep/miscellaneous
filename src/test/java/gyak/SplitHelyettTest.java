package gyak;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitHelyettTest {

    @Test
    void felvagomVesszonel() {
        SplitHelyett sp = new SplitHelyett();

        String str1 = "alma,, szilva, \"kó,kusz\",, ,   banán";
        List<String> result1 = sp.felvagomVesszonel(str1);

        assertEquals(4, result1.size());
        assertEquals("[alma, szilva, \"kó,kusz\", banán]", result1.toString());


        String str2 = " x x x ,s, \"a,b,c,d\"  ,  \n  ,    ,";
        List<String> result2 = sp.felvagomVesszonel(str2);

        assertEquals(3, result2.size());
        assertEquals(Arrays.asList("x x x","s", "\"a,b,c,d\""), result2);
    }
}