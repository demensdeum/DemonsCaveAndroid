package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSESceneController;
import com.demensdeum.flamesteelengine.FSESceneControllerDelegate;

/**
 * Created by demensdeum on 10.05.16.
 */
public class DCGameController implements FSESceneControllerDelegate {

    public enum DCState {
        demensdeumLogoState,
        flameSteelEngineLogoState,
        startGameScreenState,
        ingameState,
    };

    private DCState currentState;
    private FSESceneController currentSceneController;
    private Renderer renderer;

    public DCGameController(Renderer renderer) {
        this.renderer = renderer;
    }

    private void switchCurrentSceneControllerTo(FSESceneController sceneController) {
        currentSceneController = sceneController;
        currentSceneController.delegate = this;
        renderer.switchToSceneController(sceneController);
    }

    private void switchStateTo(DCState state) {
        currentState = state;

        if (state == DCState.demensdeumLogoState) {
            switchCurrentSceneControllerTo(new DCDemensdeumLogoSceneController());
        }
        else if (state == DCState.flameSteelEngineLogoState) {
            switchCurrentSceneControllerTo(new DCFlameSteelEngineLogoController());
        }
        else if (state == DCState.startGameScreenState) {
            switchCurrentSceneControllerTo(new DCStartGameScreenSceneController());
        }
        else if (state == DCState.ingameState) {
            switchCurrentSceneControllerTo(new DCIngameSceneController());
        }
    }

    public void startGame() {
        this.switchStateTo(DCState.demensdeumLogoState);
    }

    @Override
    public void sceneControllerDidEnd(FSESceneController controller) {
        if (currentState == DCState.demensdeumLogoState) {
            switchStateTo(DCState.flameSteelEngineLogoState);
        }
        else if (currentState == DCState.flameSteelEngineLogoState) {
            switchStateTo(DCState.startGameScreenState);
        }
        else if (currentState == DCState.startGameScreenState) {
            switchStateTo(DCState.ingameState);
        }
    }

}
