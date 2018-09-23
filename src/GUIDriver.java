import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;

public class GUIDriver extends Application {

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
        primaryStage.setTitle("Stick Fighting Game.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button[] createButtons(StackPane root) {
        Button start = new Button("Start!");
        start.setOnAction( event -> root.getChildren().clear());

        Button quit = new Button("Quit");
        quit.setOnAction( event -> System.exit(0));
        return new Button[] {start, quit};
    }

    public static void main(String[] args) {
        launch(args);
    }

}