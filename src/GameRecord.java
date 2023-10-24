import java.util.ArrayList;
import java.util.List;

public class GameRecord implements Comparable<GameRecord>{
    int score;
    String playerId;
    List<Integer> playerScoreList = new ArrayList<>();
    public GameRecord(int score, String playerId){
        this.score = score;
        this.playerId = playerId;
        playerScoreList.add(score);
    }

    @Override
    public int compareTo(GameRecord o) {
        return Integer.compare(this.score, o.score);
    }
}
