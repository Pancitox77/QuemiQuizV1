package util;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vista.custom.burbujas.NodoBurbuja;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GrupoBurbujas {
    public static final short CLICK_NORMAL = 1;
    public static final short SHIFT_CLICK = 2;

    @Getter private static List<NodoBurbuja> nodos = new ArrayList<>(1);
    private static List<NodoBurbuja> nodosSeleccionados = new ArrayList<>(1);


    public static void nodoClickeado(NodoBurbuja nodo, final short CLICK){
        if(nodo == null){
            // Click en el panel, fuera de los nodos
            nodosSeleccionados.forEach(n -> n.setSeleccionado(false));
            nodosSeleccionados.clear();
            return;
        }

        if(CLICK == CLICK_NORMAL){
            nodosSeleccionados.forEach(n -> n.setSeleccionado(false));
            nodosSeleccionados.clear();
        }
        
        if(nodosSeleccionados.contains(nodo)) return;
        nodosSeleccionados.add(nodo);

        nodosSeleccionados.forEach(n -> n.setSeleccionado(true));
    }
}
