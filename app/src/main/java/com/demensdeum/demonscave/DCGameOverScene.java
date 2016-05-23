package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEScene;

/**
 * Created by demensdeum on 24.05.16.
 */
public class DCGameOverScene extends FSEScene {

    DCGameOverScene() {
        DCGameOverScreen gameOverScreen = new DCGameOverScreen();

        addObject(gameOverScreen);
    }

}
