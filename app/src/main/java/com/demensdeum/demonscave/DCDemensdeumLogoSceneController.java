package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 18.05.16.
 */
public class DCDemensdeumLogoSceneController extends DCFadeImageSceneController {

    DCDemensdeumLogoSceneController() {
        FSEScene scene = new DCDemensdeumLogoScene();
        this.setScene(scene);
    }

}
