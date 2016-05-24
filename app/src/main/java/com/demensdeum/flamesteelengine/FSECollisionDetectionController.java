package com.demensdeum.flamesteelengine;

import android.util.Log;

import org.rajawali3d.bounds.BoundingBox;
import org.rajawali3d.math.vector.Vector3;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by demensdeum on 23.05.16.
 */

class FSECollisionDot {
    public double x;
    public double y;

    FSECollisionDot(double x,double y) {
        this.x = x;
        this.y = y;
    }

}

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

    private boolean boxesIntersects(BoundingBox boxA, BoundingBox boundingVolume) {

        BoundingBox boundingBox = (BoundingBox)boundingVolume;
        Vector3 otherMin = boundingBox.getTransformedMin();
        Vector3 otherMax = boundingBox.getTransformedMax();
        Vector3 min = boxA.getTransformedMin();
        Vector3 max = boxA.getTransformedMax();

        return (min.x < otherMax.x) && (max.x > otherMin.x) &&
                (min.y < otherMax.y) && (max.y > otherMin.y);
    }

    private void triggerEventIfBodyCollidesWithBody(FSEObject bodyA, FSEObject bodyB) {

        BoundingBox boxA = bodyA.getGeometry().getBoundingBox();
        BoundingBox boxB = bodyB.getGeometry().getBoundingBox();

        if (boxesIntersects(boxA,boxB))
        {
            delegate.collisionDetectionControllerDidFoundCollisionBetween(bodyA,bodyB);
        }

    }
}
