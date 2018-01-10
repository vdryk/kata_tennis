package com.vdc;

/**
 * Created by Vincent on 09/01/2018.
 */
public class Game {

    public static final String DEUCE = "DEUCE";

    private Player player1;
    private Player player2;
    private Points points1;
    private Points points2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.points1 = Points.ZERO;
        this.points2 = Points.ZERO;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Points getPoints1() {
        return points1;
    }

    public Points getPoints2() {
        return points2;
    }

    public void player1WonAPoint() {
        points1 = nextWinnerPoints(points1, points2);
        points2 = nextLooserPoints(points2);
    }

    public void player2WonAPoint() {
        points2 = nextWinnerPoints(points2, points1);
        points1 = nextLooserPoints(points1);
    }

    /**
     * @param winnerPoints
     * @param looserPoints
     * @return
     */
    private Points nextWinnerPoints(Points winnerPoints, Points looserPoints) {
        switch (winnerPoints) {
            case ZERO:
                return Points.FIFTEEN;
            case FIFTEEN:
                return Points.THIRTEEN;
            case THIRTEEN:
                return Points.FOURTEEN;
            case FOURTEEN:
                switch (looserPoints) {
                    case FOURTEEN:
                        return Points.ADVANTAGE;
                    case ADVANTAGE:
                        return Points.FOURTEEN;
                    default:
                        return Points.GAME;
                }
            case ADVANTAGE:
                return Points.GAME;
            default:
                throw new IllegalStateException("The score " + winnerPoints + " does not have next");
        }
    }

    /**
     * @param looserPoints
     * @return
     */
    private Points nextLooserPoints(Points looserPoints) {
        return looserPoints == Points.ADVANTAGE ? Points.FOURTEEN : looserPoints;
    }

    public String getHumanReadableScore() {
        String score = player1.getName() + "-" + player2.getName() + " : ";
        if (points1 == Points.FOURTEEN && points2 == Points.FOURTEEN) {
            score += DEUCE;
        } else {
            score += points1.getText() + "-" + points2.getText();
        }
        return score;
    }

    public boolean isFinished() {
        return andTheGameWinnerIs() != null;
    }

    public Player andTheGameWinnerIs() {
        if (points1 == Points.GAME) {
            return player1;
        } else if (points2 == Points.GAME) {
            return player2;
        } else {
            return null;
        }
    }

    // only useful for test
    void setPoints1(Points points) {
        points1 = points;
    }

    void setPoints2(Points points) {
        points2 = points;
    }

}
