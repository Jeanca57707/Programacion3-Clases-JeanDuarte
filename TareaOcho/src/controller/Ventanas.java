package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Ventanas {

    private Ventanas(){

    }
    public static void abrir(String ruta, String titulo, Window propietario){
        try {
            FXMLLoader loader = new FXMLLoader(Ventanas.class.getResource("/view/" + ruta.trim() + ".fxml"));
            Scene scene = new Scene(loader.load());
            Stage ventana = new Stage();
            ventana.setTitle(titulo);
            ventana.initOwner(propietario);
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.setScene(scene);
            ventana.showAndWait();

        } catch (IOException e) {
            throw new IllegalStateException("No se pudo abrir la ventana", e);   
        }
    }
    
}
