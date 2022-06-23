package com.primasoft.gamescaffold.map;

public class MapLayout {
    public static final int TILE_WIDTH_PIXELS = 512;
    public static final int TILE_HEIGHT_PIXELS = 512;
    public static final int NUMBER_OF_ROW_TILES = 2;
    public static final int NUMBER_OF_COLUMN_TILES = 2;

    private int[][] layout;

    public MapLayout() {
        initializeLayout();
    }

    public int[][] getLayout() {
        return layout;
    }

    private void initializeLayout() {
        layout = new int[NUMBER_OF_COLUMN_TILES][NUMBER_OF_COLUMN_TILES];
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                layout[i][j] = (int)(Math.random() * 5);
            }
        }
    }
}
