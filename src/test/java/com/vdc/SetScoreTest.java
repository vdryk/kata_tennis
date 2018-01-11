package com.vdc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 11/01/2018.
 */
public class SetScoreTest {
    
    public static final Player BOB = new Player("Bob l'eponge");
    public static final Player PETE = new Player("Pete Sampras");
    private static final SetScore SET_SCORE = new SetScore(BOB, PETE);

    @Test
    public void when_new_set_score_should_be_0_0() {
        SetScore setScore = new SetScore(BOB, PETE);
        assertEquals(games(0, 0), SET_SCORE.getGameCountByPlayer());
    }

    @Test
    public void assuming_set_score_is_0_0_when_player_1_won_a_game_should_score_be_1_0() {
        SET_SCORE.setGameCount(BOB, 0);
        SET_SCORE.setGameCount(PETE, 0);
        boolean someoneWonTheSet = SET_SCORE.addOneGameToPlayer(BOB);
        assertFalse(someoneWonTheSet);
        assertEquals(games(1, 0), SET_SCORE.getGameCountByPlayer());
    }

    @Test
    public void assuming_set_score_is_5_4_when_player_1_won_a_game_should_score_be_6_4_and_player_1_win() {
        SET_SCORE.setGameCount(BOB, 5);
        SET_SCORE.setGameCount(PETE, 4);
        boolean someoneWonTheSet = SET_SCORE.addOneGameToPlayer(BOB);
        assertTrue(someoneWonTheSet);
        assertEquals(games(6, 4), SET_SCORE.getGameCountByPlayer());
    }

    @Test
    public void assuming_set_score_is_5_5_when_player_1_won_a_game_should_score_be_6_5_and_nobody_win_yet() {
        SET_SCORE.setGameCount(BOB, 5);
        SET_SCORE.setGameCount(PETE, 5);
        boolean someoneWonTheSet = SET_SCORE.addOneGameToPlayer(BOB);
        assertFalse(someoneWonTheSet);
        assertEquals(games(6, 5), SET_SCORE.getGameCountByPlayer());
    }

    @Test
    public void assuming_set_score_is_6_5_when_player_1_won_a_game_should_score_be_7_5_and_player_1_win() {
        SET_SCORE.setGameCount(BOB, 6);
        SET_SCORE.setGameCount(PETE, 5);
        boolean someoneWonTheSet = SET_SCORE.addOneGameToPlayer(BOB);
        assertTrue(someoneWonTheSet);
        assertEquals(games(7, 5), SET_SCORE.getGameCountByPlayer());
    }

    @Test
    public void assuming_set_score_is_6_5_when_player_2_won_a_game_should_score_be_6_6_and_nobody_win_yet() {
        SET_SCORE.setGameCount(BOB, 6);
        SET_SCORE.setGameCount(PETE, 5);
        boolean someoneWonTheSet = SET_SCORE.addOneGameToPlayer(PETE);
        assertFalse(someoneWonTheSet);
        assertEquals(games(6, 6), SET_SCORE.getGameCountByPlayer());
    }

    private Map<Player, Integer> games(int bobGames, int peteGames) {
        HashMap<Player, Integer> playersGames = new HashMap<>();
        playersGames.put(BOB, bobGames);
        playersGames.put(PETE, peteGames);
        return playersGames;
    }

}
