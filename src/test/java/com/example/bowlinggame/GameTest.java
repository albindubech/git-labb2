package com.example.bowlinggame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    void fullGutterGameShouldReturnZero(){
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        Assertions.assertEquals(0, game.score());
    }
}
