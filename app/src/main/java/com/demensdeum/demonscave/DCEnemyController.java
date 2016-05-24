package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;

import java.util.LinkedList;

/**
 * Created by demensdeum on 24.05.16.
 */
public class DCEnemyController {

    DCPipe pipeOne = null;
    DCPipe pipeTwo = null;

    DCEnemy enemy = null;

    DCEnemyController(DCIngameScene scene) {
        pipeOne = scene.getPipeOne();
        pipeTwo = scene.getPipeTwo();

        enemy = scene.getEnemy();
    }

    public void step() {

        DCPipe targetPipe = pipeOne;

        if (pipeOne.getX() > pipeTwo.getX()) {
            targetPipe = pipeOne;
        }
        else if (pipeTwo.getX() > pipeOne.getX())
        {
            targetPipe = pipeTwo;
        }

        if (targetPipe.getX() > 0.7)
        {
            return;
        }

        if (targetPipe.getY() > 0) {
            enemy.moveDown = true;
        }
        else {
            enemy.moveDown = false;
        }
    }

}
