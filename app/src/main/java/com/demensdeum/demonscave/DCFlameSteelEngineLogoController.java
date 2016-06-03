package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 18.05.16.
 */
public class DCFlameSteelEngineLogoController extends DCFadeImageSceneController {

    public DCFlameSteelEngineLogoController() {
        FSEScene scene = new DCFlameSteelEngineLogoScene();
        this.setScene(scene);
    }

}
