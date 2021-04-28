package hackerrank;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {

    public static void main(String[] args) {

        double payment = 12345.134;
        Locale indiaLocale = new Locale("en", "IN");

        String us     = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india  = NumberFormat.getCurrencyInstance(indiaLocale).format(payment);
        String china  = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: "     + us);
        System.out.println("India: "  + india);
        System.out.println("China: "  + china);
        System.out.println("France: " + france);
    }
}
