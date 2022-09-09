package DailyCodingProblem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrReArrangeTest {
    StrReArrange r = new StrReArrange();

    @Test
    void rearrangeNormalS() {
        assertEquals("ababa", r.rearrange("bbaaa") );
        assertEquals("abab", r.rearrange("bbaa") );
        assertEquals("cacac", r.rearrange("cccaa") );
        assertEquals("a", r.rearrange("a") );
    }

    @Test
    void rearrangeNormalL() {
        assertEquals("cacacackc", r.rearrange("kcccaacca") );
        assertEquals("aca8c8", r.rearrange("cc88aa") );
        assertEquals("asatálbmro", r.rearrange("alabástrom") );
    }

    @Test
    void rearrangeNull() {
        assertNull(r.rearrange("bbb"));
        assertNull(r.rearrange("bb"));
        assertNull(r.rearrange("0bbbb0"));
        assertNull(r.rearrange(""));
        assertNull(r.rearrange(null));
    }

    @Test
    void rearrangeSpezial() {
        assertEquals("űéűéű", r.rearrange("ééűűű") );
        assertEquals("űéűé", r.rearrange("ééűű") );
        assertEquals("éűéűé", r.rearrange("űűééé") );
        assertEquals(" % % ", r.rearrange("%   %"));       //3 x space
        assertEquals("% % %", r.rearrange(" %%% "));       //2 x space
    }

}
