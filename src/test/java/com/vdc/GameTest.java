package com.vdc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 09/01/2018.
 */
public class GameTest {

    public static final Player BOB = new Player("Bob l'eponge");
    public static final Player PETE = new Player("Pete Sampras");
    public static final Game game = new Game(BOB, PETE);

    // INIT GAME

    @Test
    public void should_init_a_game_with_2_players_and_empty_score() {
        Game game = new Game(BOB, PETE);
        assertEquals(BOB, game.getPlayer1());
        assertEquals(PETE, game.getPlayer2());
        assertEquals(Points.ZERO, game.getPoints1());
        assertEquals(Points.ZERO, game.getPoints2());
    }

    // PLAYER 1 WON A POINT

    @Test
    public void when_player_1_win_at_0_0_should_make_15_0() {
        game.setPoints1(Points.ZERO);
        game.setPoints2(Points.ZERO);
        game.player1WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints1());
        assertEquals(Points.ZERO, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_0_15_should_make_15_15() {
        game.setPoints1(Points.ZERO);
        game.setPoints2(Points.FIFTEEN);
        game.player1WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints1());
        assertEquals(Points.FIFTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_0_30_should_make_15_30() {
        game.setPoints1(Points.ZERO);
        game.setPoints2(Points.THIRTEEN);
        game.player1WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints1());
        assertEquals(Points.THIRTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_0_40_should_make_15_40() {
        game.setPoints1(Points.ZERO);
        game.setPoints2(Points.FOURTEEN);
        game.player1WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints1());
        assertEquals(Points.FOURTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_15_0_should_make_30_0() {
        game.setPoints1(Points.FIFTEEN);
        game.setPoints2(Points.ZERO);
        game.player1WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints1());
        assertEquals(Points.ZERO, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_15_15_should_make_30_15() {
        game.setPoints1(Points.FIFTEEN);
        game.setPoints2(Points.FIFTEEN);
        game.player1WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints1());
        assertEquals(Points.FIFTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_15_30_should_make_30_30() {
        game.setPoints1(Points.FIFTEEN);
        game.setPoints2(Points.THIRTEEN);
        game.player1WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints1());
        assertEquals(Points.THIRTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_15_40_should_make_30_40() {
        game.setPoints1(Points.FIFTEEN);
        game.setPoints2(Points.FOURTEEN);
        game.player1WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints1());
        assertEquals(Points.FOURTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_30_0_should_make_40_0() {
        game.setPoints1(Points.THIRTEEN);
        game.setPoints2(Points.ZERO);
        game.player1WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints1());
        assertEquals(Points.ZERO, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_30_15_should_make_40_15() {
        game.setPoints1(Points.THIRTEEN);
        game.setPoints2(Points.FIFTEEN);
        game.player1WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints1());
        assertEquals(Points.FIFTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_30_30_should_make_40_30() {
        game.setPoints1(Points.THIRTEEN);
        game.setPoints2(Points.THIRTEEN);
        game.player1WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints1());
        assertEquals(Points.THIRTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_30_40_should_make_40_40() {
        game.setPoints1(Points.THIRTEEN);
        game.setPoints2(Points.FOURTEEN);
        game.player1WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints1());
        assertEquals(Points.FOURTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_40_0_should_make_player_1_win_the_game() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.ZERO);
        game.player1WonAPoint();
        assertEquals(Points.GAME, game.getPoints1());
        assertEquals(Points.ZERO, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_40_15_should_make_player_1_win_the_game() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.FIFTEEN);
        game.player1WonAPoint();
        assertEquals(Points.GAME, game.getPoints1());
        assertEquals(Points.FIFTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_40_30_should_make_player_1_win_the_game() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.THIRTEEN);
        game.player1WonAPoint();
        assertEquals(Points.GAME, game.getPoints1());
        assertEquals(Points.THIRTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_at_40_40_should_make_advantage_player_1() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.FOURTEEN);
        game.player1WonAPoint();
        assertEquals(Points.ADVANTAGE, game.getPoints1());
        assertEquals(Points.FOURTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_when_he_has_advantage_should_make_player_1_win_the_game() {
        game.setPoints1(Points.ADVANTAGE);
        game.setPoints2(Points.FOURTEEN);
        game.player1WonAPoint();
        assertEquals(Points.GAME, game.getPoints1());
        assertEquals(Points.FOURTEEN, game.getPoints2());
    }

    @Test
    public void when_player_1_win_when_player_2_has_advantage_should_make_40_40() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.ADVANTAGE);
        game.player1WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints1());
        assertEquals(Points.FOURTEEN, game.getPoints2());
    }

    // PLAYER 2 WON A POINT

    @Test
    public void when_player_2_win_at_0_0_should_make_15_0() {
        game.setPoints2(Points.ZERO);
        game.setPoints1(Points.ZERO);
        game.player2WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints2());
        assertEquals(Points.ZERO, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_0_15_should_make_15_15() {
        game.setPoints2(Points.ZERO);
        game.setPoints1(Points.FIFTEEN);
        game.player2WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints2());
        assertEquals(Points.FIFTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_0_30_should_make_15_30() {
        game.setPoints2(Points.ZERO);
        game.setPoints1(Points.THIRTEEN);
        game.player2WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints2());
        assertEquals(Points.THIRTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_0_40_should_make_15_40() {
        game.setPoints2(Points.ZERO);
        game.setPoints1(Points.FOURTEEN);
        game.player2WonAPoint();
        assertEquals(Points.FIFTEEN, game.getPoints2());
        assertEquals(Points.FOURTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_15_0_should_make_30_0() {
        game.setPoints2(Points.FIFTEEN);
        game.setPoints1(Points.ZERO);
        game.player2WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints2());
        assertEquals(Points.ZERO, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_15_15_should_make_30_15() {
        game.setPoints2(Points.FIFTEEN);
        game.setPoints1(Points.FIFTEEN);
        game.player2WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints2());
        assertEquals(Points.FIFTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_15_30_should_make_30_30() {
        game.setPoints2(Points.FIFTEEN);
        game.setPoints1(Points.THIRTEEN);
        game.player2WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints2());
        assertEquals(Points.THIRTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_15_40_should_make_30_40() {
        game.setPoints2(Points.FIFTEEN);
        game.setPoints1(Points.FOURTEEN);
        game.player2WonAPoint();
        assertEquals(Points.THIRTEEN, game.getPoints2());
        assertEquals(Points.FOURTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_30_0_should_make_40_0() {
        game.setPoints2(Points.THIRTEEN);
        game.setPoints1(Points.ZERO);
        game.player2WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints2());
        assertEquals(Points.ZERO, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_30_15_should_make_40_15() {
        game.setPoints2(Points.THIRTEEN);
        game.setPoints1(Points.FIFTEEN);
        game.player2WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints2());
        assertEquals(Points.FIFTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_30_30_should_make_40_30() {
        game.setPoints2(Points.THIRTEEN);
        game.setPoints1(Points.THIRTEEN);
        game.player2WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints2());
        assertEquals(Points.THIRTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_30_40_should_make_40_40() {
        game.setPoints2(Points.THIRTEEN);
        game.setPoints1(Points.FOURTEEN);
        game.player2WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints2());
        assertEquals(Points.FOURTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_40_0_should_make_player_2_win_the_game() {
        game.setPoints2(Points.FOURTEEN);
        game.setPoints1(Points.ZERO);
        game.player2WonAPoint();
        assertEquals(Points.GAME, game.getPoints2());
        assertEquals(Points.ZERO, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_40_15_should_make_player_2_win_the_game() {
        game.setPoints2(Points.FOURTEEN);
        game.setPoints1(Points.FIFTEEN);
        game.player2WonAPoint();
        assertEquals(Points.GAME, game.getPoints2());
        assertEquals(Points.FIFTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_40_30_should_make_player_2_win_the_game() {
        game.setPoints2(Points.FOURTEEN);
        game.setPoints1(Points.THIRTEEN);
        game.player2WonAPoint();
        assertEquals(Points.GAME, game.getPoints2());
        assertEquals(Points.THIRTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_at_40_40_should_make_advantage_player_2() {
        game.setPoints2(Points.FOURTEEN);
        game.setPoints1(Points.FOURTEEN);
        game.player2WonAPoint();
        assertEquals(Points.ADVANTAGE, game.getPoints2());
        assertEquals(Points.FOURTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_when_he_has_advantage_should_make_player_2_win_the_game() {
        game.setPoints2(Points.ADVANTAGE);
        game.setPoints1(Points.FOURTEEN);
        game.player2WonAPoint();
        assertEquals(Points.GAME, game.getPoints2());
        assertEquals(Points.FOURTEEN, game.getPoints1());
    }

    @Test
    public void when_player_2_win_when_player_1_has_advantage_should_make_40_40() {
        game.setPoints2(Points.FOURTEEN);
        game.setPoints1(Points.ADVANTAGE);
        game.player2WonAPoint();
        assertEquals(Points.FOURTEEN, game.getPoints2());
        assertEquals(Points.FOURTEEN, game.getPoints1());
    }

    // score printing
    @Test
    public void when_score_is_15_30_should_print_15_30() {
        game.setPoints1(Points.FIFTEEN);
        game.setPoints2(Points.THIRTEEN);
        String score = game.getHumanReadableScore();
        assertEquals("Bob l'eponge-Pete Sampras : 15-30", score);
    }

    @Test
    public void when_score_is_40_A_should_print_40_A() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.ADVANTAGE);
        String score = game.getHumanReadableScore();
        assertEquals("Bob l'eponge-Pete Sampras : 40-A", score);
    }

    @Test
    public void when_score_is_40_40_should_print_DEUCE() {
        game.setPoints1(Points.FOURTEEN);
        game.setPoints2(Points.FOURTEEN);
        String score = game.getHumanReadableScore();
        assertEquals("Bob l'eponge-Pete Sampras : " + Game.DEUCE, score);
    }

    // endind a game
    @Test
    public void assuming_player_1_has_won_when_ask_who_won_should_return_player_1() {
        game.setPoints1(Points.GAME);
        game.setPoints2(Points.ZERO);
        assertEquals(BOB, game.andTheGameWinnerIs());
        assertTrue(game.isFinished());
    }

    @Test
    public void assuming_player_2_has_won_when_ask_who_won_should_return_player_2() {
        game.setPoints1(Points.ZERO);
        game.setPoints2(Points.GAME);
        assertEquals(PETE, game.andTheGameWinnerIs());
        assertTrue(game.isFinished());
    }

}
