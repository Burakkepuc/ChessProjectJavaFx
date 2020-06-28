import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class ChessApp extends Application {

     ChessBoard ChessBoard = new ChessBoard();
     StackPane stackpane = new StackPane(); //It takes board & pieces

     VBox vBoxR = new VBox(50); //For Buttons
     VBox vBoxL = new VBox(400); //For Label (Timer will come)

    @Override
    public void start(Stage primaryStage) {

        //Buttons and label was created
        Button reset = new Button("Reset");
        Button pass = new Button("Pass");
        Label blackTimer = new Label("Black Timer 00:00:00 ");
        Label whiteTimer = new Label("White Timer 00:00:00");

        vBoxL.setPadding(new Insets(0,20,0,20)); //Top-left-bottom-right space
        vBoxL.getChildren().addAll(blackTimer,whiteTimer);//Add timer to vertical box left
        vBoxL.setAlignment(Pos.CENTER_LEFT);//Alignment

        vBoxR.setPadding(new Insets(0,30,0,30));//Top-left-bottom-right space
        vBoxR.getChildren().addAll(reset,pass); //Add timer to verticall box right
        vBoxR.setAlignment(Pos.CENTER_RIGHT); // Alignment

       ChessBoard.gridpane.setAlignment(Pos.CENTER);//Alignment Chessboard

        stackpane.getChildren().addAll(ChessBoard.gridpane); //Add chessboard to stackpane

        //These are borderpane alignment and adding
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(stackpane);
        borderPane.setRight(vBoxR);
        borderPane.setLeft(vBoxL);
        borderPane.setStyle("-fx-background-color: aliceblue;");

        reset.setStyle("-fx-font-size: 16px; -fx-background-color: white; -fx-border-color: black;");
        reset.setOnMouseReleased(e->{
            reset.setStyle("-fx-font-size: 16px; -fx-background-color: white; -fx-border-color: black;");
        });
        pass.setStyle("-fx-font-size: 16px; -fx-background-color: white; -fx-border-color: black;");



        reset.setOnMousePressed(e->{ //action can be put in the reset button
            reset.setStyle("-fx-background-color: yellow; -fx-font-size: 16px;");
        });
       pass.setOnMouseClicked(e -> {
           pass.setStyle("-fx-background-color: blueviolet; -fx-font-size: 16px;");
       });

        Scene scene = new Scene(borderPane,850,650);
        primaryStage.setTitle("Board");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);

    }
}
