import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.LinkedHashSet;

public class Artista {
    String nombreArtistico;
    LinkedHashSet<Cancion> cancionesPropias;

    public Artista(String nombreArtistico) {
        this.cancionesPropias = new LinkedHashSet<>();
        this.nombreArtistico = nombreArtistico;
    }

    public Artista() {
        this.cancionesPropias = new LinkedHashSet<>();
    }

    public void agregarCancion(Cancion cancion) {
        cancionesPropias.add(cancion);
    }

    @Override
    public String toString() {
        return " Nombre: " + nombreArtistico;
    }

    @JsonManagedReference
    public LinkedHashSet<Cancion> getCancionesPropias() {
        return cancionesPropias;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setCancionesPropias(LinkedHashSet<Cancion> cancionesPropias) {
        this.cancionesPropias = cancionesPropias;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }
}
