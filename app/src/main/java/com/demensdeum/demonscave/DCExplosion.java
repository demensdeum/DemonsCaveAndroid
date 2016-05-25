package com.demensdeum.demonscave;

import com.demensdeum.flamesteelengine.FSEObject;

import org.rajawali3d.materials.plugins.SpriteSheetMaterialPlugin;

/**
 * Created by demensdeum on 25.05.16.
 */
public class DCExplosion extends FSEObject {

    public DCExplosion() {
        super(R.drawable.explosion,1,1);

        SpriteSheetMaterialPlugin spriteSheetMaterialPlugin = new SpriteSheetMaterialPlugin(5, 1, 4, 5);
        spriteSheetMaterialPlugin.play();
        this.getMaterial().addPlugin(spriteSheetMaterialPlugin);

    }

}
