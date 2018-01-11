package com.vdc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Vincent on 11/01/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class TennisScoreTest {

    @InjectMocks
    private TennisScore tennisScore = new TennisScore("Bob l'eponge", "Pete Sampras");

    @Mock
    private SetScore setScore;
    @Mock
    private GameScore gameScore;

    @Test
    public void assuming_player_1_cannot_win_the_game_yet_when_player_1_scores_then_should_increment_game_score() {
        when(gameScore.player1WonAPoint()).thenReturn(false);
        when(setScore.player1WonAGame()).thenReturn(false);

        boolean player1WinTheSet = tennisScore.addOnePointForPlayer1();

        verify(gameScore).player1WonAPoint();
        verify(setScore, never()).player1WonAGame();
        assertFalse(player1WinTheSet);
    }

    @Test
     public void assuming_player_1_needs_one_point_to_win_the_game_when_player_1_scores_then_should_increment_set_score() {
        when(gameScore.player1WonAPoint()).thenReturn(true);
        when(setScore.player1WonAGame()).thenReturn(false);

        boolean player1WinTheSet = tennisScore.addOnePointForPlayer1();

        verify(gameScore).player1WonAPoint();
        verify(setScore).player1WonAGame();
        assertFalse(player1WinTheSet);
    }

    @Test
    public void assuming_player_1_needs_one_point_to_win_the_set_when_player_1_scores_then_should_win() {
        when(gameScore.player1WonAPoint()).thenReturn(true);
        when(setScore.player1WonAGame()).thenReturn(true);

        boolean player1WinTheSet = tennisScore.addOnePointForPlayer1();

        verify(gameScore).player1WonAPoint();
        verify(setScore).player1WonAGame();
        assertTrue(player1WinTheSet);
    }

}
