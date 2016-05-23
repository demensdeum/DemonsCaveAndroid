package com.demensdeum.flamesteelengine;

/**
 * Created by demensdeum on 22.05.16.
 */
public class FSEGameScoreController {

    private int score = 0;

    public void addScore(int scoreToAdd) {
        score += scoreToAdd;
    }

    public int getScore() {
        return score;
    }

    private void reset() {
        score = 0;
    }

}
