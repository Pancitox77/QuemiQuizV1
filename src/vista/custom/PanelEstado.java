package vista.custom;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import util.clases.Estado;

public class PanelEstado extends HBox {
    private Pane panelA;
    private Pane panelB;
    private Pane panelC;

    public PanelEstado(){
        panelA = new Pane();
        panelB = new Pane();
        panelC = new Pane();
        getChildren().addAll(panelA, panelB, panelC);
    }

    public void cargarDatos(Estado estado){
        panelA.getChildren().add(new Label());
        panelB.getChildren().add(new Label("1"));
        panelC.getChildren().add(new Label(estado.getNombreQuimico()));
    }
}
