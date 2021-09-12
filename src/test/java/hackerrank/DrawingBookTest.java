package hackerrank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrawingBookTest {

    @Test
    void testPages(){
        DrawingBook book = new DrawingBook();
        assertEquals(1, book.minPages(6,9));
        assertEquals(1, book.minPages(7,9));
        assertEquals(1, book.minPages(2,9));
        assertEquals(1, book.minPages(3,9));
        assertEquals(2, book.minPages(4,9));
        assertEquals(2, book.minPages(5,9));
        assertEquals(0, book.minPages(1,9));
        assertEquals(0, book.minPages(8,9));
        assertEquals(0, book.minPages(9,9));

        assertEquals(1, book.minPages(6,8));
        assertEquals(1, book.minPages(7,8));
        assertEquals(1, book.minPages(2,8));
        assertEquals(1, book.minPages(3,8));
        assertEquals(2, book.minPages(4,8));
        assertEquals(2, book.minPages(5,8));
        assertEquals(0, book.minPages(1,8));
        assertEquals(0, book.minPages(8,8));
        assertEquals(0, book.minPages(9,8));

        assertEquals(0, book.minPages(48,49));
        assertEquals(1, book.minPages(2,49));
        assertEquals(6, book.minPages(13,49));
        assertEquals(6, book.minPages(12,49));
    }

}
