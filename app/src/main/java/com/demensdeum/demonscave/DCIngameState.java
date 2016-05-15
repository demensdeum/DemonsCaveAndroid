package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEState;

/**
 * Created by demensdeum on 15.05.16.
 */
public class DCIngameState extends FSEState {

    DCIngameState() {
        scene = new DCIngameScene();
        sceneController = new DCIngameSceneController();
    }

}
