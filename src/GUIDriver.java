import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public class GUIDriver extends Application {
    private Canvas canvas;
    private boolean fNorth, fSouth, fEast, fWest, sNorth, sSouth, sEast, sWest;
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        Button[] buttons = createButtons(root);
        for(Button btn : buttons)
            vbox.getChildren().addAll(btn);
        root.getChildren().add(vbox);
        root.setAlignment(vbox, Pos.CENTER);
        Scene scene = new Scene(root,400,400);
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case UP: fNorth = true; break;
                case DOWN: fSouth = true; break;
                case RIGHT: fEast = true; break;
                case LEFT: fWest = true; break;
                case W: sNorth = true; break;
                case S: sSouth = true; break;
                case D: sEast = true; break;
                case A: sWest = true; break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch(event.getCode()) {
                case UP: fNorth = false; break;
                case DOWN: fSouth = false; break;
                case RIGHT: fEast = false; break;
                case LEFT: fWest = false; break;
                case W: sNorth = false; break;
                case S: sSouth = false; break;
                case D: sEast = false; break;
                case A: sWest = false; break;
            }
        });

        primaryStage.setTitle("Stick Fighting Game.");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Button[] createButtons(StackPane root) {
        Button start = new Button("Start!");
        start.setOnAction( event -> {
            root.getChildren().clear();
            addPlayers(root);
        });

        Button quit = new Button("Quit");
        quit.setOnAction( event -> System.exit(0));
        return new Button[] {start, quit};
    }

    private void addPlayers(StackPane root) {
        Player firstPlayer = new Player(200, 200);
        Player secondPlayer = new Player(390, 400 );
        canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(5);
        root.getChildren().add(canvas);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gc.clearRect(firstPlayer.getXPosition(), firstPlayer.getYPosition(), 50, 50);
                gc.clearRect(secondPlayer.getXPosition(), secondPlayer.getYPosition(), 50, 50);
                if(fNorth) firstPlayer.setYPosition(firstPlayer.getYPosition() - 1);
                if(fSouth) firstPlayer.setYPosition(firstPlayer.getYPosition() + 1);
                if(fWest) firstPlayer.setXPosition(firstPlayer.getXPosition() + 1);
                if(fEast) firstPlayer.setXPosition(firstPlayer.getXPosition() - 1);
                if(sNorth) secondPlayer.setYPosition(secondPlayer.getYPosition() - 1);
                if(sSouth) secondPlayer.setYPosition(secondPlayer.getYPosition() + 1);
                if(sWest) secondPlayer.setXPosition(secondPlayer.getXPosition() + 1);
                if(sEast) secondPlayer.setXPosition(secondPlayer.getXPosition() - 1);
                gc.fillRect(secondPlayer.getXPosition(), secondPlayer.getYPosition(), 50, 50);
                //gc.drawImage(firstPlayer.getModel(), firstPlayer.getXPosition(), firstPlayer.getYPosition());
                //gc.drawImage(secondPlayer.getModel(), secondPlayer.getXPosition(), secondPlayer.getYPosition());
            }
        }.start();
    }



    public static void main(String[] args) {
        launch(args);
    }

}