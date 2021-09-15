package game.model;

import javafx.scene.image.Image;

public class Node {
    protected int row;
    protected int col;
    protected Image image;
    public static int HEIGHT = 50;
    public static int WIDTH = 50;
    private boolean isEmpty = true;

    public Node(int row, int col, Image image) {
        this.row = row;
        this.col = col;
        this.image = image;
    }

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", col=" + col +
                ", image=" + image +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
