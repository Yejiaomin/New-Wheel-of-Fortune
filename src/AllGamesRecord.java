import java.util.*;

public class AllGamesRecord {
    private final List<GameRecord> list = new ArrayList<>();

    public void add(GameRecord gameRecord) {
        list.add(gameRecord);
    }

    public double average() {
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).score;
        }
        return sum / list.size();
    }

    public double average(String playerId) {
        double sum = 0;
        int times = 0;
        double averagrOfPlayer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).playerId.equals(playerId)) {
                    sum += list.get(i).score;
                    times++;
            }
        }
        averagrOfPlayer = sum/times;
        return averagrOfPlayer;
    }

    public List<GameRecord> highGameList(int n) {
        list.sort(Collections.reverseOrder());
        return list.subList(0, n);
    }

    public List<Integer> highGameList(String playerId, int n) {
        List<Integer> playerScorelist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).playerId.equals(playerId)) {
                playerScorelist.add(list.get(i).score);
                }
            }
        playerScorelist.sort(Collections.reverseOrder());
        return playerScorelist.subList(0,n);
    }

}
