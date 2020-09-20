package sp.Chess.Gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
       
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
 
 
public class GUI extends Application {
       
        // Sets standard board and square sizes
        private static final int BOARD_SIZE = 9;
        private static final int SQUARE_SIZE = 80;
        // Letters and numbers that go on top/side of grid
        private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
        private String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8"};
       
        private String[] playerColor = {"Gold", "Black"};
       
        ImageView pieces[] = new ImageView[32];
       
       
       
        @Override
        public void start(Stage primaryStage) throws FileNotFoundException {
                try {
                       
                        ImageView[] pieces = new ImageView[32];
                       
                        ImageView gold_pawn1 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn2 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn3 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn4 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn5 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn6 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn7 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_pawn8 = new ImageView(new Image("file:Assists/gold_pawn.png"));
                        ImageView gold_rook1 = new ImageView(new Image("file:Assists/gold_rook.png"));
                        ImageView gold_rook2 = new ImageView(new Image("file:Assists/gold_rook.png"));
                        ImageView gold_knight1 = new ImageView(new Image("file:Assists/gold_knight.png"));
                        ImageView gold_knight2 = new ImageView(new Image("file:Assists/gold_knight.png"));
                        ImageView gold_bishop1 = new ImageView(new Image("file:Assists/gold_bishop.png"));
                        ImageView gold_bishop2 = new ImageView(new Image("file:Assists/gold_bishop.png"));
                        ImageView gold_queen = new ImageView(new Image("file:Assists/gold_queen.png"));
                        ImageView gold_king = new ImageView(new Image("file:Assists/gold_king.png"));
                        ImageView black_pawn1 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn2 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn3 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn4 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn5 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn6 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn7 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_pawn8 = new ImageView(new Image("file:Assists/black_pawn.png"));
                        ImageView black_rook1 = new ImageView(new Image("file:Assists/black_rook.png"));
                        ImageView black_rook2 = new ImageView(new Image("file:Assists/black_rook.png"));
                        ImageView black_knight1 = new ImageView(new Image("file:Assists/black_knight.png"));
                        ImageView black_knight2 = new ImageView(new Image("file:Assists/black_knight.png"));
                        ImageView black_bishop1 = new ImageView(new Image("file:Assists/black_bishop.png"));
                        ImageView black_bishop2 = new ImageView(new Image("file:Assists/black_bishop.png"));
                        ImageView black_queen = new ImageView(new Image("file:Assists/black_queen.png"));
                        ImageView black_king = new ImageView(new Image("file:Assists/black_king.png"));
                       
                        pieces[0] = gold_rook1;
                        pieces[1] = gold_knight1;
                        pieces[2] = gold_bishop1;
                        pieces[3] = gold_queen;
                        pieces[4] = gold_king;
                        pieces[5] = gold_bishop2;
                        pieces[6] = gold_knight2;
                        pieces[7] = gold_rook2;
                        pieces[8] = gold_pawn1;
                        pieces[9] = gold_pawn2;
                        pieces[10] = gold_pawn3;
                        pieces[11] = gold_pawn4;
                        pieces[12] = gold_pawn5;
                        pieces[13] = gold_pawn6;
                        pieces[14] = gold_pawn7;
                        pieces[15] = gold_pawn8;
                        pieces[16] = black_pawn1;
                        pieces[17] = black_pawn2;
                        pieces[18] = black_pawn3;
                        pieces[19] = black_pawn4;
                        pieces[20] = black_pawn5;
                        pieces[21] = black_pawn6;
                        pieces[22] = black_pawn7;
                        pieces[23] = black_pawn8;
                        pieces[24] = black_rook1;
                        pieces[25] = black_knight1;
                        pieces[26] = black_bishop1;
                        pieces[27] = black_king;
                        pieces[28] = black_queen;
                        pieces[29] = black_bishop2;
                        pieces[30] = black_knight2;
                        pieces[31] = black_rook2;
                       
                        for (int i = 0; i < pieces.length; i++) {
                                pieces[i].setFitHeight(50);
                                pieces[i].setFitWidth(50);
                        }
                       
                       
                       
                        // Root where all objects are placed
                        BorderPane root = new BorderPane();
                       
                        //setup accessory pane to hold move list, move label, and what ever else that is not the board
            GridPane accessoryPane = new GridPane();
           
            VBox gap = new VBox();
            gap.setMaxWidth(20);
            gap.setMinWidth(20);
            gap.setPrefWidth(20);
           
            //Move list that keeps track of AI and Player moves
            ListView movesList = new  ListView();
 
            Label lab = new Label();
            lab.setText("Current move:");
            //Label displaying current move
            Label currentMove = new Label(playerColor[0]);
           
            //add accessories to accessory Pane
            accessoryPane.add(gap, 0, 0);
            accessoryPane.add(lab, 1, 0);
            accessoryPane.add(currentMove, 1, 1);
            accessoryPane.add(movesList, 1, 2);
                       
                        // Gridpane that is the chess board itself
                        GridPane chessBoard = new GridPane();
                        chessBoard.setAlignment(Pos.CENTER);
                       
                        // Calls methods that set up the layout, adds the squares, and adds the letters/numbers
                        configureBoardLayout(chessBoard);
                        addSquaresToBoard(chessBoard);
                        addNumbersLettersToBoard(chessBoard);
                       
                        //Board and accessory GridPane (this just seemed like the easiest way)
            GridPane gameScreen = new GridPane();
            gameScreen.add(chessBoard, 0, 0);
            gameScreen.add(accessoryPane, 1, 0);
            gameScreen.setAlignment(Pos.CENTER);
           
          //Events for mouse click, button presses, extra
            //just for testing mouse clicks on board, can remove later
            chessBoard.setOnMouseClicked(e->{
                //something random just to test
                updateBoard(chessBoard, movesList, currentMove);
            });
                       
                       
                        int counter = 0;
                        for (int i = 1; i < 3; i++) {
                                for (int j = 1; j < 9; j++) {
                                        chessBoard.add(pieces[counter], j, i);
                                        counter++;
                                }
                        }
                       
                        for (int i = 7; i < 9; i++) {
                                for (int j = 1; j < 9; j++) {
                                        chessBoard.add(pieces[counter], j, i);
                                        counter++;
                                }
                        }
                       
                       
                       
                        // Chess board is set to center of the root borderpane
                        root.setCenter(gameScreen);
                        Scene scene = new Scene(root,1200,750);
                        primaryStage.setTitle("Chess");
                        primaryStage.setScene(scene);
                        primaryStage.show();
                } catch(Exception e) {
                        e.printStackTrace();
                }
        }
       
       
        // Adds squares to the chess board
        // Skips the topmost row and leftmost column (these will contain the letters and numbers)
        private void addSquaresToBoard(GridPane chessBoard) {
                Color[] squareColors = new Color[] {Color.BROWN, Color.LIGHTGREY};
                for (int row = 1; row < BOARD_SIZE; row++) {
                        for (int col = 1; col < BOARD_SIZE; col++) {
                                chessBoard.add(new Rectangle(SQUARE_SIZE, SQUARE_SIZE, squareColors[(row+col)%2]), col, row);
                        }
                }
        }
       
        // Configures the layout of the board (height/width of squares, etc.)
        public void configureBoardLayout(GridPane chessBoard) {
                for (int i = 0; i < BOARD_SIZE; i++) {
                       
                        // Different constraints for the topmost row and leftmost column
                        // These holds the letters and numbers. Needed different values for optimal alignment
                        if (i == 0) {
                                RowConstraints rowConstraints = new RowConstraints();
                                rowConstraints.setMinHeight(40);
                                rowConstraints.setPrefHeight(40);
                                rowConstraints.setMaxHeight(40);
                                rowConstraints.setValignment(VPos.CENTER);
                                chessBoard.getRowConstraints().add(rowConstraints);
                               
                                ColumnConstraints colConstraints = new ColumnConstraints();
                                colConstraints.setMinWidth(40);
                                colConstraints.setPrefWidth(40);
                                colConstraints.setMaxWidth(40);
                                colConstraints.setHalignment(HPos.CENTER);
                                chessBoard.getColumnConstraints().add(colConstraints);
                               
                        }
                       
                        // For the squares
                        else {
                                RowConstraints rowConstraints = new RowConstraints();
                                rowConstraints.setMinHeight(SQUARE_SIZE);
                                rowConstraints.setPrefHeight(SQUARE_SIZE);
                                rowConstraints.setMaxHeight(SQUARE_SIZE);
                                rowConstraints.setValignment(VPos.CENTER);
                                chessBoard.getRowConstraints().add(rowConstraints);
                       
                                ColumnConstraints colConstraints = new ColumnConstraints();
                                colConstraints.setMinWidth(SQUARE_SIZE);
                                colConstraints.setPrefWidth(SQUARE_SIZE);
                                colConstraints.setMaxWidth(SQUARE_SIZE);
                                colConstraints.setHalignment(HPos.CENTER);
                                chessBoard.getColumnConstraints().add(colConstraints);
                        }
                }
        }
       
        // Adds the numbers and letters to the topmost row and leftmost column of the chess board gridpane
        public void addNumbersLettersToBoard(GridPane chessBoard) {
               
                for (int i = 1; i < BOARD_SIZE; i++) {
                        Text t1 = new Text(letters[i-1]);
                        t1.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
                        chessBoard.add(t1, i, 0);
                        Text t2 = new Text(nums[i-1]);
                        t2.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
                        chessBoard.add(t2, 0, i);
                       
                }
        }
       
        //updates the chess board when ever a move is made, adds info to the move list switchs the move label
    public void updateBoard(GridPane chessBoard, ListView movesList, Label currentMove) {
        //update the chess board
        //TODO
       
        //Update the move list
        //these are just for testing
        movesList.getItems().add("Test turn 1");
        movesList.getItems().add("Test turn 2");
        movesList.getItems().add("Test turn 3");
        movesList.getItems().add("Test turn 4");
       
        //Switch the current move Label
        if(currentMove.getText().equals("Gold")) {
                currentMove.setText(playerColor[1]);
        }else {
                currentMove.setText(playerColor[0]);
        }
    }
       
        public static void main(String[] args) {
                launch(args);
        }
       
       
}