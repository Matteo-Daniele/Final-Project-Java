import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class CollectionsPlaylist implements Cargable<Playlist> {
    LinkedHashMap<String, Playlist> playlists;

    public CollectionsPlaylist() {
        this.playlists = new LinkedHashMap<>();
    }

    public void agregarPlaylist(Playlist playlist) {
        playlists.put(playlist.getNombre(), playlist);
    }

    public void mostrarPlaylist(File f) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            playlists = mapper.readValue(f, new TypeReference<LinkedHashMap<String, Playlist>>() {});
        } catch (IOException e) {
            System.out.println("No pudieron bajarse las Playlist: " + e.getMessage());
        }
        finally{
            for(Playlist aux : playlists.values()){
                System.out.println(" Playlist: " + aux.getNombre());
        }
        }
        
    }

    public LinkedHashMap<String, Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(LinkedHashMap<String, Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public void cargarArchivo(File f) {
        ObjectMapper mapa = new ObjectMapper();
        mapa.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapa.writeValue(f, playlists);
        } catch (IOException e) {
            System.out.println("No pudieron cargarse las Playlist: " + e.getMessage());
        }
    }

    @Override
    public void bajarArchivo(File f) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            playlists = mapper.readValue(f, new TypeReference<LinkedHashMap<String, Playlist>>() {
            });
        } catch (IOException e) {
            System.out.println("No pudieron bajarse las Playlist: " + e.getMessage());
        }
    }

    @Override
    public void borrarObjeto(File f, Playlist playlist) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            // Cargar los datos del archivo JSON en el LinkedHashMap
            this.playlists = mapper.readValue(f, new TypeReference<LinkedHashMap<String, Playlist>>() {});
        
            // Eliminar la cancion del LinkedHashMap
            this.playlists.remove(playlist.getNombre());
        
            // Guardar los datos actualizados en el archivo JSON
            mapper.writeValue(f, this.playlists);
        
            System.out.println("Cancion eliminada correctamente del archivo JSON.");
         } 
    catch (IOException e) {
        System.out.println("Error al eliminar la cancion del archivo JSON: " + e.getMessage());
    }
}

public void modificarArchivo(File f, Playlist playlist, String nombre) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // Leer el archivo JSON y cargar los datos en el LinkedHashMap
        LinkedHashMap<String, Playlist> loadedPlaylists = mapper.readValue(f, new TypeReference<LinkedHashMap<String, Playlist>>() {});
        System.out.println(loadedPlaylists.toString());
        // Obtener la playlist a modificar
        Playlist playlistToUpdate = loadedPlaylists.get(playlist.getNombre());
        System.out.println(playlistToUpdate.toString());
        if (playlistToUpdate != null) {
            // Actualizar el nombre de la playlist
            playlistToUpdate.setNombre(nombre);
            // Remover la playlist anterior del mapa
            loadedPlaylists.remove(playlist.getNombre());
            // Agregar la playlist actualizada al mapa
            System.out.println(playlistToUpdate.toString());
            loadedPlaylists.put(nombre, playlistToUpdate);
            System.out.println(loadedPlaylists.toString());
            mapper.writeValue(f, loadedPlaylists);
            System.out.println("Playlist modificada correctamente en el archivo JSON.");
        }
    } 
    catch (IOException e) {
        System.out.println("Error al modificar la Playlist: " + e.getMessage());
    }
    
}
} 

