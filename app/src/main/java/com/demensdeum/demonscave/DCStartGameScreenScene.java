package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSEText;

/**
 * Created by demensdeum on 18.05.16.
 */
public class DCStartGameScreenScene extends FSEScene {

    DCStartGameScreenScene() {
        DCStartGameScreen startGameScreen = new DCStartGameScreen(0);
        addObject(startGameScreen);
    }

}
