package hackerrank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonAppetitTest {

    @Test
    void testBillDivision() {
        int[] items = {3, 10, 2, 9};
        var nonAnn = 1;
        var half1 = 12;
        var half2 = 7;

        String result1 = new BonAppetit().divideTheBill(items, nonAnn, half1);
        String result2 = new BonAppetit().divideTheBill(items, nonAnn, half2);

        assertEquals("5", result1);
        assertEquals("Bon Appetit", result2);
    }

}
