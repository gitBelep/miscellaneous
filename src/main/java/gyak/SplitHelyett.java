package gyak;

import java.util.ArrayList;
import java.util.List;
//String str = "alma,, szilva, \"kó,kusz\", ,banán ";
//4 értelmes Stringre vágnám: [alma, *nincs üres*   szilva,   \"kó,kusz\", *egyben*   banán]
//whitespace, üres vessző ne jelenjen meg

public class SplitHelyett {

    public List<String> felvagomVesszonel(String incomeString){
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean insideStatus = false;

        for (char ch : incomeString.toCharArray()){
            if (ch == '\"') {
                insideStatus = !insideStatus;
            }
            if (ch != ',' || insideStatus) {
                sb.append(ch);
            } else {
                if (!"".equals(sb.toString().strip())) {
//              if(sb.toString().trim().length() != 0){  //ez is jó
                    result.add(sb.toString().trim());
                }
                sb = new StringBuilder();
            }
        }
        if(sb.toString().trim().length() != 0){
            result.add(sb.toString().trim());
        }
//      for (String s : result){ System.out.println(s); }
        System.out.println(result);  //vizuálisan ell.
        return result;
    }

}
