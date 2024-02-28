package controladores.vista;

import controladores.Monolito;
import javafx.event.ActionEvent;

public class ControladorJuegos {
    public void botonJuegoLibre(ActionEvent e){
        Monolito.cambiarVista("principal");
    }

    public void botonAyudaInteractiva(ActionEvent e){
        Monolito.cambiarVista("ayuda_interactiva");
    }
}