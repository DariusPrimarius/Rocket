package com.primasoft.gamescaffold.map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.primasoft.gamescaffold.graphics.Sprite;
import com.primasoft.gamescaffold.graphics.SpriteSheet;

public class CloudTile4 extends Tile {
    private final Sprite sprite;

    public CloudTile4(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getCloudSprite4();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
