package vista.custom.burbujas;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import util.GrupoBurbujas;
import util.Utiles;
import util.clases.Elemento;

public class NodoBurbuja extends AbsBurbuja {
    public NodoBurbuja(Elemento elemento) {
        super(elemento);
        setOnContextMenuRequested(ev -> menuContextual().show(this , ev.getScreenX(), ev.getScreenY()));

        GrupoBurbujas.getNodos().add(this);
        setOnMouseClicked(ev -> {
            if(ev.getButton() == MouseButton.MIDDLE) {
                ev.consume();
                return;
            }

            short clickType = (ev.isShiftDown() ? GrupoBurbujas.SHIFT_CLICK : GrupoBurbujas.CLICK_NORMAL);
            GrupoBurbujas.nodoClickeado(this, clickType);
            ev.consume();
        });
    }

    public void setSeleccionado(boolean seleccionado) {
        if(seleccionado) setStyle("-fx-border-color: orange;");
        else setStyle("");
    }

    public ContextMenu menuContextual(){
        ContextMenu menu = new ContextMenu();

        MenuItem inforItem = new MenuItem("Acerca de este nodo");
        MenuItem eliminarItem = new MenuItem("Eliminar");

        menu.getItems().addAll(inforItem, eliminarItem);
        return menu;
    }

    @Override
    protected void dragDetectado(MouseEvent ev) {
        Dragboard db = startDragAndDrop(TransferMode.MOVE);
        ClipboardContent cc = new ClipboardContent();

        cc.put(Utiles.getFormatoNodo(), elemento);
        db.setContent(cc);
        ev.consume();
    }
}
