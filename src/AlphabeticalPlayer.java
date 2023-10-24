public class AlphabeticalPlayer implements WheelOfFortunePlayer{
    int index;
    @Override
    public char nextGuess() {

        char guessCh = (char) ('a'+index);
        index++;
        return guessCh;
    }

    @Override
    public String playerId() {
        return "AlphabeticalOrder player";
    }
    @Override
    public void reset() {
        index = 0;
    }
}
