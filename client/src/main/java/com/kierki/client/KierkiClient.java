import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KierkiClient extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        stage.setTitle("Kierki - Klient");
        stage.setScene(new Scene(new LoginScreen().getLayout(), 300, 200));
        stage.show();
    }

    public static void setScene(Scene scene) {
        primaryStage.setScene(scene);
    }
}
