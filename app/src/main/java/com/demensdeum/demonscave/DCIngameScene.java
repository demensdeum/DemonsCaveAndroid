package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;

/**
 * Created by demensdeum on 10.05.16.
 */
public class DCIngameScene extends FSEScene {

    public DCIngameScene() {
        FSEObject demensdeumLogo = new FSEObject(R.drawable.demensdeum_logo,1,1);
        this.addObject(demensdeumLogo);
    }

}
