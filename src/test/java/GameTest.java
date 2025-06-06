import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void throwIllegalArgumentException() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    private void generateQuestion(String num) {
        game.answer = num;
    }

    @Test
    void returnMatchedNum() {
        generateQuestion("123");
        assertMatchedNum(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnUnmatchedNum() {
        generateQuestion("123");
        assertMatchedNum(game.guess("456"), false, 0, 0);
        assertMatchedNum(game.guess("345"), false, 0, 1);
        assertMatchedNum(game.guess("234"), false, 0, 2);
        assertMatchedNum(game.guess("145"), false, 1, 0);
        assertMatchedNum(game.guess("134"), false, 1, 1);
        assertMatchedNum(game.guess("132"), false, 1, 2);
        assertMatchedNum(game.guess("124"), false, 2, 0);
    }

    private static void assertMatchedNum(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }
}