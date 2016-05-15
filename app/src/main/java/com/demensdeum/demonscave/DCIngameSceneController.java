package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 15.05.16.
 */
public class DCIngameSceneController extends FSESceneController {

    DCIngameSceneController() {
        scene = new DCIngameScene();
    }

    public void touchEvent() {
        ((DCIngameScene)scene).getWerj().switchDirection();
    }

}
