package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;

/**
 * Created by demensdeum on 10.05.16.
 */
public class DCIngameScene extends FSEScene {

    public DCIngameScene() {
        DCBackground background = new DCBackground(0);
        DCWerj werj = new DCWerj(1);
        DCEnemy enemy = new DCEnemy(2);
        DCPipe pipe = new DCPipe(3);
        DCPipe pipeTwo = new DCPipe(4);

        this.addObject(background);
        this.addObject(werj);
        this.addObject(enemy);
        this.addObject(pipe);
        this.addObject(pipeTwo);
    }

}
