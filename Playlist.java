
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
    
    public void eliminarCancion(Cancion cancion){
        try{
            if(cancionesPlaylist.remove(cancion)){
                System.out.println("La cancion se elimino correctamente");
            }
            else{
                System.out.println("La cancion no se encuentra en la Playlist");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
}
