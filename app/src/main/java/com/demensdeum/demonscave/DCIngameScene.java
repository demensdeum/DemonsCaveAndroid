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
        DCEnemy enemy = allocateEnemy();
        DCPipe pipe = allocatePipe();
        DCPipe pipeTwo = allocatePipeTwo();
        DCCoin coin = allocateCoin();

        addObject(background);
        addObject(werj);
        addObject(enemy);
        addObject(pipe);
        addObject(pipeTwo);
        addObject(coin);
    }

    public DCWerj getWerj() {
        return werj;
    }

    private DCPipe allocatePipeTwo() {
        DCPipe pipe = new DCPipe(4);

        pipe.setX(1);

        return pipe;
    }

    private DCPipe allocatePipe() {
        DCPipe pipe = new DCPipe(3);

        pipe.setX(2);

        return pipe;
    }

    private DCWerj allocateWerj() {
        DCWerj werj = new DCWerj(2);

        werj.setX(-0.35);
        werj.setY(0.35);

        return werj;
    }

    private DCEnemy allocateEnemy() {
        DCEnemy enemy = new DCEnemy(2);

        enemy.setX(0.35);
        enemy.setY(0.35);

        return enemy;
    }

    private DCCoin allocateCoin() {
        DCCoin coin = new DCCoin(5);

        coin.setX(1.5);
        coin.setY(0);

        return coin;
    }

}
