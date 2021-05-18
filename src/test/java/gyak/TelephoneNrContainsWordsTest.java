package gyak;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneNrContainsWordsTest {

    @Test
    void wichWordsAreInTheNumber() {
        TelephoneNrContainsWords t = new TelephoneNrContainsWords();
        List<String> result = t.wichWordsAreInTheNumber(
                List.of("foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"),
        "3662277");
        System.out.println(result);
//        assertEquals("");
    }
}