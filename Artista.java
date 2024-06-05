import java.util.LinkedHashSet;

public class Artista {
    String nombreArtistico;
    LinkedHashSet<Cancion> cancionesPropias;

    Artista(String nombreArtistico){
        this.nombreArtistico = nombreArtistico;
    }
    
    @Override
    public String toString() {
        return " Nombre: " + nombreArtistico;
    }
}
