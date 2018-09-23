import java.awt.*;

public class Player {
    private int wins;
    private Dimension place;

    public Player(Dimension place) {
        wins = 0;
        this.place = place;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public Dimension getPlace() {
        return place;
    }

    public void setPlace(Dimension place) {
        this.place = place;
    }
}
