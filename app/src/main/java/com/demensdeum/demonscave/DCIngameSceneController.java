package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSECollisionDetectionController;
import com.demensdeum.flamesteelengine.FSECollisionDetectionControllerDelegate;
import com.demensdeum.flamesteelengine.FSEEvent;
import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSESceneController;

/**
 * Created by demensdeum on 15.05.16.
 */
public class DCIngameSceneController extends FSESceneController implements FSECollisionDetectionControllerDelegate {

    private FSECollisionDetectionController collisionDetectionController;
    private DCEnemyController enemyController;
    private DCIngameScene ingameScene;

    private boolean explosionAnimation = false;
    private int explosionAnimationTick = 0;

    private final int kExplosionAnimationEndTick = 24;

    private int speedUpTick = 0;
    final private int speedUpMaxTick = 100;

    DCIngameSceneController() {
        FSEScene scene = new DCIngameScene();
        this.setScene(scene);

        ingameScene = (DCIngameScene)scene;

        collisionDetectionController = new FSECollisionDetectionController();
        collisionDetectionController.objects = scene.getObjects();
        collisionDetectionController.delegate = this;

        enemyController = new DCEnemyController(ingameScene);
    }

    public void touchEvent() {
        FSEScene scene = this.getScene();
        ((DCIngameScene)scene).getWerj().switchDirection();
    }

    private void explosionAnimationStep() {
        if (explosionAnimation) {
            explosionAnimationTick++;
            if (explosionAnimationTick >= kExplosionAnimationEndTick) {
                this.delegate.sceneControllerDidEnd(this);
            }
        }
    }

    private void applySpeedUp() {
        ingameScene.getPipeOne().applySpeedUp();
        ingameScene.getPipeTwo().applySpeedUp();
        ingameScene.getCoin().applySpeedUp();
    }

    private void speedUpStep() {
        speedUpTick++;
        if (speedUpTick >= speedUpMaxTick)
        {
            speedUpTick = 0;
            this.applySpeedUp();
        }
    }

    public void step() {
        super.step();
        collisionDetectionController.step();
        enemyController.step();
        explosionAnimationStep();
        speedUpStep();
    }

    private void explosionAnimation() {
        double x = ingameScene.getWerj().getX();
        double y = ingameScene.getWerj().getY();

        DCExplosion explosion = ingameScene.getExplosion();
        explosion.setX(x);
        explosion.setY(y);
        explosion.setVisible(true);
        explosion.playAnimation();

        ingameScene.getPipeOne().setSpeed(0);
        ingameScene.getPipeTwo().setSpeed(0);
        ingameScene.getCoin().setSpeed(0);

        ingameScene.getWerj().setVisible(false);

        explosionAnimation = true;
    }

    private void pickupCoin(DCCoin coin) {
        if (coin.isVisible()) {
            coin.setVisible(false);

            this.scoreController.addScore(100);
        }
    }

    private void pickupCoinByEnemy(DCCoin coin) {
        coin.setVisible(false);
    }

    @Override
    public void collisionDetectionControllerDidFoundCollisionBetween(FSEObject bodyA, FSEObject bodyB) {

        if (explosionAnimation)
        {
            return;
        }

        if (bodyA.collisionIdentifier == DCCollisionIdentifiers.Werj.ordinal() &&
                bodyB.collisionIdentifier == DCCollisionIdentifiers.Pipe.ordinal())
        {
            this.explosionAnimation();
        }

        if (bodyA.collisionIdentifier == DCCollisionIdentifiers.Werj.ordinal() &&
                bodyB.collisionIdentifier == DCCollisionIdentifiers.Coin.ordinal())
        {
            this.pickupCoin((DCCoin)bodyB);
        }

        if (bodyA.collisionIdentifier == DCCollisionIdentifiers.Enemy.ordinal() &&
                bodyB.collisionIdentifier == DCCollisionIdentifiers.Coin.ordinal())
        {
            this.pickupCoinByEnemy((DCCoin)bodyB);
        }
    }

    public void handleEvent(FSEEvent event) {
        switch (event) {
            case PipeRespawn:
                this.scoreController.addScore(1);
                break;

            default:
                break;
        }
    }
}
