package com.demensdeum.flamesteelengine;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by demensdeum on 14.05.16.
 */
public class FSESceneController {

    public FSEScene scene;
    public FSESceneControllerDelegate delegate;

    public void step() {

        LinkedList<FSEObject> objects = scene.getObjects();

        ListIterator<FSEObject> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            FSEObject object = iterator.next();
            object.step();
        }

    }

    public void touchEvent() {

    }

}
