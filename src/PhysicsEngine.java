import javafx.scene.shape.Rectangle;

import java.awt.*;

/**
 *  This class should be the ultimate decider of where the players are moving goes.
 *  Everything in this class should be calculated off of the acceleration on the players.
 *  Should not let objects out of the scene and not let them go into blocks.
 *  x: right is positive, and left is negative.
 *  y: up is positive, and down is negative.
 */

public class  PhysicsEngine {

    private double accelerationY;
    private double accelerationX;

    private double velocityX;
    private double velocityY;

    private double positionX;
    private double positionY;

    private double sizeX;
    private double sizeY;

    /**
     *
     * @param positionX The starting X coordinate of the Object that uses this class
     * @param positionY The starting Y coordinate of the Object that uses this class
     */
    public PhysicsEngine(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        accelerationY = 9.81;
        accelerationX = 2;
        velocityX = 0;
        velocityY = 0;
    }

    /**
     * Calculates velocity to use for calculating position in the Y-direction.
     * @return
     */
    private void calculateVelocityY(float direction) {
        velocityY += accelerationY;
    }

    /**
     * Calculates velocity to use for calculating position in the X-direction.
     * @return
     */
    private void calculateVelocityX(float direction) {
        velocityX += direction * accelerationX;
    }

    private void calculatePositionY(float direction) {                         //when updating lastNanoTime, call getPositionX last although i doubt it would matter much since yea too less of an impact
        calculateVelocityY(direction);
        positionY += velocityY;
    }

    private void calculatePositionX(float direction) {
        calculateVelocityX(direction);
        positionX += velocityX;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    /**
     * Called to when the player presses a key for a jump.
     * Checks whether the Player is on ground or not before.
     * Needs to check for collision.
     */
    public void moveUp() {
        if(positionY == GUIDriver.getScreenHeight())
            velocityY = 0;
        else if(positionY == 0) {
            velocityY = 50;
        }
        calculatePositionY(1);
    }

    /**
     * Called to when the player presses key for moving right.
     * Needs to check for collision.
     */
    public void moveRight() {
        if(positionX >= GUIDriver.getScreenWidth() - 30) {
            velocityX = 0;
            positionX = GUIDriver.getScreenWidth() - 30;
        }
        else
            calculatePositionX(1);
    }

    /**
     * Called to when the player presses key for moving left.
     * Needs to check for collision.
     */
    public void moveLeft() {
        if(positionX <= 0) {
            velocityX = 0;
            positionX = 0;
        }
        else
            calculatePositionX(-1);
    }

    /**
     * Called every iteration to check for the movement.
     * TODO: rework methods so this works.
     */
    public void updatePosition() {
        calculatePositionY(1);
        calculateVelocityX(1);
    }
}