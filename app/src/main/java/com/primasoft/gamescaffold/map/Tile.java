package com.primasoft.gamescaffold.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.primasoft.gamescaffold.graphics.SpriteSheet;

abstract class Tile {

    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    public enum TileType {
        WATER_TILE,
        LAVA_TILE,
        GROUND_TILE,
        GRASS_TILE,
        TREE_TILE
    }

    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {

        switch(TileType.values()[idxTileType]) {

            case WATER_TILE:
                return new CloudTile1(spriteSheet, mapLocationRect);
            case LAVA_TILE:
                return new CloudTile2(spriteSheet, mapLocationRect);
            case GROUND_TILE:
                return new CloudTile3(spriteSheet, mapLocationRect);
            case GRASS_TILE:
                return new CloudTile4(spriteSheet, mapLocationRect);
            case TREE_TILE:
                return new CloudTile5(spriteSheet, mapLocationRect);
            default:
                return null;
        }

    }

    public abstract void draw(Canvas canvas);
}
