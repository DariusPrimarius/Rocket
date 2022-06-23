package com.primasoft.gamescaffold.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.primasoft.gamescaffold.R;

public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 512;
    private static final int SPRITE_HEIGHT_PIXELS = 512;
    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);
    }

    public Sprite[] getPlayerSpriteArray() {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(0*512, 0, 1*512, 512));
        spriteArray[1] = new Sprite(this, new Rect(1*512, 0, 2*512, 512));
        spriteArray[2] = new Sprite(this, new Rect(2*512, 0, 3*512, 512));
        return spriteArray;

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Sprite getCloudSprite1() {
        return getSpriteByIndex(1, 0);
    }

    public Sprite getCloudSprite2() {
        return getSpriteByIndex(1, 1);
    }

    public Sprite getCloudSprite3() {
        return getSpriteByIndex(1, 2);
    }

    public Sprite getCloudSprite4() {
        return getSpriteByIndex(1, 3);
    }

    public Sprite getCloudSprite5() {
        return getSpriteByIndex(1, 4);
    }

    private Sprite getSpriteByIndex(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(
                idxCol*SPRITE_WIDTH_PIXELS,
                idxRow*SPRITE_HEIGHT_PIXELS,
                (idxCol + 1)*SPRITE_WIDTH_PIXELS,
                (idxRow + 1)*SPRITE_HEIGHT_PIXELS
        ));
    }
}
