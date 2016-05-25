package com.demensdeum.flamesteelengine;

import android.util.Log;

import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.primitives.Plane;

/**
 * Created by demensdeum on 10.05.16.
 */
public class FSEObject extends FSEPlane {

    public FSEScene scene;

    public int collisionIdentifier = -1;
    protected boolean isCollides = true;

    public FSEObject(int resourceId, float width, float height) {
        super(width,height,2,2);

        Material material = new Material();
        material.setColor(0);

        Texture texture = new Texture("Texture", resourceId);
        try {
            material.addTexture(texture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }

        this.setMaterial(material);

        this.setTransparent(true);
    }

    public void setLayer(double layer) {
        double x = this.getX();
        double y = this.getY();

        this.setPosition(x, y, layer);
    }

    public void step() {

    }

}
