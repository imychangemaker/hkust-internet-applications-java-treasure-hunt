package game;

import game.model.Board;
import game.model.Game;
import game.model.Assistant;
import game.ui.BoardCanvas;
import game.ui.GamePane;
import game.ui.ResultPane;
import game.ui.StartPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {
    // Window size
    public static int WIDTH = 1000;
    public static int HEIGHT = 800;
    public static BorderPane showPane;
    @Override
    public void start(Stage primaryStage) {
        // Set game pane
        BorderPane borderPane = new BorderPane();
        BoardCanvas canvas = new BoardCanvas(600, 800);
        canvas.startDraw();
        borderPane.setCenter(canvas);
        borderPane.setRight(new StartPane());

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        // Set keyboard
        scene.setOnKeyPressed((e)->{
            if(Game.getInstance().isOver()) {
                return;
            }
            synchronized (Game.class) {
                BoardCanvas boardCanvas = (BoardCanvas) showPane.getCenter();
                Board board = boardCanvas.getBoard();
                Assistant assistant = board.getAssistant();
                // move UP
                if(e.getCode().equals(KeyCode.UP)) {
                    assistant.changeDirect(Assistant.DIRECT_NORTH);

                }else if(e.getCode().equals(KeyCode.DOWN)) {
                    // move DOWN

                    assistant.changeDirect(Assistant.DIRECT_SOUTH);

                }else if(e.getCode().equals(KeyCode.LEFT)) {
                    // move LEFT

                    assistant.changeDirect(Assistant.DIRECT_WEST);

                }else if(e.getCode().equals(KeyCode.RIGHT)) {
                    // move RIGHT

                    assistant.changeDirect(Assistant.DIRECT_EAST);

                }
            }

        });
        borderPane.prefHeightProperty().
                bind(scene.heightProperty());
        borderPane.prefWidthProperty().
                bind(scene.widthProperty());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        // Show game title
        primaryStage.setTitle("FINDING MULLER");
        primaryStage.setOnCloseRequest((e)->{
            System.exit(0);
        });
        showPane = borderPane;
        primaryStage.show();
    }

    public static BorderPane getShowPane() {
        return showPane;
    }

    // Multithreading 
    public static void start() {

        Timer timer = new Timer();
        // Update timer per 0.5s
        timer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        synchronized (Game.class) {
                            Game game = Game.getInstance();
                            if(game.isStart()) {
                                // Countdown
                                game.setTimes(game.getTimes() - 0.3);
                                // Update the screen
                                ((GamePane) showPane.getRight()).getChildren().clear();
                                ((GamePane) showPane.getRight()).init();
                                BoardCanvas boardCanvas = (BoardCanvas) showPane.getCenter();
                                Board board = boardCanvas.getBoard();
                                board.moveAssistant();
                                boardCanvas.clear();
                                boardCanvas.startDraw();
                                // Check the time
                                if (game.getTimes() < 0) {
                                    timer.cancel();
                                    showPane.setRight(new ResultPane(game,"Time's Up!"));
                                    return;
                                }
                                if (game.isOver()) {
                                    timer.cancel();
                                    showPane.setRight(new ResultPane(game,"Game Over!"));
                                }
                            }
                        }


                    }

                });
            }
        }, 1000, 300);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
