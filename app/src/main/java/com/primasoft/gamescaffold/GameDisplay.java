package com.primasoft.gamescaffold;

import android.graphics.Rect;

import com.primasoft.gamescaffold.gameobject.GameObject;

public class GameDisplay {
    public final Rect DISPLAY_RECT;
    public final int widthPixels;
    public final int heightPixels;
    private final GameObject centerObject;
    private final double displayCenterX;
    private final double displayCenterY;
    private double gameToDisplayCoordinatesOffsetX;
    private double gameToDisplayCoordinatesOffsetY;
    private double gameCenterX;
    private double gameCenterY;
    private double forwardDisplayX = 0;
    private double backwardDisplayX = 0;
    private double forwardDisplayY = 0;
    private double backwardDisplayY = 0;


    public GameDisplay(int widthPixels, int heightPixels, GameObject centerObject) {
        this.centerObject = centerObject;
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
        DISPLAY_RECT = new Rect(0, 0, widthPixels, heightPixels);
        displayCenterX = widthPixels/2.0;
        displayCenterY = heightPixels/2.0;
        update();
    }

    public void update() {
        gameCenterX = centerObject.getPositionX();
        gameCenterY = centerObject.getPositionY();
        gameToDisplayCoordinatesOffsetX = displayCenterX - gameCenterX;
        gameToDisplayCoordinatesOffsetY = displayCenterY - gameCenterY;
    }

    public double gameToDisplayCoordinatesX(double x) {
        return x + gameToDisplayCoordinatesOffsetX;
    }

    public double gameToDisplayCoordinatesY(double y) {
        return y + gameToDisplayCoordinatesOffsetY;
    }


    public Rect getGameRect()  {
        //Repeat rect after changing position forward and backward X axis
        if(centerObject.getPositionX() >= (widthPixels + 1000)
                + (widthPixels * forwardDisplayX + 1)
                - (widthPixels * backwardDisplayX + 1)) {
            forwardDisplayX += 3;
        }
        else if(centerObject.getPositionX() <= -widthPixels
                - (widthPixels * backwardDisplayX + 1)
                + (widthPixels * forwardDisplayX + 1)) {
            backwardDisplayX += 3;
        }
        //Repeat rect after changing position forward and backward Y axis
        if(centerObject.getPositionY() >= (heightPixels + 1000)
                + (heightPixels * forwardDisplayY + 1)
                - (heightPixels * backwardDisplayY + 1)) {
            forwardDisplayY += 2;
        }
        else if(centerObject.getPositionY() <= -heightPixels
                - (heightPixels * backwardDisplayY + 1)
                + (heightPixels * forwardDisplayY + 1)) {
            backwardDisplayY += 2;
        }

        return new Rect(
                    (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX - widthPixels / 4),
                    (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY - heightPixels / 4),
                    (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX + widthPixels / 4),
                    (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY + heightPixels / 4)
            );
    }

    public Rect getGameRect2()  {
        //Repeat rect after changing position forward and backward X axis
        if(centerObject.getPositionX() >= (widthPixels + 1000)
                + (widthPixels * forwardDisplayX + 1)
                - (widthPixels * backwardDisplayX + 1)) {
            forwardDisplayX += 3;
        }
        else if(centerObject.getPositionX() <= -widthPixels
                - (widthPixels * backwardDisplayX + 1)
                + (widthPixels * forwardDisplayX + 1)) {
            backwardDisplayX += 3;
        }
        //Repeat rect after changing position forward and backward Y axis
        if(centerObject.getPositionY() >= (heightPixels + 1000)
                + (heightPixels * forwardDisplayY + 1)
                - (heightPixels * backwardDisplayY + 1)) {
            forwardDisplayY += 2;
        }
        else if(centerObject.getPositionY() <= -heightPixels
                - (heightPixels * backwardDisplayY + 1)
                + (heightPixels * forwardDisplayY + 1)) {
            backwardDisplayY += 2;
        }

        return new Rect(
                (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX - widthPixels / 4)+500,
                (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY - heightPixels / 4)+500,
                (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX + widthPixels / 4)+500,
                (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY + heightPixels / 4)+500
        );
    }
    public Rect getGameRect3()  {
        //Repeat rect after changing position forward and backward X axis
        if(centerObject.getPositionX() >= (widthPixels + 1000)
                + (widthPixels * forwardDisplayX + 1)
                - (widthPixels * backwardDisplayX + 1)) {
            forwardDisplayX += 3;
        }
        else if(centerObject.getPositionX() <= -widthPixels
                - (widthPixels * backwardDisplayX + 1)
                + (widthPixels * forwardDisplayX + 1)) {
            backwardDisplayX += 3;
        }
        //Repeat rect after changing position forward and backward Y axis
        if(centerObject.getPositionY() >= (heightPixels + 1000)
                + (heightPixels * forwardDisplayY + 1)
                - (heightPixels * backwardDisplayY + 1)) {
            forwardDisplayY += 2;
        }
        else if(centerObject.getPositionY() <= -heightPixels
                - (heightPixels * backwardDisplayY + 1)
                + (heightPixels * forwardDisplayY + 1)) {
            backwardDisplayY += 2;
        }

        return new Rect(
                (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX - widthPixels / 4)-800,
                (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY - heightPixels / 4)+800,
                (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX + widthPixels / 4)-800,
                (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY + heightPixels / 4)+800
        );
    }

    public Rect getGameRect4()  {
        //Repeat rect after changing position forward and backward X axis
        if(centerObject.getPositionX() >= (widthPixels + 1000)
                + (widthPixels * forwardDisplayX + 1)
                - (widthPixels * backwardDisplayX + 1)) {
            forwardDisplayX += 3;
        }
        else if(centerObject.getPositionX() <= -widthPixels
                - (widthPixels * backwardDisplayX + 1)
                + (widthPixels * forwardDisplayX + 1)) {
            backwardDisplayX += 3;
        }
        //Repeat rect after changing position forward and backward Y axis
        if(centerObject.getPositionY() >= (heightPixels + 1000)
                + (heightPixels * forwardDisplayY + 1)
                - (heightPixels * backwardDisplayY + 1)) {
            forwardDisplayY += 2;
        }
        else if(centerObject.getPositionY() <= -heightPixels
                - (heightPixels * backwardDisplayY + 1)
                + (heightPixels * forwardDisplayY + 1)) {
            backwardDisplayY += 2;
        }

        return new Rect(
                (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX - widthPixels / 4)-200,
                (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY - heightPixels / 4)-800,
                (int) (gameCenterX - widthPixels * forwardDisplayX + widthPixels * backwardDisplayX + widthPixels / 4)-200,
                (int) (gameCenterY - heightPixels * forwardDisplayY + heightPixels * backwardDisplayY + heightPixels / 4)-800
        );
    }

}
