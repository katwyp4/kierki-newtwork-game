import java.util.ArrayList;
import java.util.List;

public class GameRoom {
    private String roomName;
    private List<Player> players;
    private boolean gameStarted;

    public GameRoom(String roomName) {
        this.roomName = roomName;
        this.players = new ArrayList<>();
        this.gameStarted = false;
    }

    public String getRoomName() {
        return roomName;
    }

    public void addPlayer(Player player) {
        if (!gameStarted && players.size() < 4) {
            players.add(player);
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startGame() {
        if (players.size() == 4) {
            this.gameStarted = true;
            System.out.println("Gra w pokoju " + roomName + " rozpoczęta!");
        }
    }
}
