package game.model;

import javafx.scene.image.Image;
import game.utils.ImageUtil;

public class Treasure extends Node{
    private int score;
    // Retrieve the image
    public static String TREASURE_1_PATH = "image/11734.png";
    public static String TREASURE_2_PATH = "image/IMG_0107.png";
    // Define the type using number: addition or subtraction of scores
    public static int TYPE_ADD_SCORE = 1;
    public static int TYPE_SUB_SCORE = 2;
    public Treasure(int x, int y, Image image, int score) {
        super(x, y, image);
        this.score = score;
    }

    public static Treasure createTreasure(int x, int y,int type){
        if(type == TYPE_ADD_SCORE) {
            return new Treasure(x,y, ImageUtil.getImage(TREASURE_1_PATH),100);
        }
        if(type == TYPE_SUB_SCORE) {
            return new Treasure(x,y,ImageUtil.getImage(TREASURE_2_PATH),-50);
        }
        return null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "score=" + score +
                '}';
    }
}
