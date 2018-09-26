import javafx.scene.image.Image;

public class Player extends PhysicsEngine {

    private int wins;
    private Image model;

    public Player(int x, int y) {
        super(x,y);
        wins = 0;
        PhysicsEngine hi = new PhysicsEngine(x, y);
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
}
