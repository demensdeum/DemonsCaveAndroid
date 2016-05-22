package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;

/**hohhhl
 * Created by demensdeum on 10.05.16.
 */
public class DCIngameScene extends FSEScene {

    private DCWerj werj;

    public DCIngameScene() {
        DCBackground background = new DCBackground();
        werj = allocateWerj();
        DCEnemy enemy = allocateEnemy();
        DCPipe pipe = allocatePipe();
        DCPipe pipeTwo = allocatePipeTwo();
        DCCoin coin = allocateCoin();

        addObject(pipe);
        addObject(werj);
        addObject(pipeTwo);
        addObject(enemy);
        addObject(coin);
        addObject(background);
    }

    public DCWerj getWerj() {
        return werj;
    }

    private DCPipe allocatePipeTwo() {
        DCPipe pipe = new DCPipe();

        pipe.setX(1);
        pipe.randomizeY();

        return pipe;
    }

    private DCPipe allocatePipe() {
        DCPipe pipe = new DCPipe();

        pipe.setX(2);
        pipe.randomizeY();

        return pipe;
    }

    private DCWerj allocateWerj() {
        DCWerj werj = new DCWerj();

        werj.setX(-0.35);
        werj.setY(0.35);

        return werj;
    }

    private DCEnemy allocateEnemy() {
        DCEnemy enemy = new DCEnemy();

        enemy.setX(0.35);
        enemy.setY(0.35);

        return enemy;
    }

    private DCCoin allocateCoin() {
        DCCoin coin = new DCCoin();

        coin.setX(1.5);
        coin.setY(0);

        return coin;
    }

}
