public class Game {

    public void guess(String guessNum) {
        if (guessNum == null)
            throw new IllegalArgumentException();

        if (guessNum.length() != 3)
            throw new IllegalArgumentException();

        for (char c : guessNum.toCharArray()){
            if (c < '0' || c > '9')
                throw new IllegalArgumentException();
        }

        if (guessNum.charAt(0) == guessNum.charAt(1) ||
                guessNum.charAt(1) == guessNum.charAt(2) ||
                guessNum.charAt(0) == guessNum.charAt(2)){
            throw new IllegalArgumentException();
        }
    }
}
