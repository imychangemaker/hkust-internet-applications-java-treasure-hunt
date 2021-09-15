package game.model;

import java.util.LinkedList;

public class Assistant {
    private LinkedList<AssistantNode> nodes;
    private int direct = -1;
    public final static int DIRECT_EAST = 1;
    public final static int DIRECT_WEST = 2;
    public final static int DIRECT_SOUTH = 3;
    public final static int DIRECT_NORTH = 4;

    public Assistant() {
        nodes = new LinkedList<>();
    }

    public void addNode(AssistantNode node) {
        nodes.addLast(node);
    }
    
    
    public void move() {
        if(direct == -1) {
            return;
        }
        AssistantNode head = nodes.getFirst();

        int row = head.getRow();
        int col = head.getCol();
        AssistantNode last = nodes.removeLast();
        // Movement according to direction
        switch (direct) {
            case DIRECT_EAST:
                col = col + 1;
                break;
            case DIRECT_WEST:
                col = col - 1;
                break;
            case DIRECT_SOUTH:
                row += 1;
                break;
            case DIRECT_NORTH:
                row -= 1;
                break;
        }
        last.setCol(col);
        last.setRow(row);
        nodes.addFirst(last);

    }

    // Get the column coord of the assistant
    public int getCol() {
        AssistantNode head = nodes.getFirst();
        return head.getCol();
    }

    // Get the row coord of the assistant
    public int getRow() {
        AssistantNode head = nodes.getFirst();
        return head.getRow();
    }
    
    // Get the next column coord of the assistant
    public int getNextCol() {
        AssistantNode head = nodes.getFirst();

        int col = head.getCol();
        switch (direct) {
            case DIRECT_EAST:
                col = col + 1;
                break;
            case DIRECT_WEST:
                col = col - 1;
                break;
        }
        return col;
    }
    
    // Get the next row coord of the assistant
    public int getNextRow() {
        AssistantNode head = nodes.getFirst();

        int row = head.getRow();
        switch (direct) {
            case DIRECT_SOUTH:
                row += 1;
                break;
            case DIRECT_NORTH:
                row -= 1;
                break;
        }
        return row;
    }

    // Change directions
    public void changeDirect(int direct) {
        if(this.direct == -1) {
            Game.getInstance().setStart(true);
        }
        this.direct = direct;
    }

    public int getDirect() {
        return direct;
    }

    public LinkedList<AssistantNode> getNodes() {
        return nodes;
    }

    public void setNodes(LinkedList<AssistantNode> nodes) {
        this.nodes = nodes;
    }
}
