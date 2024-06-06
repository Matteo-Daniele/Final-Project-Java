import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsCancion implements Cargable{
    LinkedHashMap<Integer, Cancion> cancionesTotal;

    CollectionsCancion(){
        this.cancionesTotal = new LinkedHashMap<>();
    }
    
    public void agregarCanciones(Cancion cancion){
        cancionesTotal.put(cancion.getId(), cancion);
    }

    @Override
    public void cargarArchivo(File f){
        ObjectMapper mapa = new ObjectMapper();
        mapa.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            mapa.writeValue(f, cancionesTotal);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void bajarArchivo(File f){
        ObjectMapper mapper = new ObjectMapper();
        try {
            cancionesTotal = mapper.readValue(f, new TypeReference<LinkedHashMap<Integer, Cancion>>() {});
            System.out.println("Datos cargados correctamente desde el archivo JSON.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo JSON: " + e.getMessage());
        }
    }

    public void mostrarCanciones() {
        if (cancionesTotal.isEmpty()) {
            System.out.println("No hay canciones en la colección.");
        } else {
            System.out.println("Lista de canciones:");
            for (Cancion cancion : cancionesTotal.values()) {
                System.out.println(cancion);
            }
        }
    }
}
