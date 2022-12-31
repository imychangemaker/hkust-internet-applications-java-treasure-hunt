package game.ui;


import game.model.Board;
import game.model.Game;
import game.model.Node;
import game.model.AssistantNode;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

// Detail pane

public class BoardCanvas extends Canvas {
    private Board board = new Board();

    public BoardCanvas() {

    }

    public BoardCanvas(double width, double height) {
        super(width, height);
    }

    //Display detail

    public void startDraw() {
        GraphicsContext gc = getGraphicsContext2D();
        for (int i = 0; i < Board.WIDTH_SIZE; i++) {
            for (int j = 0; j < Board.HEIGHT_SIZE; j++) {
                Node node = board.getNodes()[i][j];
                Image image = board.getNodes()[i][j].getImage();
                if(node instanceof AssistantNode) {
                    if (!node.isEmpty() && image != null) {
                        gc.drawImage(image, j * Node.HEIGHT,i * Node.WIDTH,  AssistantNode.WIDTH, AssistantNode.HEIGHT);
                        if(Game.getInstance().getPlayer()!= null) {
                            gc.strokeText(Game.getInstance().getPlayer().getName(),
                                    j * Node.HEIGHT,i * Node.WIDTH+AssistantNode.HEIGHT+10);
                        }


                    }
                }else{
                    if (!node.isEmpty() && image != null) {
                        gc.drawImage(image, j * Node.HEIGHT,i * Node.WIDTH,  Node.WIDTH, Node.HEIGHT);

                    }
                }

            }
        }
    }

    // Clear game
    public void clear(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0,0,this.getWidth(),this.getHeight());
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
