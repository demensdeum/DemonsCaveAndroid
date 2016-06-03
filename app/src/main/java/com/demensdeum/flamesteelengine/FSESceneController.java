package com.demensdeum.flamesteelengine;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by demensdeum on 14.05.16.
 */
public class FSESceneController {

    private FSEScene scene;
    public FSESceneControllerDelegate delegate;
    public FSEGameScoreController scoreController;

    public void setScene(FSEScene scene) {
        this.scene = scene;
        this.scene.sceneController = this;
    }

    public FSEScene getScene() {
        return this.scene;
    }

    public void prepareToShow() {
        this.scene.prepareToShow();
    }

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

    public void handleEvent(FSEEvent event) {

    }

}
