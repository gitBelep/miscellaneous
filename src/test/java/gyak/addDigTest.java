package gyak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class addDigTest {

    @Test
    void addDigits() {
        addDig a = new addDig();
        assertEquals(-1, a.addDigits( null));
        assertEquals(-1, a.addDigits(""));
        assertEquals(21, a.addDigits("j,:U6n1us7300.4"));
        assertEquals( 14, a.addDigits("-5-1-0kuK70k0001"));
    }

}
