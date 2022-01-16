package advent;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class A21DiracDiceTest {

    @Test
    void playGivenTest() {
        A21DiracDice game = new A21DiracDice();
        assertEquals(739785, game.play(4, 8, 1000, 100));  //745 * (??) 993
    }

    @Test
    void play() {
        A21DiracDice game = new A21DiracDice();
        assertEquals(711480, game.play(5, 10, 1000, 100));
    }


}
