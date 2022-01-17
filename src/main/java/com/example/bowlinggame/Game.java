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

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score = strikeBonus(score, frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score = spareBonus(score, frameIndex);
                frameIndex += 2;
            } else {
                score = noBonus(score, frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] +
               rolls[frameIndex + 1] == 10;
    }

    private int noBonus(int score, int frameIndex) {
        score +=
                rolls[frameIndex] +
                rolls[frameIndex + 1];
        return score;
    }

    private int spareBonus(int score, int frameIndex) {
        score += 10 +
                 rolls[frameIndex + 2];
        return score;
    }

    private int strikeBonus(int score, int frameIndex) {
        score += 10 +
                 rolls[frameIndex + 1] +
                 rolls[frameIndex + 2];
        return score;
    }
}
