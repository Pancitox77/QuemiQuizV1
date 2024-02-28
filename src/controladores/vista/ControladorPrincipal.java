package controladores.vista;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controladores.TablaPeriodica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import util.GrupoBurbujas;
import util.Utiles;
import util.clases.Elemento;
import vista.custom.burbujas.BurbujaDePanel;
import vista.custom.burbujas.NodoBurbuja;

public class ControladorPrincipal implements Initializable{
    @FXML private VBox panelElementos;
    @FXML private AnchorPane panelNavegable;

    @Override
    public void initialize(URL ruta, ResourceBundle recursos) {
        // Agrega todos los elementos (en el modo niveles debería agregar solo los que se especifíquen)
        List<Elemento> tp = new TablaPeriodica().getElementosOrdenadosPorNombre();
        tp.forEach(e -> {
            BurbujaDePanel burbuja = new BurbujaDePanel(e);
            panelElementos.getChildren().add(burbuja);
        });

        panelNavegable.setOnMouseClicked(ignore -> {
            GrupoBurbujas.nodoClickeado(null, (short)(0));
            ignore.consume();
        });

        // Drag and Drop
        panelNavegable.setOnDragOver(ev -> {
            Dragboard db = ev.getDragboard();
            if(ev.getGestureSource() != panelNavegable && db.hasContent(Utiles.getFormatoNodo()))
                ev.acceptTransferModes(TransferMode.ANY);
            ev.consume();
        });

        // Extra: entered: mouseMoved() -> dibujar el nodo (una sombra), a modo de vista previa
        panelNavegable.setOnDragEntered(ignore -> panelNavegable.getStyleClass().add("DragEntered"));
        panelNavegable.setOnDragExited(ignore -> panelNavegable.getStyleClass().remove("DragEntered"));

        panelNavegable.setOnDragDropped(ev -> {
            Dragboard db = ev.getDragboard();
            boolean exito = false;

            if(db.hasContent(Utiles.getFormatoNodo())){
                Elemento e = (Elemento) db.getContent(Utiles.getFormatoNodo());
                
                NodoBurbuja burbuja = new NodoBurbuja(e);
                burbuja.setLayoutX(ev.getX() - 20);
                burbuja.setLayoutY(ev.getY() - 20);
                panelNavegable.getChildren().add(burbuja);

                exito = true;
            }
            
            ev.setDropCompleted(exito);
        });
    }
}
