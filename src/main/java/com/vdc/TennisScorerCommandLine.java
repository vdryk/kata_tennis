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

        Player player1 = new Player(c.readLine("Player 1: "));
        Player player2 = new Player(c.readLine("Player 2: "));

        Game game = new Game(player1, player2);

        while (!game.isFinished()) {
            String pointWinner = "";
            do {
                pointWinner = c.readLine("Point for player: ");
            } while (!isValidPlayer(pointWinner));
            if (pointWinner.equals("1")) {
                game.player1WonAPoint();
            } else {
                game.player2WonAPoint();
            }

            c.format("Score: " + game.getHumanReadableScore() + "%n");
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
