package controladores.vista;

import controladores.Monolito;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ControladorInicio {
    public void botonIniciar(ActionEvent ignore){
        Monolito.cambiarVista("juegos");
    }

    public void botonSalir(ActionEvent ignore){
        Platform.exit();
    }
}
