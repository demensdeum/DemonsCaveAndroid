package com.demensdeum.demonscave;

import android.opengl.GLES20;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 11.05.16.
 */
public class DCPipe extends FSEObject {

    private double kLeftBorder = -0.9f;
    private double speed = 0.01f;

    public DCPipe(double layer) {
        super(R.drawable.pipe, 0.1f, 1);

        this.setBlendingEnabled(true);
        this.setBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

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
