package gyak;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private int prefix;
    private int telNr;
    private int number;

    private static int COUNTER = 0;
    private static List<Phone> phones = new ArrayList<>();

    public Phone(String ph) {
        int telszam2X = -1;
        String kiir = "";
        try {
            ell(ph);
            String[] pp = ph.trim().split("-");
            prefix = Integer.parseInt( pp[0] );
            telNr = Integer.parseInt( pp[1] );
            telszam2X = telNr * 2;
        } catch (IllegalArgumentException iae){
            kiir = iae.getMessage();
            telszam2X = 0;
        } finally {
            System.out.print(COUNTER++ +" "+ kiir);
            if(telszam2X > 0) {
                System.out.print("telszam2x= " + telszam2X);
            }
                System.out.println();
            number = COUNTER;
            phones.add(this);
        }
    }

    private void ell(String pho){
        if(pho == null ){
            throw new IllegalArgumentException("Null String: null");
        }
        String ph = pho.trim();
        if("".equals(ph) ){
            throw new IllegalArgumentException("Üres String: \" \"");
        }
        if(ph.indexOf("-") <= 1 || ph.indexOf("-") > ph.length()-3){
            throw new IllegalArgumentException("kötőjel rossz helyen: "+ ph);
        }
        for(Character c : ph.toCharArray()){
            if(!Character.isDigit(c) && !c.equals('-')){
                throw new IllegalArgumentException("Nem telefonszám: "+ ph);
            }
        }
    }

    @Override
    public String toString() {
        return " sorszam=" + number +" "+ prefix +" "+ telNr;
    }

    public static void main(String[] args) {
        Phone p0 = new Phone(null);
        Phone p1 = new Phone("234-232323");
        Phone p2 = new Phone("  ");
        Phone p3 = new Phone("23-2");
        Phone p4 = new Phone("2-23232323");
        Phone p5 = new Phone("23-232AA3");

        System.out.println(phones.toString());
    }

}
