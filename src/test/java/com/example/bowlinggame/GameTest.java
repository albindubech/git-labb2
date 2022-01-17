package com.example.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game;

    GameTest() {
        game = new Game();
    }

    private void fullSeries(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    void fullGutterGameShouldReturnZero() {
        fullSeries(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    void fullGameOfOnePinKnockedShouldReturnTwenty() {
        fullSeries(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    void whenFrameIsSpareScoreShouldCountTheFollowingRoll() {
        game.roll(5);
        game.roll(5);
        game.roll(7);
        fullSeries(17, 0);
        assertEquals(24, game.score());
    }

    @Test
    void whenFrameIsStrikeScoreShouldCountTheFollowingTwoRolls() {
        game.roll(10);
        game.roll(4);
        game.roll(5);
        fullSeries(16,0);
        assertEquals(28, game.score());
    }
}
