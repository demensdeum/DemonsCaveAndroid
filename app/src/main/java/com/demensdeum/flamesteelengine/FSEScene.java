package com.demensdeum.flamesteelengine;

import java.util.LinkedList;

/**
 * Created by demensdeum on 10.05.16.
 */
public class FSEScene {

    public FSESceneController sceneController;
    private LinkedList<FSEObject> objects;

    public LinkedList<FSEObject> getObjects() {
        if (this.objects == null) {
            this.objects = new LinkedList<FSEObject>();
        }

        return this.objects;
    }

    public void addObject(FSEObject object) {
        object.scene = this;
        this.getObjects().push(object);
    }

    public void prepareToShow() {

    }

    public void handleEvent(FSEEvent event) {
        this.sceneController.handleEvent(event);
    }
}
