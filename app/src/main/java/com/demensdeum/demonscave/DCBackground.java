package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;

/**
 * Created by demensdeum on 11.05.16.
 */
public class DCBackground extends FSEObject {

    public DCBackground(double layer) {
        super(R.drawable.background,1,1);

        this.setLayer(layer);
    }

}
