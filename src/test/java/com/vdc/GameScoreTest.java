package com.vdc;

import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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
        assertEquals(points(GamePoints.ZERO, GamePoints.ZERO), gameScore.getPointsByPlayer());
    }

    // A PLAYER WON A POINT

    @Test
    public void when_player_1_win_at_0_0_should_make_15_0() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.ZERO);
        GAME_SCORE.setGamePoints(PETE, GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FIFTEEN, GamePoints.ZERO), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_0_15_should_make_15_15() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.ZERO);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FIFTEEN, GamePoints.FIFTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_0_30_should_make_15_30() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.ZERO);
        GAME_SCORE.setGamePoints(PETE, GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FIFTEEN, GamePoints.THIRTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_0_40_should_make_15_40() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.ZERO);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FIFTEEN, GamePoints.FOURTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_0_should_make_30_0() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.THIRTEEN, GamePoints.ZERO), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_15_should_make_30_15() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.THIRTEEN, GamePoints.FIFTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_30_should_make_30_30() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.THIRTEEN, GamePoints.THIRTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_15_40_should_make_30_40() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FIFTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.THIRTEEN, GamePoints.FOURTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_0_should_make_40_0() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FOURTEEN, GamePoints.ZERO), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_15_should_make_40_15() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FOURTEEN, GamePoints.FIFTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_30_should_make_40_30() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FOURTEEN, GamePoints.THIRTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_30_40_should_make_40_40() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.THIRTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FOURTEEN, GamePoints.FOURTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_0_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.ZERO);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.GAME, GamePoints.ZERO), GAME_SCORE.getPointsByPlayer());
		assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_15_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FIFTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.GAME, GamePoints.FIFTEEN), GAME_SCORE.getPointsByPlayer());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_30_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.THIRTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.GAME, GamePoints.THIRTEEN), GAME_SCORE.getPointsByPlayer());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_at_40_40_should_make_advantage_player_1() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.ADVANTAGE, GamePoints.FOURTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_when_he_has_advantage_should_make_player_1_win_the_game() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.ADVANTAGE);
        GAME_SCORE.setGamePoints(PETE, GamePoints.FOURTEEN);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.GAME, GamePoints.FOURTEEN), GAME_SCORE.getPointsByPlayer());
        assertTrue(someoneWonTheGame);
    }

    @Test
    public void when_player_1_win_when_player_2_has_advantage_should_make_40_40() {
        GAME_SCORE.setGamePoints(BOB, GamePoints.FOURTEEN);
        GAME_SCORE.setGamePoints(PETE, GamePoints.ADVANTAGE);
        boolean someoneWonTheGame = GAME_SCORE.addOnePointToPlayer(BOB);
        assertEquals(points(GamePoints.FOURTEEN, GamePoints.FOURTEEN), GAME_SCORE.getPointsByPlayer());
		assertFalse(someoneWonTheGame);
    }
    
    private Map<Player, GamePoints> points(GamePoints bobPoints, GamePoints petePoints) {
        HashMap<Player, GamePoints> playersGamePoints = new HashMap<>();
        playersGamePoints.put(BOB, bobPoints);
        playersGamePoints.put(PETE, petePoints);
        return playersGamePoints;
    }

}
