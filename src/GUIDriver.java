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
    private static Canvas canvas;
    private boolean fNorth, fEast, fWest, sNorth, sEast, sWest;
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        for(Button btn : createButtons(root))
            vbox.getChildren().addAll(btn);

        root.getChildren().add(vbox);
        root.setAlignment(vbox, Pos.CENTER);
        Scene scene = new Scene(root,400,400);
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case UP: fNorth = true; break;
                case RIGHT: fEast = true; break;
                case LEFT: fWest = true; break;
                case W: sNorth = true; break;
                case D: sEast = true; break;
                case A: sWest = true; break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch(event.getCode()) {
                case UP: fNorth = false; break;
                case RIGHT: fEast = false; break;
                case LEFT: fWest = false; break;
                case W: sNorth = false; break;
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
        Player secondPlayer = new Player(250, 300 );

        canvas = new Canvas(400, 400);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(5);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                System.out.println(currentNanoTime);
                gc.clearRect(firstPlayer.getPositionX(), firstPlayer.getPositionY(), 30, 30);
                gc.clearRect(secondPlayer.getPositionX(), secondPlayer.getPositionY(), 30, 30);

                if(fNorth) firstPlayer.moveUp();
                if(sNorth) secondPlayer.moveUp();

                if(fWest) firstPlayer.moveLeft();
                else if(fEast) firstPlayer.moveRight();

                if(sWest) secondPlayer.moveLeft();
                else if(sEast) secondPlayer.moveRight();

                gc.fillRect(firstPlayer.getPositionX(), firstPlayer.getPositionY(), 30, 30);
                gc.fillRect(secondPlayer.getPositionX(), secondPlayer.getPositionX(), 30, 30);
            }
        }.start();
    }

    public static double getScreenWidth() {
        return canvas.getWidth();
    }

    public static double getScreenHeight() {
        return canvas.getHeight();
    }

    public static void main(String[] args) {
        launch(args);
    }

}