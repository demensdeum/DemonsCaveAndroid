package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 18.05.16.
 */
public class DCStartGameScreenSceneController extends FSESceneController {

    DCStartGameScreenSceneController() {
        scene = new DCStartGameScreenScene();
    }

    public void touchEvent()
    {
        this.delegate.sceneControllerDidEnd(this);
    }
}
