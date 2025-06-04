public class Game {

    public String question;

    public GuessResult guess(String guessNum) {
        assertIllegalArgument(guessNum);
        if (guessNum.equals(question))
            return new GuessResult(true, 3, 0);
        else
            return null;
    }

    private static void assertIllegalArgument(String guessNum) {
        if (guessNum == null)
            throw new IllegalArgumentException();

        if (guessNum.length() != 3)
            throw new IllegalArgumentException();

        for (char c : guessNum.toCharArray()) {
            if (c < '0' || c > '9')
                throw new IllegalArgumentException();
        }

        if (isDupNum(guessNum))
            throw new IllegalArgumentException();
    }

    private static boolean isDupNum(String guessNum) {
        return guessNum.charAt(0) == guessNum.charAt(1) ||
                guessNum.charAt(1) == guessNum.charAt(2) ||
                guessNum.charAt(0) == guessNum.charAt(2);
    }
}
