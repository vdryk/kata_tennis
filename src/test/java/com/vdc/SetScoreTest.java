package com.vdc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 11/01/2018.
 */
public class SetScoreTest {

    private SetScore setScore = new SetScore();

    @Test
    public void assuming_set_score_is_0_0_when_player_1_won_a_game_should_score_be_1_0() {
        setScore.setGameCount1(0);
        setScore.setGameCount2(0);
        boolean someoneWonTheSet = setScore.player1WonAGame();
        assertFalse(someoneWonTheSet);
        assertEquals("1-0", setScore.getPrettyPrintScore());
    }

    @Test
    public void assuming_set_score_is_5_4_when_player_1_won_a_game_should_score_be_6_4_and_player_1_win() {
        setScore.setGameCount1(5);
        setScore.setGameCount2(4);
        boolean someoneWonTheSet = setScore.player1WonAGame();
        assertTrue(someoneWonTheSet);
        assertEquals("6-4", setScore.getPrettyPrintScore());
    }

    @Test
    public void assuming_set_score_is_5_5_when_player_1_won_a_game_should_score_be_6_5_and_nobody_win_yet() {
        setScore.setGameCount1(5);
        setScore.setGameCount2(5);
        boolean someoneWonTheSet = setScore.player1WonAGame();
        assertFalse(someoneWonTheSet);
        assertEquals("6-5", setScore.getPrettyPrintScore());
    }

    @Test
    public void assuming_set_score_is_6_5_when_player_1_won_a_game_should_score_be_7_5_and_player_1_win() {
        setScore.setGameCount1(6);
        setScore.setGameCount2(5);
        boolean someoneWonTheSet = setScore.player1WonAGame();
        assertTrue(someoneWonTheSet);
        assertEquals("7-5", setScore.getPrettyPrintScore());
    }

    @Test
    public void assuming_set_score_is_6_5_when_player_2_won_a_game_should_score_be_6_6_and_nobody_win_yet() {
        setScore.setGameCount1(6);
        setScore.setGameCount2(5);
        boolean someoneWonTheSet = setScore.player2WonAGame();
        assertFalse(someoneWonTheSet);
        assertEquals("6-6", setScore.getPrettyPrintScore());
    }

}
