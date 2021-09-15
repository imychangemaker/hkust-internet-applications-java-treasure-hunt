package game.ui;

import game.model.Game;
import game.model.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class GamePane extends Pane {
    // Current game
    private Game game;

    public GamePane(Game game) {
        this.setPrefSize(400, 800);
        this.game = game;
        this.setStyle("-fx-background-color: black;");
        init();

    }

    public void init() {

        Label label = new Label("FINDING MULLER");
        label.setTextFill(Color.WHITE);
        label.setFont(new Font(35));
        label.setStyle("-fx-font-weight: bold");
        label.setLayoutX(60);
        label.setLayoutY(80);
        // Show the countdown time
        Label label1 = new Label("Time: " + ((int)game.getTimes()) + "s");
        label1.setTextFill(Color.WHITE);
        label1.setFont(new Font(30));
        label1.setLayoutX(50);
        label1.setLayoutY(150);
        // Show the score
        Label scoreLab = new Label("Score: " + game.getScore());
        scoreLab.setTextFill(Color.WHITE);
        scoreLab.setFont(new Font(30));
        scoreLab.setLayoutX(50);
        scoreLab.setLayoutY(220);

        this.getChildren().add(label);
        this.getChildren().add(label1);
        this.getChildren().add(scoreLab);
        // Show the leader board
        Label leadLab = new Label("Leader Board");
        leadLab.setTextFill(Color.WHITE);
        leadLab.setStyle("-fx-font-weight: bold");
        leadLab.setFont(new Font(30));
        leadLab.setLayoutX(50);
        leadLab.setLayoutY(360);
        this.getChildren().add(leadLab);

        for (int i = 0; i < Game.getMaxScorePlayers().size(); i++) {
            Player player = Game.getMaxScorePlayers().get(i);
            String msg = String.format("%d.%s", (i + 1), player.getName());
            Label temp = new Label(msg);
            temp.setTextFill(Color.WHITE);
            temp.setFont(new Font(28));
            temp.setLayoutX(50);
            temp.setLayoutY(360 + (i + 1) * 50);


            Label tempScore = new Label( String.valueOf(player.getScore()));
            tempScore.setTextFill(Color.WHITE);
            tempScore.setFont(new Font(28));
            tempScore.setLayoutX(300);
            tempScore.setLayoutY(360 + (i + 1) * 50);
            this.getChildren().add(temp);
            this.getChildren().add(tempScore);

        }
        // Show the game rules
        Label ruleLab = new Label("Rules");
        ruleLab.setTextFill(Color.WHITE);
        ruleLab.setStyle("-fx-font-weight: bold");
        ruleLab.setFont(new Font(30));
        ruleLab.setLayoutX(50);
        ruleLab.setLayoutY(600);
        this.getChildren().add(ruleLab);

        Label rules1 = new Label( "Professor     score +100");
        rules1.setTextFill(Color.WHITE);
        rules1.setFont(new Font(28));
        rules1.setLayoutX(50);
        rules1.setLayoutY(650);
        this.getChildren().add(rules1);


        Label rules2 = new Label( "Student        score -50");
        rules2.setTextFill(Color.WHITE);
        rules2.setFont(new Font(28));
        rules2.setLayoutX(50);
        rules2.setLayoutY(700);
        this.getChildren().add(rules2);

    }


}
