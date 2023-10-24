import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class WheelOfFortune extends Game {
    public String phrase;
    public StringBuilder hiddenPhrase;
    public String previousGuesses;

    public String randomPhrase() {
        List<String> phraseList = null;
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }
        // Get a random phrase from the list
        Random rand = new Random();
        int r = rand.nextInt(3); // gets 0, 1, or 2
        String phrase = phraseList.get(r).toLowerCase();
        return phrase;
    }

    public void generateHiddenPhrase() {
        this.hiddenPhrase = new StringBuilder(this.phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)) {
                hiddenPhrase.setCharAt(i, '*');
            }
        }
    }

    abstract char getGuess(String previousGuesses);

    public GameRecord processGuess() {
        this.phrase = randomPhrase();
        this.generateHiddenPhrase();
        int n = 10;
        while (n > 0) {
            System.out.println("Enter a guess character.");
            char guessCh = getGuess(previousGuesses);
            if (phrase.contentEquals(this.hiddenPhrase)) {
                return new GameRecord((10-n)*100,"Amy");
            } else {
                guessCh = Character.toLowerCase(guessCh);
                if(this.previousGuesses.indexOf(guessCh) != -1){
                    System.out.println("The guessed letter has been guessed, your previous missed guesses are:" + this.previousGuesses);
                } else if(phrase.indexOf(guessCh) != -1){
                    for(int i = 0; i < phrase.length(); i++){
                        if(guessCh == phrase.charAt(i)){
                            this.hiddenPhrase.setCharAt(i, guessCh);
                        }
                    }
                    System.out.println("Guess right! The updated phrase is: " + this.hiddenPhrase);
                }else{
                    this.previousGuesses += guessCh;
                    n--;
                    System.out.println("The guessed letter does not occur in the phrase, you only have " + n + " chances");
                    System.out.println("your previous missed guesses are: " + this.previousGuesses + ". You have missed " + this.previousGuesses.length() + " times");
                }
            }
        }
        return new GameRecord(0,"Amy");
    }

    @Override
    GameRecord play() {
        return processGuess();
    }

    @Override
    boolean playNext() {
        return false;
    }
}
