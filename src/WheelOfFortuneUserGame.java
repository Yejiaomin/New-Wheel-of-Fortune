import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFortune{
    @Override
    char getGuess(String previousGuesses) {
        Scanner scanner = new Scanner(System.in);
        char guessCh = scanner.next().charAt(0);
        if(Character.isLetter(guessCh)) {
            return guessCh;
        }else {
            System.out.println("Your inset is not a letter.");
        }
        return ' ';
    }

    @Override
    GameRecord play() {
        return super.play();
    }

    @Override
    boolean playNext() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play next? 'y' or 'n'");
        char answer = scanner.next().charAt(0);
        return answer == 'y';
    }

    public static void main(String [] args) {
        Game userGame = new WheelOfFortuneUserGame();
        AllGamesRecord record = userGame.playAll();
        System.out.println(record);  // or call specific functions of record
    }
}
