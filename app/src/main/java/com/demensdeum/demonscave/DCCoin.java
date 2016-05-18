package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 15.05.16.
 */
public class DCCoin extends FSEObject {

    private double kLeftBorder = -0.9f;
    final static double speed = 0.01f;

    public DCCoin(double layer) {
        super(R.drawable.coin, 0.0425f, 0.07f);
    }

    private void moveLeft() {
        double x = this.getX();
        x -= speed;
        this.setX(x);
    }

    private void respawn() {
        this.setX(1);
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
