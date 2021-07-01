package gyak;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MergeListsTest {
    List<Integer> a = List.of(1,2);
    List<Integer> b = List.of(6,7);
    List<Integer> c = List.of(1,4,7);
    List<Integer> d = List.of(0,2,3,9);
    List<Integer> e = List.of(1,2,33);
    List<Integer> f = List.of(1,2,33);

    @Test
    void mergeLists() {
        MergeLists m = new MergeLists();

        assertEquals(List.of(1,2,6,7), m.mergeLists(a,b));
        assertEquals(List.of(1,2,6,7), m.mergeLists(b,a));
        assertEquals(List.of(0,1,2,3,4,7,9), m.mergeLists(c,d));
        assertEquals(List.of(1,1,2,2,33,33), m.mergeLists(e,f));
    }

    @Test
    void mergeWithStreams(){
        MergeLists m = new MergeLists();

        assertEquals(List.of(1,2,6,7), m.mergeListsWithStream(a,b));
        assertEquals(List.of(1,2,6,7), m.mergeListsWithStream(b,a));
        assertEquals(List.of(0,1,2,3,4,7,9), m.mergeListsWithStream(c,d));
        assertEquals(List.of(1,1,2,2,33,33), m.mergeListsWithStream(e,f));
    }

}
