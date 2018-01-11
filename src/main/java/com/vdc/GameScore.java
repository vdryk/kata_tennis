package com.vdc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by Vincent on 09/01/2018.
 */
public class GameScore {

    public static final String DEUCE = "DEUCE";

    private Map<Player, GamePoints> pointsByPlayer;

    public GameScore(Player player1, Player player2) {
        this.pointsByPlayer = new HashMap<Player, GamePoints>();
        this.pointsByPlayer.put(player1, GamePoints.ZERO);
        this.pointsByPlayer.put(player2, GamePoints.ZERO);
    }

    public boolean addOnePointToPlayer(Player winner) {
        GamePoints winnerPoints = pointsByPlayer.get(winner);
        Player looser = getLooser(winner);
        GamePoints looserPoints = pointsByPlayer.get(looser);

        winnerPoints = nextWinnerPoints(winnerPoints, looserPoints);
        looserPoints = nextLooserPoints(looserPoints);

        pointsByPlayer.put(winner, winnerPoints);
        pointsByPlayer.put(looser, looserPoints);

        return hasSomeoneWonTheGame();
    }

    private Player getLooser(Player winner) {
        return pointsByPlayer.keySet().stream()
                .filter(player -> !player.equals(winner))
                .findFirst().get();
    }

    /**
     * @param winnerGamePoints
     * @param looserGamePoints
     * @return
     */
    private GamePoints nextWinnerPoints(GamePoints winnerGamePoints, GamePoints looserGamePoints) {
        switch (winnerGamePoints) {
            case ZERO:
                return GamePoints.FIFTEEN;
            case FIFTEEN:
                return GamePoints.THIRTEEN;
            case THIRTEEN:
                return GamePoints.FOURTEEN;
            case FOURTEEN:
                switch (looserGamePoints) {
                    case FOURTEEN:
                        return GamePoints.ADVANTAGE;
                    case ADVANTAGE:
                        return GamePoints.FOURTEEN;
                    default:
                        return GamePoints.GAME;
                }
            case ADVANTAGE:
                return GamePoints.GAME;
            default:
                throw new IllegalStateException("The score " + winnerGamePoints + " does not have next");
        }
    }

    /**
     * @param looserGamePoints
     * @return
     */
    private GamePoints nextLooserPoints(GamePoints looserGamePoints) {
        return looserGamePoints == GamePoints.ADVANTAGE ? GamePoints.FOURTEEN : looserGamePoints;
    }

    public Map<Player, GamePoints> getPointsByPlayer() {
        return pointsByPlayer;
    }

    private boolean isDeuce() {
        return pointsByPlayer.values().stream()
                .allMatch(gamePoints -> gamePoints == GamePoints.FOURTEEN);
    }

    public boolean hasSomeoneWonTheGame() {
        return pointsByPlayer.values().contains(GamePoints.GAME);
    }

    // only useful for test
    void setGamePoints(Player player, GamePoints gamePoints) {
        pointsByPlayer.put(player, gamePoints);
    }

}
