package util;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import javafx.scene.input.DataFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utiles {
    @Getter private static final DataFormat FormatoNodo = new DataFormat("elemento.data");

    public static JSONArray leerJson(File archivo) {
        try(FileReader lector = new FileReader(archivo)) {
            JSONParser parser = new JSONParser();

            return (JSONArray) parser.parse(lector);
            } catch (Exception e) {
                System.out.println("Error al parsear el json");
                e.printStackTrace();
            }
        return new JSONArray();
    }
}
