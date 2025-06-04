public class Game {

    public void guess(Object guessNum) {
        if (guessNum == null)
            throw new IllegalArgumentException();
    }
}
