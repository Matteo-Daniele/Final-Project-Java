import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsPlaylist implements Cargable<Playlist>{
    ArrayList<Playlist> playlists;

    CollectionsPlaylist(){
        this.playlists = new ArrayList<>();
    }
    public void agregarPlaylist(Playlist playlist){
        playlists.add(playlist);
    }

    public void mostrarPlaylist(){
        for(Playlist aux : playlists){
            System.out.println(aux.toString());
        }
    }
    @Override
    public void cargarArchivo(File f){
        ObjectMapper mapa = new ObjectMapper();
        mapa.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapa.writeValue(f, playlists);
        } catch (IOException e) {
            System.out.println("No pudieron cargarse las Playlist: " + e.getMessage());
        }
    }

    @Override
    public void bajarArchivo(File f){
        ObjectMapper mapper = new ObjectMapper();
        try {
            playlists = mapper.readValue(f, new TypeReference<ArrayList<Playlist>>(){});
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
            playlists = mapper.readValue(f, new TypeReference<ArrayList<Playlist>>(){});
            // Eliminar la playlist del arraylist
            playlists.remove(playlist);
        
            // Guardar los datos actualizados en el archivo JSON
            mapper.writeValue(f, playlists);
        
            System.out.println("Playlist eliminada correctamente del archivo JSON.");
         } 
    catch (IOException e) {
        System.out.println("Error al eliminar la playlist del archivo JSON: " + e.getMessage());
    }
}

}
