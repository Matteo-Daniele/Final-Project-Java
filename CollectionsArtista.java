import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CollectionsArtista {
    LinkedHashMap<String, Artista> artistas;

    CollectionsArtista(){
        artistas = new LinkedHashMap<>();
    }
    
    public void agregarArtista(Artista artistaAgregar){
        artistas.put(artistaAgregar.getNombreArtistico(), artistaAgregar);
    }

    public void cargarArtistasArchivo(File f){
        ObjectMapper mapa = new ObjectMapper();
        mapa.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            mapa.writeValue(f, artistas);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarArtistas(){
        for(Artista aux : artistas.values()){
            System.out.println(aux.toString());
        }
    }

}
