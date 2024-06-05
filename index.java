import java.io.File;

public class index{
    public static void main(String[] args) {
        CollectionsCancion canciones = new CollectionsCancion();

        File f = new File("Canciones.json");
        canciones.cargarCancionesArchivo(f);
        canciones.mostrarCanciones();
    }
}