package com.vdc;

/**
 * Created by Vincent on 10/01/2018.
 */
public class TennisScore {

    private Player player1;
    private Player player2;

    private SetScore currentSetScore;
    private GameScore currentGameScore;

    public TennisScore(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.currentGameScore = new GameScore(this.player1, this.player2);
        this.currentSetScore = new SetScore();
    }

    public boolean addOnePointForPlayer1() {
        boolean someoneWonTheGame = this.currentGameScore.player1WonAPoint();

        boolean someoneWonTheSet = false;
        if (someoneWonTheGame) {
            currentGameScore = new GameScore(this.player1, this.player2);
            someoneWonTheSet = this.currentSetScore.player1WonAGame();
        } else {
            someoneWonTheSet = false;
        }

        return someoneWonTheSet;
    }

    public boolean addOnePointForPlayer2() {
        boolean someoneWonTheGame = this.currentGameScore.player2WonAPoint();

        boolean someoneWonTheSet = false;
        if (someoneWonTheGame) {
            currentGameScore = new GameScore(this.player1, this.player2);
            someoneWonTheSet = this.currentSetScore.player2WonAGame();
        } else {
            someoneWonTheSet = false;
        }

        return someoneWonTheSet;
    }

    public String getPrettyPrintScore() {
        String gameScore = this.currentGameScore.getPrettyPrintScore();
        String setScore = this.currentSetScore.getPrettyPrintScore();
        return gameScore + "\n" + setScore;
    }
}
