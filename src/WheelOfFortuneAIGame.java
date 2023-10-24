import java.util.Scanner;

public class WheelOfFortuneAIGame extends WheelOfFortune{
    WheelOfFortunePlayer player;
    @Override
    char getGuess(String previousGuesses) {
        return player.nextGuess();
    }

    public WheelOfFortuneAIGame() {
    }

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
