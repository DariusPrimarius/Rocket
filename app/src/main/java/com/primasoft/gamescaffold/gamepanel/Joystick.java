package com.primasoft.gamescaffold.gamepanel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

    private int outerCircleCenterPositionX;
    private int outerCircleCenterPositionY;
    private int innerCircleCenterPositionX;
    private int innerCircleCenterPositionY;

    private int outerCircleRadius;
    private int innerCircleRadius;

    private Paint innerCirclePaint;
    private Paint outerCirclePaint;
    private boolean isPressed = false;
    private double joystickCenterToTouchDistance;
    private double actuatorX;
    private double actuatorY = -1;
    double actuatorInnerCircleX;
    double actuatorInnerCircleY;
    private double touchPositionX=1;
    private double deltaDistance;
    private double deltaX;
    private double deltaY;
    private double angle;

    public Joystick(int centerPositionX, int centerPositionY, int outerCircleRadius, int innerCircleRadius) {
        
        // Outer and inner circle make up the joystick
        outerCircleCenterPositionX = centerPositionX;
        outerCircleCenterPositionY = centerPositionY;
        innerCircleCenterPositionX = centerPositionX;
        innerCircleCenterPositionY = centerPositionY;
        
        // Radii of circles
        this.outerCircleRadius = outerCircleRadius;
        this.innerCircleRadius = innerCircleRadius;

        // paint of circles
        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void draw(Canvas canvas) {
        // Draw outer circle
        canvas.drawCircle(
                outerCircleCenterPositionX,
                outerCircleCenterPositionY,
                outerCircleRadius,
                outerCirclePaint
        );

        // Draw inner circle
        canvas.drawCircle(
                innerCircleCenterPositionX,
                innerCircleCenterPositionY,
                innerCircleRadius,
                innerCirclePaint
        );
    }

    public void update() {
        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition() {


        innerCircleCenterPositionX = (int) (outerCircleCenterPositionX + actuatorInnerCircleX*outerCircleRadius);
        innerCircleCenterPositionY = (int) (outerCircleCenterPositionY + actuatorInnerCircleY*outerCircleRadius);
    }

    public void setActuator(double touchPositionX, double touchPositionY) {
        this.deltaX = touchPositionX - outerCircleCenterPositionX;
        this.deltaY = touchPositionY - outerCircleCenterPositionY;
        this.deltaDistance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        this.touchPositionX = touchPositionX;


        if(deltaDistance < outerCircleRadius) {
            actuatorX = deltaX/outerCircleRadius;
            actuatorY = deltaY/outerCircleRadius;
            actuatorInnerCircleX= actuatorX;
            actuatorInnerCircleY= actuatorY;
        } else {
            actuatorX = deltaX/deltaDistance;
            actuatorY = deltaY/deltaDistance;
            actuatorInnerCircleX= actuatorX;
            actuatorInnerCircleY= actuatorY;

        }
    }

    public boolean isPressed(double touchPositionX, double touchPositionY) {
        joystickCenterToTouchDistance = Math.sqrt(
            Math.pow(outerCircleCenterPositionX - touchPositionX, 2) +
            Math.pow(outerCircleCenterPositionY - touchPositionY, 2)
        );
        return joystickCenterToTouchDistance < outerCircleRadius;
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public double getActuatorX() {
        return actuatorX;
    }

    public double getActuatorY() {
        return actuatorY;
    }

    public void resetActuator() {
        actuatorInnerCircleX = 0;
        actuatorInnerCircleY = 0;
    }
    public double getAngle(){
        if(deltaDistance == 0) {
            angle = 0;
            return angle;
        } else {
                double d1 = Math.sqrt((outerCircleCenterPositionY * outerCircleCenterPositionY));
                double d2 = Math.sqrt((deltaX * deltaX + deltaY * deltaY));
                if (touchPositionX >= outerCircleCenterPositionX) {
                    this.angle = Math.toDegrees(Math.acos((-outerCircleCenterPositionY * deltaY) / (d1 * d2)));
                } else
                    this.angle = 360 - Math.toDegrees(Math.acos((-outerCircleCenterPositionY * deltaY) / (d1 * d2)));
                return this.angle;
            }
    }
}
