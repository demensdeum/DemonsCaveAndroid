package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSECollisionDetectionController;
import com.demensdeum.flamesteelengine.FSECollisionDetectionControllerDelegate;
import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 15.05.16.
 */
public class DCIngameSceneController extends FSESceneController implements FSECollisionDetectionControllerDelegate {

    private FSECollisionDetectionController collisionDetectionController;

    DCIngameSceneController() {
        scene = new DCIngameScene();

        collisionDetectionController = new FSECollisionDetectionController();
        collisionDetectionController.objects = scene.getObjects();
        collisionDetectionController.delegate = this;
    }

    public void touchEvent() {
        ((DCIngameScene)scene).getWerj().switchDirection();
    }

    public void step() {
        super.step();
        collisionDetectionController.step();
    }

    private void explosionAnimation() {
        this.delegate.sceneControllerDidEnd(this);
    }

    @Override
    public void collisionDetectionControllerDidFoundCollisionBetween(FSEObject bodyA, FSEObject bodyB) {

        if (bodyA.collisionIdentifier == DCCollisionIdentifiers.Werj.ordinal() &&
                bodyB.collisionIdentifier == DCCollisionIdentifiers.Pipe.ordinal())
        {
            this.explosionAnimation();
        }
    }
}
