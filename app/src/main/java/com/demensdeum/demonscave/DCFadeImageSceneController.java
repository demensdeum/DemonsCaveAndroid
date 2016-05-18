package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSESceneController;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by demensdeum on 18.05.16.
 */
public class DCFadeImageSceneController extends FSESceneController {

    private int tick = 0;

    public void step() {

        tick++;
        if (tick > 60) {
            this.delegate.sceneControllerDidEnd(this);
        }

        LinkedList<FSEObject> objects = scene.getObjects();

        ListIterator<FSEObject> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            FSEObject object = iterator.next();
            object.setTransparent(true);
            object.setAlpha(0.5f);
        }
    }

}
