import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class WheelOfFortune extends Game {
    private String phrase;
    private StringBuilder hiddenPhrase;
    protected String previousGuesses;
    protected List<String> phraseList ;

    public WheelOfFortune() {
        phraseList = this.getPhraseList();
        previousGuesses = "";
    }

    private List<String> getPhraseList(){
        List<String> phraseList = null;
        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
            // Get a random phrase from the list
        } catch (IOException e) {
            phraseList = new ArrayList<>();
            System.out.println(e);
        }
        return phraseList;
    }

    public String randomPhrase() {
            // Get a random phrase from the list
            Random rand = new Random();
            int r = rand.nextInt(phraseList.size()); // gets 0, 1, or 2
        System.out.println("r:"+r);
            phrase = phraseList.get(r);
            phraseList.remove(phrase);
        return phrase.toLowerCase();
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
        this.phrase = this.randomPhrase();
        this.generateHiddenPhrase();
        int n = 10;
        while (n > 0) {
            System.out.println("Enter a guess character.");
            char guessCh = getGuess(previousGuesses);
            this.previousGuesses += guessCh;
                guessCh = Character.toLowerCase(guessCh);
                 if(phrase.indexOf(guessCh) >= 0){
                    for(int i = 0; i < phrase.length(); i++){
                        if(guessCh == phrase.charAt(i)){
                            this.hiddenPhrase.setCharAt(i, guessCh);
                        }
                    }
                    System.out.println("Guess right! The updated phrase is: " + this.hiddenPhrase);
                     if (phrase.contentEquals(this.hiddenPhrase)) {
                         return new GameRecord((10-n)*100,"Amy");
                     }
                }else{
                    n--;
                    System.out.println("The guessed letter does not occur in the phrase, you only have " + n + " chances");
                    System.out.println("your previous guesses are: " + this.previousGuesses);
                }
            }

        return new GameRecord(0,"Amy");
    }

    @Override
    GameRecord play() {
        if(this.phraseList.isEmpty()){
            System.out.println("No phrase available for playing");
        }
        GameRecord gameRecord =  this.processGuess();
        this.reset();
        return gameRecord;

    }

    @Override
    boolean playNext() {
        return false;
    }

    private void reset(){
        phrase = "";
        hiddenPhrase = new StringBuilder();
        previousGuesses = "";
    }
}
