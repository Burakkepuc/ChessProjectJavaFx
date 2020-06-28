package TryingFeatures;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TryingImage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridpane = new GridPane();
        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            gridpane.getColumnConstraints().add(column);
        }


        Scene scene = new Scene(gridpane);
        primaryStage.setTitle("Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
