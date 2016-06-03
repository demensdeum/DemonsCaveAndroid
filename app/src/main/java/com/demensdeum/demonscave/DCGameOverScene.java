package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSEText;

/**
 * Created by demensdeum on 24.05.16.
 */
public class DCGameOverScene extends FSEScene {

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    DCGameOverScene() {

    }

    public void prepareToShow() {
        int score = this.sceneController.scoreController.getScore();
        String scoreString = String.format("Score: %d", score);

        FSEObject textPlane = FSEText.allocateText(scoreString,0.24f,0.08f);
        textPlane.setX(-0.3);
        textPlane.setY(0.4);

        DCGameOverScreen gameOverScreen = new DCGameOverScreen();

        addObject(textPlane);
        addObject(gameOverScreen);
    }

}
