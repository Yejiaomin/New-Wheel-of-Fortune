import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFortune{
    Scanner scanner = new Scanner(System.in);
    @Override
    char getGuess(String previousGuesses) {
        char guessCh = scanner.next().charAt(0);
        while (previousGuesses.indexOf(guessCh) >=0 || !Character.isLetter(guessCh)){
            if(!Character.isLetter(guessCh)){
                System.out.println("Your guess is not a letter.");
            }else{
                System.out.println("The guessed letter has been guessed, your previous guesses are:" + this.previousGuesses);
            }
            guessCh = scanner.next().charAt(0);
        }
        return guessCh;
    }

    @Override
    GameRecord play() {
        return super.play();
    }

    @Override
    boolean playNext() {
        if(!this.phraseList.isEmpty()) {
            System.out.println("Do you want to play next? 'y' or 'n'");
            char answer = scanner.next().charAt(0);
            return answer == 'y';
        }else {
            return false;
        }
    }

    public static void main(String [] args) {
        Game userGame = new WheelOfFortuneUserGame();
        AllGamesRecord record = userGame.playAll();
        System.out.println(record);  // or call specific functions of record
    }
}
