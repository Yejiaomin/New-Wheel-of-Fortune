public class FrequencyPlayer implements WheelOfFortunePlayer{
    String frequencyLetterOrder = "etaonrishdlfcmugypwbvkjxzq";
    int index = 0;
    @Override
    public char nextGuess() {
        char guessCh = frequencyLetterOrder.charAt(index);
        return guessCh;
    }

    @Override
    public String playerId() {
        return null;
    }

    @Override
    public void reset() {
        index = 0;
    }
}
