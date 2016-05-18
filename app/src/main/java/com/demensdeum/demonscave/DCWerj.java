package com.demensdeum.demonscave;

import android.opengl.GLES20;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 11.05.16.
 */
public class DCWerj extends FSEObject {

    private final static double kTopBorder = 0.35;
    private final static double kBottomBorder = -0.35;

    private boolean moveDown = true;
    final static double speed = 0.036f;

    public DCWerj(double layer) {
        super(R.drawable.werj, 0.15f,0.15f);

        this.setBlendingEnabled(true);
        this.setBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        this.setLayer(layer);
    }

    private void moveDown() {
        double y = this.getY();
        y -= this.speed;
        this.setY(y);
    }

    private void moveUp() {
        double y = this.getY();
        y += this.speed;
        this.setY(y);
    }

    private void fixPositionIfNeeded() {
        double y = this.getY();

        if (y > kTopBorder) {
            y = kTopBorder;
        }
        else if (y < kBottomBorder) {
            y = kBottomBorder;
        }

        this.setY(y);
    }

    public void step() {
        if (moveDown) {
            this.moveDown();
        }
        else {
            this.moveUp();
        }

        this.fixPositionIfNeeded();
    }

    public void switchDirection() {
        this.moveDown = !this.moveDown;
    }

}
