package controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Monolito {
    /** 
     * Esta clase sirve de conectora entre la vista (desde su controlador) hasta el modelo, y viceversa
    */

    @Setter private static Stage stage;

    
    /* Cambiar de vista */
    

    public static <T> T cambiarVista(String nombreVista){
        try {
            FXMLLoader loader = new FXMLLoader(Monolito.class.getResource("/vista/vista-" + nombreVista + ".fxml"));
            Parent root = loader.load();

            Scene escena = new Scene(root);
            stage.setScene(escena);
            stage.sizeToScene();
            stage.show();
            return loader.getController();

        } catch (Exception e) {
            System.out.println("Error al cambiar a la vista " + nombreVista);
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void irAPruebas(){
        try {
            Parent root = FXMLLoader.load(Monolito.class.getResource("/vista/pruebas.fxml"));
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Error al cambiar a la vista pruebas.fxml");
            System.out.println(e.getMessage());
        }
    }
}
