public class Game {

    public void guess(String guessNum) {
        if (guessNum == null)
            throw new IllegalArgumentException();

        if (guessNum.length() != 3)
            throw new IllegalArgumentException();
    }
}
