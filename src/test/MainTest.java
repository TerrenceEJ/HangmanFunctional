import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MainTest {
    Board board = new Board();
    Score score = new Score();

    public MainTest() throws IOException {
    }//testing string and characters

    @Test
    void testChar(){
        char c = 5;
        board.setLetterBank(board.getLetterBank(), c);
        assertTrue(board.getLetterBank().contains(c));
    }

    @Test
    void testScore(){
        System.out.println(score.SB);
    }
}
