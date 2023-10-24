public class RandomPlayer implements WheelOfFortunePlayer{
    int randomNumber;
    @Override
    public char nextGuess() {
        randomNumber = (int) (Math.floor(Math.random()) * 26 + 1);
        char guessCh = (char) ('a'+randomNumber);
        return guessCh;
    }

    @Override
    public String playerId() {
        return null;
    }

    @Override
    public void reset() {

    }
}
