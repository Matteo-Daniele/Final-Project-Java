import java.util.TreeSet;

public class Playlist {
    String nombre;
    TreeSet<Cancion> cancionesPlaylist;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.cancionesPlaylist = new TreeSet<>();
    }
    
    public void agregarCancion(Cancion cancion){
        cancionesPlaylist.add(cancion);
        
    }
}
