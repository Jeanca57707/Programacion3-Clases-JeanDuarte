import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage)throws Exception{
        stage.setTitle("Evalución de estudiante");

        Label titulo = new Label("EVALUACION");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold");
        
        TextField nombretxt = new TextField();
        nombretxt.setPromptText("Ingrese el nombre");

        TextField calificaciontxt = new TextField();
        calificaciontxt.setPromptText("Ingrese la calificación");

        Button btnEvaluar = new Button("Evaluar");
        btnEvaluar.setStyle("-fx-background-color: #000000; -fx-text-fill: #FFFFFF");

        Label resultado = new Label();
    
        btnEvaluar.setOnAction(e->{

            String nota = calificaciontxt.getText().trim();
            
            try{
                int calificacion = Integer.parseInt(nota);   
            
                if(calificacion >= 70 && calificacion <= 100){
                    resultado.setText(nombretxt.getText() + ": Aprobo");
                    resultado.setStyle("-fx-font-size: 15px; -fx-text-fill: #008000");
                }
                else if(calificacion >= 60  && calificacion <= 69){
                    resultado.setText(nombretxt.getText() + ": Completivo");
                    resultado.setStyle("-fx-font-size: 15px; -fx-text-fill: #CCAA00");
                }
                else if(calificacion >= 0 && calificacion <= 68){
                    resultado.setText(nombretxt.getText() + ": Reprobado");
                    resultado.setStyle("-fx-font-size: 15px; -fx-text-fill: #FF0000");
                }
                else{
                    resultado.setText("Calificacion invalida");
                    resultado.setStyle("-fx-font-size: 15px; -fx-text-fill: #808080");
                } 
            }catch(NumberFormatException err){
                resultado.setText("Ingrese un número válido");
                resultado.setStyle("-fx-font-size: 15px; -fx-text-fill: #808080");
            }
        });

        VBox rama = new VBox(15);
        rama.getChildren().addAll(titulo, nombretxt, calificaciontxt, btnEvaluar, resultado);
        rama.setStyle("-fx-padding: 25px; -fx-background-color: #F5F0E6");
        rama.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rama, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

}
