package vista.custom.burbujas;

import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Font;
import util.Utiles;
import util.clases.Elemento;

public class BurbujaDePanel extends AbsBurbuja {

    public BurbujaDePanel(Elemento elemento) {
        super(elemento);

        Label etiquetaLeyenda = new Label(elemento.getNombre());
        etiquetaLeyenda.setFont(Font.font("Noto Mono", 15));

        etiquetaLeyenda.setLayoutX(RADIO + 25);
        etiquetaLeyenda.setLayoutY(RADIO / 2 + 2);

        getChildren().add(etiquetaLeyenda);
    }
    
    
    @Override
    protected void dragDetectado(MouseEvent ev) {
        Dragboard db = startDragAndDrop(TransferMode.LINK);
        ClipboardContent cc = new ClipboardContent();

        cc.put(Utiles.getFormatoNodo(), elemento);
        db.setContent(cc);
        ev.consume();
    }
}
