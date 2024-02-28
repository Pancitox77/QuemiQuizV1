package controladores.vista;

import java.util.Optional;

import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.PropertySheet.Item;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class PruebasUI {
    @FXML private AnchorPane pane;

    @FXML private void initialize(){
        PropertySheet propertySheet = new PropertySheet();
        propertySheet.setPrefSize(pane.getPrefWidth(), pane.getPrefHeight());

        // Items
        propertySheet.getItems().addAll(
            new SimpleItem("Simbolo de enlace", "Enlaces", String.class),
            new SimpleItem("Modo por defecto", "Enlaces", RadioButton.class)
        );


        pane.getChildren().add(propertySheet);
    }
}

class SimpleItem implements Item {
    private String nombre;
    private String categoria;
    private Class<?> type;
    private String value;

    public SimpleItem(String nombre, String categoria, Class<?> type){
        this.nombre = nombre;
        this.categoria = categoria;
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    @Override
    public String getCategory() {
        return categoria;
    }

    @Override
    public String getName() {
        return nombre;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (String) value;
    }

    @Override
    public Optional<ObservableValue<? extends Object>> getObservableValue() {
        return Optional.empty();
    }
}