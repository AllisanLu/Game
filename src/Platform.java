import javafx.scene.paint.Color;

public class Platform {

    private int[] positionEdgeX;
    private int[] positionEdgeY;
    private Color color;

    public Platform(int[] positionEdgeX, int[] positionEdgeY, Color color) {
        if(positionEdgeX.length == positionEdgeY.length) {
            this.positionEdgeX = positionEdgeX;
            this.positionEdgeY = positionEdgeY;
            this.color = color;
        }
        else {
            this.positionEdgeY =  new int[0];
            this.positionEdgeX = new int[0];
        }
    }

    public Platform(int[] positionEdgeX, int[] positionEdgeY) {
        if(positionEdgeX.length == positionEdgeY.length) {
            this.positionEdgeX = positionEdgeX;
            this.positionEdgeY = positionEdgeY;
        }
        else {
            this.positionEdgeX = new int[0];
            this.positionEdgeY = new int[0];
        }
    }

    public int[] getPositionEdgeX() {
        return positionEdgeX;
    }

    public void setPositionEdgeX(int[] positionEdgeX) {
        this.positionEdgeX = positionEdgeX;
    }

    public int[] getPositionEdgeY() {
        return positionEdgeY;
    }

    public void setPositionEdgeY(int[] positionEdgeY) {
        this.positionEdgeY = positionEdgeY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}