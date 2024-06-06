import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsArtista implements Cargable{
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

    public void mostrarArtistas(){
        for(Artista aux : artistas.values()){
            System.out.println(aux.toString());
        }
    }

}
