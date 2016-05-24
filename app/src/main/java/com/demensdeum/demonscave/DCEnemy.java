package com.demensdeum.demonscave;

import android.opengl.GLES20;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 11.05.16.
 */
public class DCEnemy extends FSEObject {

    private final static double kTopBorder = 0.35;
    private final static double kBottomBorder = -0.35;

    final static double speed = 0.036f;
    public boolean moveDown = true;

    public DCEnemy() {
        super(R.drawable.enemy, 0.178f,0.25f);
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

    public void step() {
        if (moveDown) {
            this.moveDown();
        }
        else {
            this.moveUp();
        }

        this.fixPositionIfNeeded();
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
}
