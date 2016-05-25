package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;

import org.rajawali3d.materials.plugins.SpriteSheetMaterialPlugin;

/**
 * Created by demensdeum on 25.05.16.
 */
public class DCExplosion extends FSEObject {

    private SpriteSheetMaterialPlugin spriteSheetMaterialPlugin;

    public DCExplosion() {
        super(R.drawable.explosion,0.32f,0.53f);

        SpriteSheetMaterialPlugin spriteSheetMaterialPlugin = new SpriteSheetMaterialPlugin(5, 1, 12, 5);
        this.getMaterial().addPlugin(spriteSheetMaterialPlugin);
        this.spriteSheetMaterialPlugin = spriteSheetMaterialPlugin;

    }

    public void playAnimation() {
        spriteSheetMaterialPlugin.play();
    }

}
