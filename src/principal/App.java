package principal;

import controladores.Monolito;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("QuemiQuiz");
        Monolito.setStage(stage);
        Monolito.cambiarVista("inicio");
        //Monolito.irAPruebas();
    }
}
