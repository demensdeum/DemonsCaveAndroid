package com.demensdeum.flamesteelengine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;

/**
 * Created by demensdeum on 30.05.16.
 */
public class FSEText {

    static public Bitmap textAsBitmap(String text, float textSize, int textColor) {
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.LEFT);
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 0.5f); // round
        int height = (int) (baseline + paint.descent() + 0.5f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint);
        return image;
    }

    static public FSEObject allocateText(String text, float width, float height) {
        Bitmap textBitmap = textAsBitmap(text,64,0xFF0000);

        Material material = new Material();
        material.setColor(0);

        Texture texture = new Texture("textTexture",textBitmap);

        try {
            material.addTexture(texture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }

        FSEObject textPlane = new FSEObject(width, height);

        textPlane.setMaterial(material);

        return textPlane;
    }

}
