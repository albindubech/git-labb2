package com.example.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();

    @Test
    void fullGutterGameShouldReturnZero(){
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertEquals(0, game.score());
    }

    @Test
    void fullGameOfOnePinKnockedShouldReturnTwenty(){
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }

        assertEquals(20, game.score());
    }
}
