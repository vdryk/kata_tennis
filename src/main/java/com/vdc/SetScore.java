package com.vdc;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Vincent on 09/01/2018.
 */
public class SetScore {

    private Map<Player, Integer> gameCountByPlayer;

    public SetScore(Player player1, Player player2) {
        gameCountByPlayer = new HashMap<>();
        gameCountByPlayer.put(player1, 0);
        gameCountByPlayer.put(player2, 0);
    }

    public boolean addOneGameToPlayer(Player winner) {
        Integer winnerGameCount = gameCountByPlayer.get(winner);
        winnerGameCount++;
        gameCountByPlayer.put(winner, winnerGameCount);

        Player looser = getLooser(winner);
        Integer looserGameCount = gameCountByPlayer.get(looser);

        if (winnerGameCount == 6 && looserGameCount <= 4 || winnerGameCount == 7) {
            return true;
        } else {
            return false;
        }
    }

    private Player getLooser(Player winner) {
        return gameCountByPlayer.keySet().stream()
                .filter(player -> !player.equals(winner))
                .findFirst().get();
    }

    public Map<Player, Integer> getGameCountByPlayer() {
        return gameCountByPlayer;
    }

    // only useful for testing

    void setGameCount(Player player, int gameCount) {
        gameCountByPlayer.put(player, gameCount);
    }
}
