package com.vdc;

/**
 * Created by Vincent on 09/01/2018.
 */
public class GameScore {

    public static final String DEUCE = "DEUCE";

    private Player player1;
    private Player player2;
    private GamePoints gamePoints1;
    private GamePoints gamePoints2;

    public GameScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gamePoints1 = GamePoints.ZERO;
        this.gamePoints2 = GamePoints.ZERO;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GamePoints getGamePoints1() {
        return gamePoints1;
    }

    public GamePoints getGamePoints2() {
        return gamePoints2;
    }

    public boolean player1WonAPoint() {
        gamePoints1 = nextWinnerPoints(gamePoints1, gamePoints2);
        gamePoints2 = nextLooserPoints(gamePoints2);
        return hasSomeoneWonTheGame();
    }

    public boolean player2WonAPoint() {
        gamePoints2 = nextWinnerPoints(gamePoints2, gamePoints1);
        gamePoints1 = nextLooserPoints(gamePoints1);
        return hasSomeoneWonTheGame();
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

    public String getPrettyPrintScore() {
        String score = player1.getName() + "-" + player2.getName() + " : ";
        if (gamePoints1 == GamePoints.FOURTEEN && gamePoints2 == GamePoints.FOURTEEN) {
            score += DEUCE;
        } else {
            score += gamePoints1.getText() + "-" + gamePoints2.getText();
        }
        return score;
    }

    public boolean hasSomeoneWonTheGame() {
        return andTheGameWinnerIs() != null;
    }

    public Player andTheGameWinnerIs() {
        if (gamePoints1 == GamePoints.GAME) {
            return player1;
        } else if (gamePoints2 == GamePoints.GAME) {
            return player2;
        } else {
            return null;
        }
    }

    // only useful for test
    void setGamePoints1(GamePoints gamePoints) {
        gamePoints1 = gamePoints;
    }

    void setGamePoints2(GamePoints gamePoints) {
        gamePoints2 = gamePoints;
    }

}
