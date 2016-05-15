package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;

/**hohhhl
 * Created by demensdeum on 10.05.16.
 */
public class DCIngameScene extends FSEScene {

    private DCWerj werj;

    public DCIngameScene() {
        DCBackground background = new DCBackground(0);
        werj = allocateWerj();
        //DCEnemy enemy = new DCEnemy(2);
        //DCPipe pipe = new DCPipe(3);
        //DCPipe pipeTwo = new DCPipe(4);

        this.addObject(background);
        this.addObject(werj);
        //this.addObject(enemy);
        //this.addObject(pipe);
        //this.addObject(pipeTwo);
    }

    public DCWerj getWerj() {
        return werj;
    }

    private DCWerj allocateWerj() {
        DCWerj werj = new DCWerj(2);

        werj.setX(-0.35);
        werj.setY(0.35);

        return werj;
    }

}
