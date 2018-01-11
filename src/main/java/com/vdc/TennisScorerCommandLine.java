package com.vdc;

import java.io.Console;
import java.io.IOException;

/**
 * Created by Vincent on 09/01/2018.
 */
public class TennisScorerCommandLine {

    public static void main (String args[]) throws IOException {

        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String player1 = c.readLine("Player 1: ");
        String player2 = c.readLine("Player 2: ");

        TennisScore tennisScore = new TennisScore(player1, player2);

        boolean someoneWonTheSet = false;
        while (!someoneWonTheSet) {
            String pointWinner = "";
            do {
                pointWinner = c.readLine("Point for player: ");
            } while (!isValidPlayer(pointWinner));
            if (pointWinner.equals("1")) {
                someoneWonTheSet= tennisScore.addOnePointForPlayer1();
            } else {
                someoneWonTheSet = tennisScore.addOnePointForPlayer2();
            }

            c.format("Score: " + tennisScore.getPrettyPrintScore() + "%n");
        }

    }

    private static boolean isValidPlayer(String pointWinner) {
        boolean validPlayer = pointWinner.equals("1") || pointWinner.equals("2");
        if (!validPlayer) {
            System.console().format("Only \"1\" or \"2\" is valid%n");
        }
        return validPlayer;
    }

}
