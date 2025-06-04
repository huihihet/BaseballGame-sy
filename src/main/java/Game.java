public class Game {

    public String answer;

    public GuessResult guess(String guessNum) {
        assertIllegalArgument(guessNum);
        return getResult(guessNum);
    }

    private static void assertIllegalArgument(String guessNum) {
        isNull(guessNum);
        isThreeLength(guessNum);
        isNumber(guessNum);
        isDuplicateNumber(guessNum);
    }

    private static void isNull(String guessNum) {
        if (guessNum == null)
            throw new IllegalArgumentException();
    }

    private static void isThreeLength(String guessNum) {
        if (guessNum.length() != 3)
            throw new IllegalArgumentException();
    }

    private static void isNumber(String guessNum) {
        for (char c : guessNum.toCharArray())
            if (c < '0' || c > '9')
                throw new IllegalArgumentException();
    }

    private static void isDuplicateNumber(String guessNum) {
        if (isDupNum(guessNum))
            throw new IllegalArgumentException();
    }

    private static boolean isDupNum(String guessNum) {
        return guessNum.charAt(0) == guessNum.charAt(1) ||
                guessNum.charAt(1) == guessNum.charAt(2) ||
                guessNum.charAt(0) == guessNum.charAt(2);
    }

    private GuessResult getResult(String guess) {
        int strikes = 0;
        int balls = 0;
        char[] ansArr = answer.toCharArray();
        char[] guessArr = guess.toCharArray();
        for (int ansNum = 0; ansNum < 3; ansNum++) {
            char ansChar = ansArr[ansNum];
            for (int guessNum = 0; guessNum < 3; guessNum++) {
                char guessChar = guessArr[guessNum];
                if (ansChar == guessChar) {
                    if (ansNum == guessNum)
                        strikes++;
                    else
                        balls++;
                }
            }
        }
        return new GuessResult(isMatchedNumber(strikes, balls), strikes, balls);
    }

    private static boolean isMatchedNumber(int strikes, int balls) {
        return strikes == 3 && balls == 0;
    }
}
