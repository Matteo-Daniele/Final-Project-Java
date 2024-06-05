import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.TreeSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsCancion {
    LinkedHashMap<Integer, Cancion> cancionesTotal;
    CollectionsCancion(){
        this.cancionesTotal = new LinkedHashMap<>();
    }
    
    public void agregarCanciones(Cancion cancion){
        cancionesTotal.put(cancion.getId(), cancion);
    }

    public void escribirJSON(File f) {
        ObjectMapper bufferJson = new ObjectMapper();
        bufferJson.enable(SerializationFeature.INDENT_OUTPUT); // Enable pretty printing
        try {
            bufferJson.writeValue(f, cancionesTotal);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarCancionesArchivo(File f) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserializar el archivo JSON en un LinkedHashMap de canciones
            LinkedHashMap<Integer, Cancion> cancionesDesdeArchivo = objectMapper.readValue(f, new TypeReference<LinkedHashMap<Integer, Cancion>>() {});
            // Agregar las canciones deserializadas al LinkedHashMap
            cancionesTotal.putAll(cancionesDesdeArchivo);
            System.out.println("Canciones cargadas correctamente desde el archivo");
        } catch (IOException e) {
            System.out.println("Error al cargar las canciones desde el archivo: " + e.getMessage());
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
