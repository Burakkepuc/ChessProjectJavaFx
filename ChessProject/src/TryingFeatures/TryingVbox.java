package TryingFeatures;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TryingVbox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       /* VBox vBox = new VBox(8); //Spacing 8
        vBox.setStyle("-fx-background-color: red");
        vBox.setPrefSize(40,50);
        vBox.getChildren().addAll(new Button("Cut"), new Button("Copy"),new Button("Paste"));
*/


        MenuButton menuButton = new MenuButton();

        VBox menuVbox = new VBox();
        menuVbox.setStyle("-fx-border-color: red");
        menuVbox.getChildren().addAll(
                new Button("Button"),
                new RadioButton("RadioButton"),
                new Button("Click Me"),
                new ComboBox<>(),
                new Slider(),
                new CheckBox("CheckBox"),
                new TextField()
        );
        menuVbox.setAlignment(Pos.TOP_RIGHT);
        CustomMenuItem vboxMenuItem = new CustomMenuItem(menuVbox);

        menuButton.getItems().add(vboxMenuItem);


        Scene scene = new Scene(menuVbox,400,400);
        primaryStage.setTitle("vBox");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
