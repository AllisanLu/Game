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

    private int positionX;
    private int positionY;

    /**
     *
     * @param positionX The starting X coordinate of the Object that uses this class
     * @param positionY The starting Y coordinate of the Object that uses this class
     */
    public PhysicsEngine(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        accelerationY = -9.81;
        accelerationX = 0;
    }

    /**
     * Calculates acceleration to use for calculating velocity in the Y-direction.
     * @return
     */
    private double calculateAccelerationY() {

        return accelerationY;
    }

    /**
     * Calculates acceleration to use for calculating velocity in the X-direction.
     * @return
     */
    private double calculateAccelerationX() {

        return accelerationX;
    }

    /**
     * Calculates velocity to use for calculating position in the Y-direction.
     * @return
     */
    private double calculateVelocityY() {
        velocityY += calculateAccelerationY();
        return velocityY;
    }

    /**
     * Calculates velocity to use for calculating position in the X-direction.
     * @return
     */
    private double calculateVelocityX() {
        velocityX += calculateAccelerationX();
        return velocityX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    /**
     * Called to when the player presses a key for a jump.
     * Checks whether the Player is on ground or not before.
     * Needs to check for collision.
     */
    public void moveUp() {

    }

    /**
     * Called to when the player presses key for moving right.
     * Needs to check for collision.
     */
    public void moveRight() {

    }

    /**
     * Called to when the player presses key for moving left.
     * Needs to check for collision.
     */
    public void moveLeft() {

    }
}
