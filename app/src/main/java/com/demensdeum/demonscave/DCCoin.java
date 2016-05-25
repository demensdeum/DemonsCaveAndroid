package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;

import org.rajawali3d.materials.plugins.SpriteSheetMaterialPlugin;

/**
 * Created by demensdeum on 15.05.16.
 */
public class DCCoin extends FSEObject {

    private double kLeftBorder = -0.9f;
    static double speed = 0.01f;

    public DCCoin() {
        super(R.drawable.coin, 0.0425f, 0.07f);
        this.collisionIdentifier = DCCollisionIdentifiers.Coin.ordinal();

        initializeAnimation();
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    private void initializeAnimation() {
        SpriteSheetMaterialPlugin spriteSheetMaterialPlugin = new SpriteSheetMaterialPlugin(5, 1, 10, 5);
        spriteSheetMaterialPlugin.play();
        this.getMaterial().addPlugin(spriteSheetMaterialPlugin);
    }

    private void moveLeft() {
        double x = this.getX();
        x -= speed;
        this.setX(x);
    }

    private double generateRespawnY() {
        boolean createFromBottom = Math.random() < 0.5;
        double offset = Math.random();
        if (offset > 0.3) {
            offset = 0.3;
        }

        if (createFromBottom) {
            return -offset;
        }
        else {
            return offset;
        }

    }

    private void respawn() {
        this.setX(1);
        this.setY(this.generateRespawnY());
        this.setVisible(true);
    }

    private void respawnIfNeeded() {
        double x = this.getX();
        if (x < kLeftBorder) {
            this.respawn();
        }
    }

    public void step() {
        this.moveLeft();
        this.respawnIfNeeded();
    }

}
