package controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import modelo.Recursos;
import util.clases.Elemento;

public class TablaPeriodica {
    @Getter private List<Elemento> elementos;
    @Getter private List<Elemento> elementosOrdenadosPorNombre;

    public TablaPeriodica(){
        this.elementos = Recursos.cargarTablaPeriodica();
        this.elementosOrdenadosPorNombre = copiarElementos();

        ordenarElementosPorNombre();
    }


    /* Util */


    private List<Elemento> copiarElementos(){
        ArrayList<Elemento> copia = new ArrayList<>(elementos.size());
        elementos.forEach(copia::add);
        return copia;
    }

    private void ordenarElementosPorNombre(){
        elementosOrdenadosPorNombre = new ArrayList<>(elementos.size());
        elementos.forEach(elementosOrdenadosPorNombre::add);

        Collections.sort(elementosOrdenadosPorNombre, (e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre()));
    }
}
