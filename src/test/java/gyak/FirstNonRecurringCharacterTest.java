package gyak;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FirstNonRecurringCharacterTest {

    @Test
    public void testFindFirtsRecurringChar() {
        First_non_RecurringCharacter f = new First_non_RecurringCharacter();

        char catched = f.findFirtsRecurringChar("ab3x/áŐűAB4XÁ _bab3xáŐűAB4XÁ");
        assertEquals('b', catched);

        assertThrows(IllegalArgumentException.class,  () -> f.findFirtsRecurringChar("aÁAqwertT"));
    }

    @Test
    public void testFindFirstNoneRecurringChar(){
        First_non_RecurringCharacter f = new First_non_RecurringCharacter();

        String catched1 = f.findFirstNonRecurringChar("ab3x/áŐűAB4XÁ _ab993ab3x/áŐűAB4XÁ _7779");
        assertEquals("All characters are at least in pairs", catched1);

        String catched2 = f.findFirstNonRecurringChar("ab3x/áŐűAB4XÁ _ab993ab3x/á-Z-Őű-U-AB-W-4XÁ _7779");
        assertEquals("Z", catched2);   //Z U W
    }
}