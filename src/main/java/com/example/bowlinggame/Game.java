package com.example.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> rolls = new ArrayList<>();
    private int score;

    public void roll(int knockedPins) {
        rolls.add(knockedPins);
    }

    public int score() {
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (strike(frameIndex))
                frameIndex++;
            else if (spare(frameIndex))
                frameIndex += 2;
            else {
                regularFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean strike(int frameIndex) {
        if (rolls.get(frameIndex) == 10) {
            score += 10 +
                     rolls.get(frameIndex + 1) +
                     rolls.get(frameIndex + 2);
            return true;
        } else
            return false;
    }

    private boolean spare(int frameIndex) {
        if (rolls.get(frameIndex) + rolls.get(frameIndex + 1) == 10) {
            score += 10 +
                     rolls.get(frameIndex + 2);
            return true;
        } else
            return false;
    }

    private void regularFrame(int frameIndex) {
        score += rolls.get(frameIndex) +
                 rolls.get(frameIndex + 1);
    }
}
