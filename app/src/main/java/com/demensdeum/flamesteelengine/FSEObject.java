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

    public FSEObject(int resourceId, float width, float height) {
        super(width,height,2,2);

        Material material = new Material();
        material.enableLighting(false);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);

        Texture texture = new Texture("Texture", resourceId);
        try {
            material.addTexture(texture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }

        this.setMaterial(material);
    }

}
