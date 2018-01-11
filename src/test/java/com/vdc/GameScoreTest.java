package com.vdc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 09/01/2018.
 */
public class GameScoreTest {

    public static final Player BOB = new Player("Bob l'eponge");
    public static final Player PETE = new Player("Pete Sampras");
    public static final GameScore GAME_SCORE = new GameScore(BOB, PETE);

    // INIT GAME

    @Test
    public void should_init_a_game_with_2_players_and_empty_score() {
        GameScore gameScore = new GameScore(BOB, PETE);
        assertEquals(BOB, gameScore.getPlayer1());
        assertEquals(PETE, gameScore.getPlayer2());
        assertEquals(GamePoints.ZERO, gameScore.getGamePoints1());
        assertEquals(GamePoints.ZERO, gameScore.getGamePoints2());
    }

    // PLAYER 1 WON A POINT

    @Test
    public void when_player_1_win_at_0_0_should_make_15_0() {
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_0_15_should_make_15_15() {
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_0_30_should_make_15_30() {
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_0_40_should_make_15_40() {
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_0_should_make_30_0() {
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_15_should_make_30_15() {
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_30_should_make_30_30() {
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_40_should_make_30_40() {
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_0_should_make_40_0() {
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_15_should_make_40_15() {
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_30_should_make_40_30() {
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_40_should_make_40_40() {
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_0_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints2());
		assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_15_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_30_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_40_should_make_advantage_player_1() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.ADVANTAGE, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_when_he_has_advantage_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints1(GamePoints.ADVANTAGE);
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_when_player_2_has_advantage_should_make_40_40() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.ADVANTAGE);
        boolean someoneWonTheGame = GAME_SCORE.player1WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
		assertFalse(someoneWonTheGame);
    }

    // PLAYER 2 WON A POINT

    @Test
    public void when_player_2_win_at_0_0_should_make_15_0() {
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_0_15_should_make_15_15() {
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_0_30_should_make_15_30() {
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_0_40_should_make_15_40() {
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_15_0_should_make_30_0() {
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_15_15_should_make_30_15() {
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_15_30_should_make_30_30() {
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_15_40_should_make_30_40() {
        GAME_SCORE.setGamePoints2(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_30_0_should_make_40_0() {
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_30_15_should_make_40_15() {
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_30_30_should_make_40_30() {
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_30_40_should_make_40_40() {
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_40_0_should_make_player_2_win_the_game() {
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.ZERO, GAME_SCORE.getGamePoints1());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_40_15_should_make_player_2_win_the_game() {
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FIFTEEN, GAME_SCORE.getGamePoints1());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_40_30_should_make_player_2_win_the_game() {
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.THIRTEEN, GAME_SCORE.getGamePoints1());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_at_40_40_should_make_advantage_player_2() {
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.ADVANTAGE, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_when_he_has_advantage_should_make_player_2_win_the_game() {
        GAME_SCORE.setGamePoints2(GamePoints.ADVANTAGE);
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.GAME, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_2_win_when_player_1_has_advantage_should_make_40_40() {
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints1(GamePoints.ADVANTAGE);
        boolean someoneWonTheGame = GAME_SCORE.player2WonAPoint();
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints2());
        assertEquals(GamePoints.FOURTEEN, GAME_SCORE.getGamePoints1());
		assertFalse(someoneWonTheGame);
    }

    // score printing
    @Test
    public void when_score_is_15_30_should_print_15_30() {
        GAME_SCORE.setGamePoints1(GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.THIRTEEN);
        String score = GAME_SCORE.getPrettyPrintScore();
        assertEquals("Bob l'eponge-Pete Sampras : 15-30", score);
    }

    @Test
    public void when_score_is_40_A_should_print_40_A() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.ADVANTAGE);
        String score = GAME_SCORE.getPrettyPrintScore();
        assertEquals("Bob l'eponge-Pete Sampras : 40-A", score);
    }

    @Test
    public void when_score_is_40_40_should_print_DEUCE() {
        GAME_SCORE.setGamePoints1(GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints2(GamePoints.FOURTEEN);
        String score = GAME_SCORE.getPrettyPrintScore();
        assertEquals("Bob l'eponge-Pete Sampras : " + GameScore.DEUCE, score);
    }

    // endind a GAME_SCORE
    @Test
    public void assuming_player_1_has_won_when_ask_who_won_should_return_player_1() {
        GAME_SCORE.setGamePoints1(GamePoints.GAME);
        GAME_SCORE.setGamePoints2(GamePoints.ZERO);
        assertEquals(BOB, GAME_SCORE.andTheGameWinnerIs());
        assertTrue(GAME_SCORE.hasSomeoneWonTheGame());
    }

    @Test
    public void assuming_player_2_has_won_when_ask_who_won_should_return_player_2() {
        GAME_SCORE.setGamePoints1(GamePoints.ZERO);
        GAME_SCORE.setGamePoints2(GamePoints.GAME);
        assertEquals(PETE, GAME_SCORE.andTheGameWinnerIs());
        assertTrue(GAME_SCORE.hasSomeoneWonTheGame());
    }

}
