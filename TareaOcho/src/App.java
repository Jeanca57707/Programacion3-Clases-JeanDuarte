import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/inicio.fxml")));
            stage.setTitle("Ventana de Inicio");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
