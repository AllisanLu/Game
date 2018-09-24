import javafx.scene.image.Image;
public class Player {
    private int wins;
    private int XPosition;
    private int YPosition;
    private Image model;

    public Player(int x, int y) {
        wins = 0;
        XPosition = x;
        YPosition = y;
        //model = new Image("C:/Users/ned_n/OneDrive/Documents/GitHub/Game/First.gif");
    }

    public Image getModel() {
        return model;
    }

    public void setModel(Image model) {
        this.model = model;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getYPosition() {
        return YPosition;
    }

    public void setYPosition(int yPosition) {
        this.YPosition = yPosition;
    }

    public int getXPosition() {
        return XPosition;
    }

    public void setXPosition(int xPosition) {
        this.XPosition = xPosition;
    }
}
