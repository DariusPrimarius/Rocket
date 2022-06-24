package com.primasoft.gamescaffold.graphics;

import android.graphics.Canvas;
import com.primasoft.gamescaffold.Utils;
import com.primasoft.gamescaffold.GameDisplay;
import com.primasoft.gamescaffold.gameobject.Player;
import com.primasoft.gamescaffold.gamepanel.Joystick;

public class Animator {
    private Sprite[] playerSpriteArray;
    private int idxNotMovingFrame = 0;
    private int idxMovingFrame = 1;
    private int updatesBeforeNextMoveFrame=1;
    private static final int MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME = 2;

    public Animator(Sprite[] playerSpriteArray) {
        this.playerSpriteArray = playerSpriteArray;
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay, Player player, Joystick joystick) {
        switch (player.getPlayerState().getState()) {
            case NOT_MOVING:
                updatesBeforeNextMoveFrame--;
                if(updatesBeforeNextMoveFrame == 0) {
                    updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
                    toggleIdxMovingFrame();
                }
                drawFrame(canvas, gameDisplay, player, playerSpriteArray[idxMovingFrame], joystick);
                break;
            case STARED_MOVING:
                updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
                drawFrame(canvas, gameDisplay, player, playerSpriteArray[idxMovingFrame], joystick);
                break;
            case IS_MOVING:
                updatesBeforeNextMoveFrame--;
                if(updatesBeforeNextMoveFrame == 0) {
                    updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
                    toggleIdxMovingFrame();
                }
                drawFrame(canvas, gameDisplay, player, playerSpriteArray[idxMovingFrame], joystick);
                break;
            default:
                break;
        }
    }

    private void toggleIdxMovingFrame() {
        if(idxMovingFrame == 1)
            idxMovingFrame = 2;
        else
            idxMovingFrame = 1;
    }

    public void drawFrame(Canvas canvas, GameDisplay gameDisplay, Player player, Sprite sprite, Joystick joystick) {
        canvas.save();
        canvas.scale((float) 0.2,(float) 0.2);
        canvas.rotate(
                (float) joystick.getAngle(),
                (float) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX())*5,
                (float) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY())*5);
        sprite.draw(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX())*5 - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY())*5 - sprite.getHeight()/2
        );
        canvas.restore();
    }
}
