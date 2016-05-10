package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;

/**
 * Created by demensdeum on 10.05.16.
 */
public class DCGameController {

    private FSEScene scene;
    private Renderer renderer;

    public DCGameController(Renderer renderer) {
        this.renderer = renderer;
    }

    private void showGameScene() {
        scene = new DCIngameScene();
        renderer.showScene(scene);
    }

    public void startGame() {

        this.showGameScene();

    }

}
