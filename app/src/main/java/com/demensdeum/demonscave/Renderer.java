package com.demensdeum.demonscave;

import android.content.Context;
import android.view.MotionEvent;
import android.util.Log;

import com.demensdeum.flamesteelengine.FSEObject;
import com.demensdeum.flamesteelengine.FSEScene;
import com.demensdeum.flamesteelengine.FSESceneController;

import org.rajawali3d.cameras.Camera2D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by demensdeum on 30.04.16.
 */
public class Renderer extends RajawaliRenderer {

    private FSESceneController currentSceneController;
    private DCGameController gameController;
    private Camera2D gameCamera;

    public Renderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    private void initializeCamera() {
        gameCamera = new Camera2D();
        gameCamera.setZ(100);

        getCurrentScene().addCamera(gameCamera);
        getCurrentScene().switchCamera(gameCamera);
    }

    private void initializeGameController() {
        this.gameController = new DCGameController(this);
    }

    public void showScene(FSEScene scene) {

        getCurrentScene().clearChildren();

        LinkedList<FSEObject> objects = scene.getObjects();

        ListIterator<FSEObject> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            getCurrentScene().addChild(iterator.next());
        }

    }

    @Override
    protected void initScene() {
        initializeCamera();
        initializeGameController();
        this.gameController.startGame();
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

        if (event.getActionMasked() == MotionEvent.ACTION_DOWN)
        {
            if (currentSceneController != null) {
                currentSceneController.touchEvent();
            }
        }
    }

    public void switchToSceneController(FSESceneController sceneController) {
        this.showScene(sceneController.getScene());
        this.currentSceneController = sceneController;
    }

    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);
        this.currentSceneController.step();
    }
}
