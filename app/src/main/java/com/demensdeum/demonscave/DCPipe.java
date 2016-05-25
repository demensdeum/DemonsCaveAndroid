package com.demensdeum.demonscave;

import android.opengl.GLES20;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 11.05.16.
 */
public class DCPipe extends FSEObject {

    private double kLeftBorder = -0.9f;
    private double speed = 0.01f;

    public DCPipe() {
        super(R.drawable.pipe, 0.14f, 1);
        this.collisionIdentifier = DCCollisionIdentifiers.Pipe.ordinal();
    }

    public void setSpeed(double newSpeed) {
        this.speed = newSpeed;
    }

    private void moveLeft() {
        double x = this.getX();
        x -= speed;
        this.setX(x);
    }

    private double generateRespawnY() {
        boolean createFromBottom = Math.random() < 0.5;
        double offset = Math.random();
        if (offset > 0.2) {
            offset = 0.2;
        }

        if (createFromBottom) {
            return -0.5 + offset;
        }
        else {
            return 0.5 - offset;
        }

    }

    public void randomizeY() {
        this.setY(this.generateRespawnY());
    }

    private void respawn() {
        this.setX(1);
        this.randomizeY();
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
