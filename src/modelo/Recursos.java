package modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import util.Utiles;
import util.clases.Elemento;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Recursos {
    /**
     * Clase para conseguir recursos tales como imágenes, archivos json, txt, etc.
    */

    private static final String RUTA_TABLA_PERIODICA = "/recursos/tabla_periodica.json";
    private static final String RUTA_ESTILOS = "/recursos/estilo.css";


    public static String cargarEstilo(){
        return Recursos.class.getResource(RUTA_ESTILOS).toExternalForm();
    }

    public static List<Elemento> cargarTablaPeriodica(){
        File archivo = obtenerArchivoONull(RUTA_TABLA_PERIODICA);

        JSONArray arr = Utiles.leerJson(archivo); 
        ArrayList<Elemento> tablaPeriodica = new ArrayList<>(arr.size());

        for(int i=0; i<arr.size(); i++)
            tablaPeriodica.add(Elemento.desdeJSON((JSONObject) arr.get(i)));
        return tablaPeriodica;
    }

    private static File obtenerArchivoONull(String ruta){
        try {
            return new File(Recursos.class.getResource(ruta).toURI());
        } catch (URISyntaxException e) {
            System.out.println("Archivo: " + ruta + " no encontrado.");
            e.printStackTrace();
        }
        return null;
    }
}
