import java.util.Map;

public class CommandHandler {
    private Map<String, GameRoom> rooms;

    public CommandHandler(Map<String, GameRoom> rooms) {
        this.rooms = rooms;
    }

    public String handleCommand(String command, Player player) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "CREATE":
                return createRoom(parts[1], player);
            case "JOIN":
                return joinRoom(parts[1], player);
            case "LEAVE":
                return leaveRoom(parts[1], player);
            case "START":
                return startGame(parts[1]);
            default:
                return "Nieznane polecenie!";
        }
    }

    private String createRoom(String roomName, Player player) {
        if (rooms.containsKey(roomName)) {
            return "Pokój już istnieje!";
        }
        rooms.put(roomName, new GameRoom(roomName));
        rooms.get(roomName).addPlayer(player);
        return "Pokój " + roomName + " utworzony!";
    }

    private String joinRoom(String roomName, Player player) {
        if (!rooms.containsKey(roomName)) {
            return "Pokój nie istnieje!";
        }
        rooms.get(roomName).addPlayer(player);
        return "Dołączyłeś do pokoju " + roomName;
    }

    private String leaveRoom(String roomName, Player player) {
        if (!rooms.containsKey(roomName)) {
            return "Pokój nie istnieje!";
        }
        rooms.get(roomName).removePlayer(player);
        return "Opuściłeś pokój " + roomName;
    }

    private String startGame(String roomName) {
        if (!rooms.containsKey(roomName)) {
            return "Pokój nie istnieje!";
        }
        rooms.get(roomName).startGame();
        return "Gra w pokoju " + roomName + " rozpoczęta!";
    }
}
