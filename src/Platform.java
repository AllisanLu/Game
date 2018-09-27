import javafx.scene.paint.Color;

public class Platform {
    private final double[] positionEdgeX;
    private final double[] positionEdgeY;
    private final Color color;

    public Platform(double[] positionEdgeX, double[] positionEdgeY, Color color) throws IllegalArgumentException {

        if(positionEdgeX.length != positionEdgeY.length) throw new IllegalArgumentException();

        this.positionEdgeX = positionEdgeX;
        this.positionEdgeY = positionEdgeY;
        this.color = color;
    }

    public Platform(double[] positionEdgeX, double[] positionEdgeY) throws IllegalArgumentException {

        if(positionEdgeX.length != positionEdgeY.length) throw new IllegalArgumentException();

        this.positionEdgeX = positionEdgeX;
        this.positionEdgeY = positionEdgeY;
        this.color = Color.GRAY;
    }

    public double[] getPositionEdgeX() {
        return positionEdgeX;
    }

    public double[] getPositionEdgeY() {
        return positionEdgeY;
    }


    public Color getColor() {
        return color;
    }
}