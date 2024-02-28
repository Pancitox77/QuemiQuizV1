package vista.custom.burbujas;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import util.clases.Elemento;

public abstract class AbsBurbuja extends Pane {
    protected static final float RADIO = 20f;
    protected Elemento elemento;

    protected AbsBurbuja(Elemento elemento){
        this.elemento = elemento;

        Arc circulo = new Arc(0, 0, RADIO, RADIO, 0, 360);
        circulo.setFill(gradiente(Color.web(elemento.getColorFondo())));
        circulo.setStroke(Color.BLACK);
        circulo.setType(ArcType.CHORD);

        Label etiquetaBurbuja = new Label("", circulo);
        Label etiquetaSimbolo = new Label(elemento.getSimbolo());

        // Color de letra y fuente
        Color colorLetra = Color.web(elemento.getColorSimbolo());
        if(colorLetra.equals(Color.web("#FFFFFF")))
            // Como es blanco, puede que no se pueda leer
            etiquetaSimbolo.getStyleClass().add("EtiquetaSimboloBlanco");

        etiquetaSimbolo.setTextFill(Color.web(elemento.getColorSimbolo()));
        etiquetaSimbolo.setFont(Font.font(20));

        // Posicionamiento
        String simbolo = elemento.getSimbolo();
        float centroX = (RADIO - (simbolo.length() * 5));

        etiquetaSimbolo.setLayoutX(centroX - 2);
        etiquetaSimbolo.setLayoutY(RADIO / 2 - 2);

        setCursor(Cursor.HAND);
        getChildren().addAll(etiquetaBurbuja, etiquetaSimbolo);

        setOnDragDetected(this::dragDetectado);
    }

    private LinearGradient gradiente(Color color){
        Stop[] colores = new Stop[]{
            new Stop(0, Color.WHITE),
            new Stop(1, color)
        };

        return new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, colores);
    }

    protected abstract void dragDetectado(MouseEvent ev);
}
