package hackerrank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgrammerDayTest {

    @Test
    void testDate(){
        assertEquals("12.09.2000", ProgrammerDay.dayOfProgrammer(2000));
        assertEquals("13.09.2100", ProgrammerDay.dayOfProgrammer(2100));
        assertEquals("13.09.2001", ProgrammerDay.dayOfProgrammer(2001));
        assertEquals("12.09.2016", ProgrammerDay.dayOfProgrammer(2016));

        assertEquals("26.09.1918", ProgrammerDay.dayOfProgrammer(1918));

        assertEquals("12.09.1916", ProgrammerDay.dayOfProgrammer(1916));
        assertEquals("13.09.1915", ProgrammerDay.dayOfProgrammer(1915));
        assertEquals("12.09.1600", ProgrammerDay.dayOfProgrammer(1600));
    }

}
