package com.demensdeum.demonscave;

import android.content.Context;
import android.view.MotionEvent;
import android.util.Log;

import org.rajawali3d.cameras.Camera2D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

/**
 * Created by demensdeum on 30.04.16.
 */
public class Renderer extends RajawaliRenderer {

    private DirectionalLight directionalLight;
    private Sphere earthSphere;
    private Plane plane;
    private Camera2D gameCamera;

    public Renderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    protected void initializeCamera() {
        gameCamera = new Camera2D();

        getCurrentScene().addCamera(gameCamera);
        getCurrentScene().switchCamera(gameCamera);
    }

    protected void initializeEarth() {
        Material material = new Material();
        material.enableLighting(false);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);

        Texture earthTexture = new Texture("Earth", R.drawable.earthtruecolor_nasa_big);
        try{
            material.addTexture(earthTexture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }

        earthSphere = new Sphere(0.1f, 24, 24);
        earthSphere.setPosition(0,0,0);
        earthSphere.setMaterial(material);
    }

    protected void initializePlane() {
        Material material = new Material();
        material.enableLighting(false);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);

        Texture earthTexture = new Texture("Earth", R.drawable.demensdeum_logo);
        try{
            material.addTexture(earthTexture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }

        plane = new Plane(1, 1, 2, 2);
        plane.setPosition(0,0,0);
        plane.setMaterial(material);
    }

    @Override
    protected void initScene() {
        initializeCamera();
        //initializeEarth();
        initializePlane();

        //getCurrentScene().addChild(earthSphere);
        getCurrentScene().addChild(plane);
        getCurrentCamera().setZ(200.2f);
    }

    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);
        //earthSphere.rotate(Vector3.Axis.Y, 1.0);
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }
}
