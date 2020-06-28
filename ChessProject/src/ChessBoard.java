import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessBoard extends Pane {

    final int[][] ChessBoard = new int[8][8];
    GridPane gridpane = new GridPane();

    private double mouseDragX;
    private double mouseDragY;




    ImageView imageView2 = new ImageView(new Image("ChessPiece\\Black_Bishop.png"));
    ImageView imageView3 = new ImageView(new Image("ChessPiece\\Black_Bishop.png"));

    int getCoordGridpaneX, getCoordGridpaneY;



    public ChessBoard() {
        this.ChessInıt();
    }

    public void ChessInıt(){
            //Defines optional layout constraints for a column & row in a GridPane.
            for (int i = 0; i < ChessBoard.length; i++) {
                ColumnConstraints cc = new ColumnConstraints();
                cc.setHalignment(HPos.CENTER);
                RowConstraints rc = new RowConstraints();
                rc.setValignment(VPos.CENTER);
                gridpane.getColumnConstraints().add(cc);
                gridpane.getRowConstraints().add(rc);
            }


            for (int x = 0; x < ChessBoard.length; x++) {
                for (int y = 0; y < ChessBoard.length; y++) {
                    Rectangle rectangle = new Rectangle(72, 72);
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill((x + y) % 2 == 0 ? Color.WHITE : Color.DARKGRAY);
                    int c = x; //New variable because of we define x & y in for loop.
                    int r = y;


                    rectangle.setOnMouseDragReleased(e -> {
                        imageView2.setTranslateX(0);
                        imageView2.setTranslateY(0);
                        GridPane.setColumnIndex(imageView2, c);
                        GridPane.setRowIndex(imageView2, r);

                        getCoordGridpaneX = GridPane.getColumnIndex(imageView2);
                        getCoordGridpaneY = GridPane.getRowIndex(imageView2);
                        System.out.println("x= " + getCoordGridpaneX + " y= " + getCoordGridpaneY);
                    });

                    gridpane.add(rectangle, x, y);
                }
            }

            gridpane.add(imageView2, 1, 6);
            gridpane.add(imageView3, 2, 6);


            imageView2.setOnDragDetected(e -> {
                imageView2.startFullDrag();
            });

            imageView2.setOnMousePressed(e -> {
                mouseDragX = e.getSceneX();
                mouseDragY = e.getSceneY();
                imageView2.setMouseTransparent(true); //Mouse old image visibilty

                getCoordGridpaneX = GridPane.getColumnIndex(imageView2);
                getCoordGridpaneY = GridPane.getRowIndex(imageView2);
                System.out.println("\nx:" + getCoordGridpaneX + "y:" + getCoordGridpaneY);

            });

            imageView2.setOnMouseDragged(e -> {
                imageView2.setTranslateX(e.getSceneX() - mouseDragX);
                imageView2.setTranslateY(e.getSceneY() - mouseDragY);

            });


            imageView2.setOnMouseReleased(e -> imageView2.setMouseTransparent(false));



        }
}




