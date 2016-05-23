package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 23.05.16.
 */
public class DCGameOverSceneController extends FSESceneController {

    DCGameOverSceneController() {
        scene = new DCGameOverScene();
    }

    public void touchEvent()
    {
        this.delegate.sceneControllerDidEnd(this);
    }

}
