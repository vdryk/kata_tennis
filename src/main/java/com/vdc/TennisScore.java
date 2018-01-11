package com.vdc;

/**
 * Created by Vincent on 10/01/2018.
 */
public class TennisScore {

    private Player player1;
    private Player player2;

    private SetScore currentSetScore;
    private GameScore currentGameScore;

    public TennisScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentGameScore = new GameScore(player1, player2);
        this.currentSetScore = new SetScore(player1, player2);
    }

    public boolean addOnePointForPlayer(Player player) {
        boolean someoneWonTheGame = this.currentGameScore.addOnePointToPlayer(player);

        boolean someoneWonTheSet = false;
        if (someoneWonTheGame) {
            currentGameScore = new GameScore(this.player1, this.player2);
            someoneWonTheSet = this.currentSetScore.addOneGameToPlayer(player);
        } else {
            someoneWonTheSet = false;
        }

        return someoneWonTheSet;
    }

    public String getPrettyPrintScore() {
        String score = player1.getName() + "-" + player2.getName() + " : \n";
        score += "Current game: " + this.currentGameScore.getPointsByPlayer().get(player1).getText() + "-" +
                this.currentGameScore.getPointsByPlayer().get(player2).getText() + "\n";
        score += this.currentSetScore.getGameCountByPlayer().get(player1) + "-" +
                this.currentSetScore.getGameCountByPlayer().get(player2) + "\n";
        return score;
    }
}
