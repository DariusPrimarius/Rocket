package com.primasoft.gamescaffold.gameobject;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.primasoft.gamescaffold.GameLoop;
import com.primasoft.gamescaffold.R;

public class Spell extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 800.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Spell(Context context, Player spellcaster, int radius) {
        super(
            context,
            ContextCompat.getColor(context, R.color.spell),
            spellcaster.getPositionX(),
            spellcaster.getPositionY(),
                25
        );
        velocityX = spellcaster.getDirectionX()*MAX_SPEED;
        velocityY = spellcaster.getDirectionY()*MAX_SPEED;
        this.radius = getRadius();
    }

    @Override
    public void update() {
        positionX = positionX + velocityX;
        positionY = positionY + velocityY;
    }
}
