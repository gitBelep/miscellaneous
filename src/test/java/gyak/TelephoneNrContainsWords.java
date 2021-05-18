package gyak;

import java.util.ArrayList;
import java.util.List;

public class TelephoneNrContainsWords {

    public List<String> wichWordsAreInTheNumber(List<String> strings, String phoneNr) {
        List<String> result = new ArrayList<>();

        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'a' || c == 'b' || c == 'c' || c =='A' || c == 'B' || c == 'C') {
                    sb.append("2");
                }
                if ("defDEF".contains("" + c)) {
                    sb.append("3");
                }
                if ("ghi".contains( ("" + c).toLowerCase()) ) {
                    sb.append("4");
                }
                if ("jkl".contains("" + c)) {
                    sb.append("5");
                }
                if ("mno".contains("" + c)) {
                    sb.append("6");
                }
                if ("pqrs".contains("" + c)) {
                    sb.append("7");
                }
                if ("tuv".contains("" + c)) {
                    sb.append("8");
                }
                if ("wxyz".contains("" + c)) {
                    sb.append("9");
                }
            }
            if (phoneNr.contains(sb.toString())) {
                result.add(s);
            }
        }
        return result;
    }

}
