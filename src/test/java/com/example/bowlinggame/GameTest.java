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
    void fullGutterGameShouldReturnZero(){
        fullSeries(20,0);

        assertEquals(0, game.score());
    }

    @Test
    void fullGameOfOnePinKnockedShouldReturnTwenty(){
        fullSeries(20,1);

        assertEquals(20, game.score());
    }

    @Test
    void whenFrameIsSpareThatScoreWillCountTheFollowingRoll(){
        game.roll(5);
        game.roll(5);
        game.roll(7);
        fullSeries(17,0);
        assertEquals(24, game.score());
    }
}
