import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsCancion implements Cargable <Cancion>{
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

    @Override
    public void borrarObjeto(File f, Cancion cancion) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            // Cargar los datos del archivo JSON en el LinkedHashMap
            cancionesTotal = mapper.readValue(f, new TypeReference<LinkedHashMap<Integer, Cancion>>() {});
        
            // Eliminar el artista del LinkedHashMap
            cancionesTotal.remove(cancion.getId());
        
            // Guardar los datos actualizados en el archivo JSON
            mapper.writeValue(f, cancionesTotal);
        
            System.out.println("Cancion eliminada correctamente del archivo JSON.");
         } 
    catch (IOException e) {
        System.out.println("Error al eliminar la cancion del archivo JSON: " + e.getMessage());
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
