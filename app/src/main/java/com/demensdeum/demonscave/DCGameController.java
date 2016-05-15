package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 10.05.16.
 */
public class DCGameController {

    public enum DCState {
        ingameState
    };

    private FSESceneController currentSceneController;
    private Renderer renderer;

    public DCGameController(Renderer renderer) {
        this.renderer = renderer;
    }

    private void showGameScene() {
        currentSceneController = new DCIngameSceneController();
        renderer.switchToSceneController(currentSceneController);
    }

    public void startGame() {
        this.showGameScene();
    }

}
