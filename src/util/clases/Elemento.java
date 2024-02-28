package util.clases;

import java.io.Serializable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lombok.Data;

@Data
public class Elemento implements Serializable {
    private int numeroAtomico = 0;
    private String nombre = "";
    private String simbolo = "";
    private String estadoNatural = "";
    private String tipoMaterial = "";
    private String tipoDetallado = "";
    private float masa = 0.0f;
    private short[] estadosOxidacion = new short[0];
    private String[] configElec = new String[0];
    private String colorSimbolo = "#000000"; // Negro
    private String colorFondo = "#FFFFFF"; // Blanco


    /* Util */

    public static Elemento desdeJSON(JSONObject object){
        Elemento elem = new Elemento();
        short[] oxid;


        // JSONArray a short[]
        JSONArray oxidacionArray = (JSONArray) object.get("est_oxid");
        if(oxidacionArray == null) oxid = new short[0];
        else {
            oxid = new short[oxidacionArray.size()];
            for(int i=0; i<oxidacionArray.size(); i++){
                String oxidacion = oxidacionArray.get(i) + "";

                if(oxidacion.equals("-")){
                    oxid = new short[0];
                    break;
                }
                oxid[i] = Short.parseShort(oxidacion);
            }
        }

        // Iniciar valores
        elem.numeroAtomico = (int) ((long)object.get("n_atom"));
        elem.nombre = (String)object.get("nombre");
        elem.simbolo = (String)object.get("simbolo");
        elem.masa = Float.parseFloat(object.get("masa_atom") + "");
        elem.estadosOxidacion = oxid;
        elem.configElec = ((String) object.get("config_elec")).split(" ");
        elem.estadoNatural = (String)object.get("estado_natural");
        elem.tipoMaterial = (String)object.get("tipo_material");
        elem.tipoDetallado = (String)object.get("tipo_detallado");
        elem.colorSimbolo = (String) object.get("color_simbolo");
        elem.colorFondo = (String) object.get("color_fondo");
        
        return elem;
    }
}