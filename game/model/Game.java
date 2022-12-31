package game.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static Game game = new Game();
    private Player player;
    private double times = 120d;
    private boolean isOver;
    private boolean isStart;
    private static List<Player> maxScorePlayers = new ArrayList<>();

    static {
        try {
            // Read the leader board
            File file = new File("result.dat");
            if(file.exists()) {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                maxScorePlayers = cast(inputStream.readObject());
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Deal with unchecked cast
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    public static Game getInstance() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getTimes() {
        return times;
    }

    public void setTimes(Double times) {
        this.times = times;
    }

    public int getScore() {
        return player.getScore();
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public static List<Player> getMaxScorePlayers() {
        return maxScorePlayers;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    // Save the player end score into leader board
    public static void savePlayers() {
        try {
            ArrayList<Player> list = new ArrayList<>(maxScorePlayers);
            list.add(Game.getInstance().getPlayer());
            // Arrange the order from the highest to lowest
            Collections.sort(list, (a, b) -> {
                return b.getScore() - a.getScore();
            });
            maxScorePlayers.clear();
            // Add the players with the first 3 highest scores 
            for (int i = 0; i < list.size(); i++) {
                maxScorePlayers.add(list.get(i));
                if (i >= 2) {
                    break;
                }
            }
            // Save the result to the file
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("result.dat"));
            outputStream.writeObject(maxScorePlayers);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
