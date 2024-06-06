import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

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

    public void cargarCancionesArchivo(File f){
        ObjectMapper mapa = new ObjectMapper();
        mapa.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            mapa.writeValue(f, cancionesTotal);
        }
        catch(IOException e){
            e.printStackTrace();
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
