import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginScreen {
    private VBox layout;
    private TextField usernameField;
    private PasswordField passwordField;
    private Label messageLabel;

    public LoginScreen() {
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        usernameField = new TextField();
        usernameField.setPromptText("Nazwa użytkownika");

        passwordField = new PasswordField();
        passwordField.setPromptText("Hasło");

        Button loginButton = new Button("Zaloguj");
        Button registerButton = new Button("Zarejestruj");

        messageLabel = new Label();

        loginButton.setOnAction(e -> handleLogin());
        registerButton.setOnAction(e -> handleRegister());

        layout.getChildren().addAll(usernameField, passwordField, loginButton, registerButton, messageLabel);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String response = NetworkHandler.sendRequest("LOGIN " + username + " " + password);

        if (response.equals("SUCCESS")) {
            messageLabel.setText("Zalogowano!");
            KierkiClient.setScene(new Scene(new GameWindow(username).getLayout(), 600, 400));
        } else {
            messageLabel.setText("Błąd logowania");
        }
    }

    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String response = NetworkHandler.sendRequest("REGISTER " + username + " " + password);

        if (response.equals("SUCCESS")) {
            messageLabel.setText("Zarejestrowano! Zaloguj się.");
        } else {
            messageLabel.setText("Błąd rejestracji");
        }
    }

    public VBox getLayout() {
        return layout;
    }
}
