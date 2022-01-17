package com.example.bowlinggame;

public class Game {

    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
            if (isSpare(frameIndex)) {
                score += 10 + rolls[frameIndex + 2];
            }
            else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
            }
            frameIndex += 2;
            System.out.println(score);
        }
        return score;
    }

    private boolean isSpare(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
