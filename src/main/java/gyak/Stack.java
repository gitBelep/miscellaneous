package gyak;

import java.util.*;

public class Stack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int before = s.length();
            do {
                before = s.length();
                s = s.replace("()", "");
                s = s.replace("[]", "");
                s = s.replace("{}", "");
            } while(s.length() < before);
            System.out.println( s.length() == 0 );
        }
        //List<Number> list1 = new ArrayList<Integer>(); // Nem fordul le!
        List<Number> list2 = new ArrayList<Number>();  // Lefordul
        list2.add(Integer.valueOf(2));                // Lefordul, az elem lehet bármi, ami Number
        List  list = new ArrayList();  //        ebbe bármely objektum belemegy

        List<String> ls = new ArrayList<>();
        List<Object> lo = new ArrayList<>();
      //  ls = lo;
      //  lo = ls;//Object lista helyére nem tehetek leszármazottnak listáját sem. Fordítva sem megy.
        lo.add(ls); //az megy, az más.

        Collection<String> cs = ls;  //ez OK (ha ugyanolyan típusokat fogad), mert a Collection a List őse.
        Collection<Object> cr = lo;
      //  Collection<Object> co = ls;  //sem megy.

    }



}
