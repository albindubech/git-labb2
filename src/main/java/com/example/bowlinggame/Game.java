package com.example.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> rolls = new ArrayList<>();
    int score = 0;

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                noBonus(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls.get(frameIndex) == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls.get(frameIndex) +
               rolls.get(frameIndex + 1) == 10;
    }

    private void noBonus(int frameIndex) {
        score += rolls.get(frameIndex) +
                 rolls.get(frameIndex + 1);
    }

    private void spareBonus(int frameIndex) {
        score += 10 +
                 rolls.get(frameIndex + 2);
    }

    private void strikeBonus(int frameIndex) {
        score += 10 +
                 rolls.get(frameIndex + 1) +
                 rolls.get(frameIndex + 2);
    }
}
