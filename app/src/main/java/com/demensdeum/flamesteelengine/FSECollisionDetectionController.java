package com.demensdeum.flamesteelengine;

import android.util.Log;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by demensdeum on 23.05.16.
 */
public class FSECollisionDetectionController {

    public LinkedList<FSEObject> objects;
    public FSECollisionDetectionControllerDelegate delegate;

    public void step() {
        ListIterator<FSEObject> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            FSEObject object = iterator.next();
            if (object.isCollides) {
                triggerEventIfObjectCollidesWithAnother(object);
            }
        }
    }

    private void triggerEventIfObjectCollidesWithAnother(FSEObject master) {
        ListIterator<FSEObject> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            FSEObject object = iterator.next();
            if (object != master && object.isCollides) {
                triggerEventIfBodyCollidesWithBody(master, object);
            }
        }
    }

    private void triggerEventIfBodyCollidesWithBody(FSEObject bodyA, FSEObject bodyB) {
        double bodyAx = bodyA.getX();
        double bodyAy = bodyA.getY();
        double bodyAwidth = bodyA.getWidth();
        double bodyAheight = bodyA.getHeight();

        double bodyBx = bodyB.getX();
        double bodyBy = bodyB.getY();
        double bodyBwidth = bodyB.getWidth();
        double bodyBheight = bodyB.getHeight();

        if (bodyAx < bodyBx + bodyBwidth &&
                bodyAx + bodyAwidth > bodyBx &&
                bodyAy < bodyBy + bodyBheight &&
                bodyAheight + bodyAy > bodyBy)
        {
            delegate.collisionDetectionControllerDidFoundCollisionBetween(bodyA,bodyB);
        }

    }
}
