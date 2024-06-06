import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsArtista implements Cargable <Artista>{
    LinkedHashMap<String, Artista> artistas;

    CollectionsArtista(){
        artistas = new LinkedHashMap<>();
    }

    public void agregarArtista(Artista artistaAgregar){
        artistas.put(artistaAgregar.getNombreArtistico(), artistaAgregar);
    }

    @Override
    public void cargarArchivo(File f){
        ObjectMapper mapa = new ObjectMapper();
        mapa.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            mapa.writeValue(f, artistas);
        }
        catch(IOException e){
            System.out.println("Error al cargar los datos Al archivo JSON: " + e.getMessage());
        }
    }

    @Override
    public void bajarArchivo(File f){
        ObjectMapper mapper = new ObjectMapper();
        try {
            artistas = mapper.readValue(f, new TypeReference<LinkedHashMap<String, Artista>>() {});
            System.out.println("Datos cargados correctamente desde el archivo JSON.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo JSON: " + e.getMessage());
        }
    }

    @Override
    public void borrarObjeto(File f, Artista artista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            // Cargar los datos del archivo JSON en el LinkedHashMap
            artistas = mapper.readValue(f, new TypeReference<LinkedHashMap<String, Artista>>() {});
        
            // Eliminar el artista del LinkedHashMap
            artistas.remove(artista.getNombreArtistico());
        
            // Guardar los datos actualizados en el archivo JSON
            mapper.writeValue(f, artistas);
        
            System.out.println("Artista eliminado correctamente del archivo JSON.");
         } 
    catch (IOException e) {
        System.out.println("Error al eliminar el artista del archivo JSON: " + e.getMessage());
    }
}
    public void mostrarArtistas(){
        for(Artista aux : artistas.values()){
            System.out.println(aux.toString());
        }
    }

}
