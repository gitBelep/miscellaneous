package gyak;

import org.junit.jupiter.api.Test;

class SodokuTest {
//256 ms for building 20 boards  ~  13 ms/board

    @Test
    void testBuildSodokus(){
        Sodoku sodoku = new Sodoku();
        for(int eger = 1; eger <= 20; eger++){
            sodoku.buildSodokuBoard();
        }
    }

}
