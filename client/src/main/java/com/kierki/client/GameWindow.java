import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class GameWindow {
    private VBox layout;
    private Label usernameLabel;
    private ListView<String> roomList;
    private TextArea chatArea;
    private TextField chatInput;

    private String username;

    public GameWindow(String username) {
        this.username = username;

        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        usernameLabel = new Label("Zalogowany jako: " + username);
        roomList = new ListView<>();
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatInput = new TextField();
        Button sendButton = new Button("Wyślij");

        sendButton.setOnAction(e -> sendMessage());

        layout.getChildren().addAll(usernameLabel, roomList, chatArea, chatInput, sendButton);

        refreshRooms();
    }

    private void sendMessage() {
        String message = chatInput.getText();
        if (!message.isEmpty()) {
            NetworkHandler.sendRequest("CHAT " + message);
            chatInput.clear();
        }
    }

    private void refreshRooms() {
        String response = NetworkHandler.sendRequest("LIST_ROOMS");
        roomList.getItems().clear();
        String[] rooms = response.split(",");
        for (String room : rooms) {
            roomList.getItems().add(room);
        }
    }

    public VBox getLayout() {
        return layout;
    }
}
