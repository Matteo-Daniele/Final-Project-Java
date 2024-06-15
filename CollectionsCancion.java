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
    public void borrarCancion(Cancion cancion){
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
    public LinkedHashMap<Integer, Cancion> getCancionesTotal() {
        return cancionesTotal;
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
        
            // Eliminar la cancion del LinkedHashMap
            cancionesTotal.remove(cancion.getId());
        
            // Guardar los datos actualizados en el archivo JSON
            mapper.writeValue(f, cancionesTotal);
        
            System.out.println("Cancion eliminada correctamente del archivo JSON.");
         } 
    catch (IOException e) {
        System.out.println("Error al eliminar la cancion del archivo JSON: " + e.getMessage());
    }
}

public void modificarArchivo(File f, Cancion cancion, String nombre, String genero, String rutaCancion, String rutaPortada, Playlist playlist, CollectionsPlaylist playlists, File fp) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // Leer el archivo JSON y cargar los datos en el LinkedHashMap
        LinkedHashMap<Integer, Cancion> loadedPlaylists = mapper.readValue(f, new TypeReference<LinkedHashMap<Integer, Cancion>>() {});
        
        // Actualizar la playlist en la colección de playlists
        Cancion cancionAModificar = loadedPlaylists.get(cancion.getId());
        if (cancionAModificar != null) {
            if(nombre != null){cancionAModificar.setNombre(nombre);}
            if(genero != null){cancionAModificar.setGenero(genero);}
            if(rutaCancion != null){cancionAModificar.setRutaCancion(rutaCancion);}
            if(rutaPortada != null){cancionAModificar.setRutaPortada(rutaPortada);}
            playlist.eliminarCancion(cancion);
            playlist.agregarCancion(cancionAModificar);
            loadedPlaylists.put(cancionAModificar.getId(), cancionAModificar);
            playlists.cargarArchivo(fp);

        } else {
            System.out.println("La playlist a modificar no se encontró en el archivo JSON.");
            return;
        }
        mapper.writeValue(f, loadedPlaylists);
        
        System.out.println("Playlist modificada correctamente en el archivo JSON.");
    } catch (IOException e) {
        System.out.println("Error al modificar la Playlist: " + e.getMessage());
    }
}

public void mostrarCanciones(File f) {
    ObjectMapper mapper = new ObjectMapper();
    try {
        cancionesTotal = mapper.readValue(f, new TypeReference<LinkedHashMap<Integer, Cancion>>() {});
    } catch (IOException e) {
        System.out.println("No pudieron bajarse las canciones: " + e.getMessage());
    }
    finally{
        for(Cancion aux : cancionesTotal.values()){
            System.out.println(" Canciones: " + aux.getNombre());
    }
    }
}

    public void addLikeSong(File f, Cancion cancion, Playlist playlist, CollectionsPlaylist playlists, File fp) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Leer el archivo JSON y cargar los datos en el LinkedHashMap
            LinkedHashMap<Integer, Cancion> loadedPlaylists = mapper.readValue(f, new TypeReference<LinkedHashMap<Integer, Cancion>>() {});

            // Actualizar la playlist en la colección de playlists
            Cancion cancionAModificar = loadedPlaylists.get(cancion.getId());
            System.out.println(cancion.toString());
            System.out.println(cancionAModificar.toString());
            if (cancionAModificar != null) {
                playlist.eliminarCancion(cancion);
                playlist.agregarCancion(cancionAModificar);
                loadedPlaylists.put(cancionAModificar.getId(), cancionAModificar);
                playlists.agregarPlaylist(playlist);
                playlists.cargarArchivo(fp);
            } 
           
            mapper.writeValue(f, loadedPlaylists);
        } catch (IOException e) {
            System.out.println("Error al dar like a la cancion: " + e.getMessage());
        }
    }
}
