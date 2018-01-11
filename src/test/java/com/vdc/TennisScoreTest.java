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

    public static final Player BOB = new Player("Bob l'eponge");
    public static final Player PETE = new Player("Pete Sampras");

    @InjectMocks
    private TennisScore tennisScore = new TennisScore(BOB, PETE);

    @Mock
    private SetScore setScore;
    @Mock
    private GameScore gameScore;

    @Test
    public void assuming_player_1_cannot_win_the_game_yet_when_player_1_scores_then_should_increment_game_score() {
        when(gameScore.addOnePointToPlayer(BOB)).thenReturn(false);
        when(setScore.addOneGameToPlayer(BOB)).thenReturn(false);

        boolean player1WinTheSet = tennisScore.addOnePointForPlayer(BOB);

        verify(gameScore).addOnePointToPlayer(BOB);
        verify(setScore, never()).addOneGameToPlayer(BOB);
        assertFalse(player1WinTheSet);
    }

    @Test
     public void assuming_player_1_needs_one_point_to_win_the_game_when_player_1_scores_then_should_increment_set_score() {
        when(gameScore.addOnePointToPlayer(BOB)).thenReturn(true);
        when(setScore.addOneGameToPlayer(BOB)).thenReturn(false);

        boolean player1WinTheSet = tennisScore.addOnePointForPlayer(BOB);

        verify(gameScore).addOnePointToPlayer(BOB);
        verify(setScore).addOneGameToPlayer(BOB);
        assertFalse(player1WinTheSet);
    }

    @Test
    public void assuming_player_1_needs_one_point_to_win_the_set_when_player_1_scores_then_should_win() {
        when(gameScore.addOnePointToPlayer(BOB)).thenReturn(true);
        when(setScore.addOneGameToPlayer(BOB)).thenReturn(true);

        boolean player1WinTheSet = tennisScore.addOnePointForPlayer(BOB);

        verify(gameScore).addOnePointToPlayer(BOB);
        verify(setScore).addOneGameToPlayer(BOB);
        assertTrue(player1WinTheSet);
    }

}
