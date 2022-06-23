package com.primasoft.gamescaffold.map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.primasoft.gamescaffold.graphics.Sprite;
import com.primasoft.gamescaffold.graphics.SpriteSheet;

public class CloudTile3 extends Tile {
    private final Sprite sprite;

    public CloudTile3(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getCloudSprite3();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
