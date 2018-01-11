package com.vdc;

/**
 * Created by Vincent on 09/01/2018.
 */
public class SetScore {

    private int gameCount1;
    private int gameCount2;

    public boolean player1WonAGame() {
        gameCount1++;
        if (gameCount1 == 6 && gameCount2 <= 4 || gameCount1 == 7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean player2WonAGame() {
        gameCount2++;
        if (gameCount2 == 6 && gameCount1 <= 4 || gameCount2 == 7) {
            return true;
        } else {
            return false;
        }
    }

    public String getPrettyPrintScore() {
        return gameCount1 + "-" + gameCount2;
    }

    // only useful for testing

    void setGameCount1(int gameCount1) {
        this.gameCount1 = gameCount1;
    }

    void setGameCount2(int gameCount2) {
        this.gameCount2 = gameCount2;
    }
}
