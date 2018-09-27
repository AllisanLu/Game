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
    private final double maxVelocityX;
    private double velocityY;
    private final double maxVelocityY;

    private double positionX;
    private double positionY;

    private double width;
    private double height;

    /**
     *
     * @param positionX The starting X coordinate of the Object that uses this class
     * @param positionY The starting Y coordinate of the Object that uses this class
     */
    public PhysicsEngine(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        accelerationY = .5;
        accelerationX = .4;

        velocityX = 0;
        maxVelocityX = 10;
        velocityY = 0;
        maxVelocityY = 15;

        width = 30;
        height = 30;

    }

    /**
     * Calculates velocity to use for calculating position in the Y-direction.
     * @return
     */
    private void calculateVelocityY() {
        velocityY += accelerationY;
    }

    /**
     * Calculates velocity to use for calculating position in the X-direction.
     * @return
     */
    private void calculateVelocityX(float direction) {
        velocityX += direction * accelerationX;
    }

    private double calculatePositionY() {
        calculateVelocityY();
        if(velocityY > 0 && positionY >= GUIDriver.getScreenHeight() - height){
            velocityY = 0;
            return GUIDriver.getScreenHeight() - height;
        }
        if(velocityY < 0 && positionY <= 0) {
            velocityY = 0;
            return 0;
        }
        if(velocityY >= maxVelocityY)
            velocityY = maxVelocityY;
        else if(velocityY <= -maxVelocityY) {
            velocityY = -maxVelocityY;
        }
        return positionY + velocityY;
    }

    private double calculatePositionX() {
        if(velocityX > 0 && positionX >= GUIDriver.getScreenWidth() - width) {
            velocityX = 0;
            return GUIDriver.getScreenWidth() - width;
        }
        if(velocityX < 0 && positionX <= 0) {
            velocityX = 0;
            return 0;
        }
        if(velocityX >= maxVelocityX)
            velocityX = maxVelocityX;
        else if(velocityX <= -maxVelocityX) {
            velocityX = -maxVelocityX;
        }
        velocityX /= 1.05;
        return positionX + velocityX;
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
            if(positionY == GUIDriver.getScreenHeight() - height) {
                velocityY = -30;
            }
        }

    /**
     * Called to when the player presses key for moving right.
     * Needs to check for collision.
     */
    public void moveRight() {
            calculateVelocityX(1);
    }

    /**
     * Called to when the player presses key for moving left.
     * Needs to check for collision.
     */
    public void moveLeft() {
            calculateVelocityX(-1);
    }

    /**
     * Called every iteration to check for the movement.
     * TODO: rework methods so this works.
     */
    public void updatePosition() {
        positionX = calculatePositionX();
        positionY = calculatePositionY();
    }
}