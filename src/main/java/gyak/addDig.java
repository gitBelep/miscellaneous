package gyak;
//Hozd létre az `AddDig` osztályt, és annak az `addDigits(String input)` metódusát.
//Feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja
//össze, és ennek az összegét adja vissza.
//Ha a bemeneti String üres, vagy `null`, adjon vissza `-1` értéket.

import java.util.Arrays;
import java.util.List;

public class addDig {
    public int addDigits(String input){
        if(input == null || "".equals(input)) return -1;
        return input.chars()
        .mapToObj(i -> (char) i )
        .filter(Character::isDigit)
        .reduce(0, (a,c) ->  a + Integer.parseInt(String.valueOf(c)), (s1,s2) ->  s1 + s2);
    }

}
