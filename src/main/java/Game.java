public class Game {

    public String question;

    public GuessResult guess(String guessNum) {
        assertIllegalArgument(guessNum);
        if (guessNum.equals(question))
            return new GuessResult(true, 3, 0);
        else
            return getUnmatchedResult(guessNum);
    }

    private GuessResult getUnmatchedResult(String guessNum) {
        int strikes = 0;
        int balls = 0;
        char[] ansArr = question.toCharArray();
        char[] guessArr = guessNum.toCharArray();
        for (int i = 0; i < 3; i++) {
            char ansChar = ansArr[i];
            for (int j = 0; j < 3; j++) {
                char guessChar = guessArr[j];
                if (ansChar == guessChar) {
                    if (i == j)
                        strikes++;
                    else
                        balls++;
                }
            }
        }
        return new GuessResult(false, strikes, balls);
    }

    private static void assertIllegalArgument(String guessNum) {
        if (guessNum == null)
            throw new IllegalArgumentException();

        if (guessNum.length() != 3)
            throw new IllegalArgumentException();

        for (char c : guessNum.toCharArray())
            if (c < '0' || c > '9')
                throw new IllegalArgumentException();

        if (isDupNum(guessNum))
            throw new IllegalArgumentException();
    }

    private static boolean isDupNum(String guessNum) {
        return guessNum.charAt(0) == guessNum.charAt(1) ||
                guessNum.charAt(1) == guessNum.charAt(2) ||
                guessNum.charAt(0) == guessNum.charAt(2);
    }
}
