package com.example.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game;

    GameTest() {
        game = new Game();
    }

    private void seriesOf(int rolls, int knockedPins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(knockedPins);
        }
    }

    @Test
    void fullGutterGameShouldReturnZero() {
        seriesOf(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    void fullGameOfOnePinKnockedShouldReturnTwenty() {
        seriesOf(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    void whenFrameIsSpareScoreShouldCountTheFollowingRoll() {
        game.roll(5);
        game.roll(5);
        game.roll(7);
        seriesOf(17, 0);
        assertEquals(24, game.score());
    }

    @Test
    void whenFrameIsStrikeScoreShouldCountTheFollowingTwoRolls() {
        game.roll(10);
        game.roll(4);
        game.roll(5);
        seriesOf(16,0);
        assertEquals(28, game.score());
    }

    @Test
    void perfectGame(){
        seriesOf(12,10);
        assertEquals(300,game.score());
    }

    @Test
    void fullGame(){
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(10);
        game.roll(2);
        game.roll(8);
        game.roll(6);

        assertEquals(133, game.score());
    }

    @Test
    void strikeOnLastFrameShouldGiveTwoExtraRolls() {
        seriesOf(18,0);
        game.roll(10);
        game.roll(10);
        game.roll(4);
        assertEquals(24, game.score());
    }

    @Test
    void spareOnLastFrameShouldGiveOneExtraRoll() {
        seriesOf(18,0);
        game.roll(7);
        game.roll(3);
        game.roll(4);
        assertEquals(14, game.score());
    }

    @Test
    void moreThan20RollsShouldNotCountTowardsScore(){
        seriesOf(20,0);
        game.roll(3);

        assertEquals(0, game.score());
    }
}