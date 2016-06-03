package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEGameScoreController;
import com.demensdeum.flamesteelengine.FSESceneController;
import com.demensdeum.flamesteelengine.FSESceneControllerDelegate;

/**
 * Created by demensdeum on 10.05.16.
 */
public class DCGameController implements FSESceneControllerDelegate {

    public enum DCState {
        demensdeumLogo,
        flameSteelEngineLogo,
        start,
        ingame,
        gameOver
    };

    private DCState currentState;
    private FSESceneController currentSceneController;
    private Renderer renderer;
    private FSEGameScoreController gameScoreController;

    public DCGameController(Renderer renderer) {
        this.renderer = renderer;
        this.gameScoreController = new FSEGameScoreController();
    }

    private void switchCurrentSceneControllerTo(FSESceneController sceneController) {
        currentSceneController = sceneController;
        currentSceneController.delegate = this;
        currentSceneController.scoreController = this.gameScoreController;
        currentSceneController.prepareToShow();
        renderer.switchToSceneController(sceneController);
    }

    private void switchStateTo(DCState state) {
        currentState = state;

        if (state == DCState.demensdeumLogo) {
            switchCurrentSceneControllerTo(new DCDemensdeumLogoSceneController());
        }
        else if (state == DCState.flameSteelEngineLogo) {
            switchCurrentSceneControllerTo(new DCFlameSteelEngineLogoController());
        }
        else if (state == DCState.start) {
            switchCurrentSceneControllerTo(new DCStartGameScreenSceneController());
        }
        else if (state == DCState.ingame) {
            switchCurrentSceneControllerTo(new DCIngameSceneController());
        }
        else if (state == DCState.gameOver) {
            switchCurrentSceneControllerTo(new DCGameOverSceneController());
        }
    }

    public void startGame() {
        this.switchStateTo(DCState.demensdeumLogo);
    }

    @Override
    public void sceneControllerDidEnd(FSESceneController controller) {
        if (currentState == DCState.demensdeumLogo) {
            switchStateTo(DCState.flameSteelEngineLogo);
        }
        else if (currentState == DCState.flameSteelEngineLogo) {
            switchStateTo(DCState.start);
        }
        else if (currentState == DCState.start) {
            switchStateTo(DCState.ingame);
        }
        else if (currentState == DCState.ingame) {
            switchStateTo(DCState.gameOver);
        }
        else if (currentState == DCState.gameOver) {
            switchStateTo(DCState.ingame);
        }
    }

}
