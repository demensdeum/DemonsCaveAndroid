package com.demensdeum.demonscave;

import android.opengl.GLES20;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 11.05.16.
 */
public class DCEnemy extends FSEObject {

    public DCEnemy(double layer) {
        super(R.drawable.enemy, 0.178f,0.25f);

        this.setBlendingEnabled(true);
        this.setBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        this.setLayer(layer);
    }
}
