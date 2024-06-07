import java.io.File;
public class index{
    public static void main(String[] args) {
        CollectionsCancion canciones = new CollectionsCancion();
        CollectionsPlaylist playlists = new CollectionsPlaylist();

        // CANCIONES CARGA
        Cancion cancion1 = new Cancion(1, "Alas", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion2 = new Cancion(2, "Flechazo en el centro","Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion3 = new Cancion(3, "Rockstar", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion4 = new Cancion(4, "RKT Live Set MDQ", "RKT",  "Audio/...", "Media/...", "Media/...");
        Cancion cancion5 = new Cancion(5, "Wow", "Trap", "Audio/...", "Media/...", "Media/...");
        
        Cancion cancion6 = new Cancion(6, "", "Trap", "Audio/", "Media/...", "Media/...");
        Cancion cancion7 = new Cancion(7, " ", "Trap",  "Audio/...", "Media/...", "Media/...");
        Cancion cancion8 = new Cancion(8, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion9 = new Cancion(9, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion10 = new Cancion(10, " ", "Trap",  "Audio/...", "Media/...", "Media/...");

        Cancion cancion11 = new Cancion(11, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion12 = new Cancion(12, "Juan", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion13 = new Cancion(13, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion14 = new Cancion(14, " ","Trap",  "Audio/...", "Media/...", "Media/...");
        Cancion cancion15 = new Cancion(15, " ", "Trap", "Audio/...", "Media/...", "Media/...");

        Cancion cancion16 = new Cancion(16, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion17 = new Cancion(17, " ","Trap",  "Audio/...", "Media/...", "Media/...");
        Cancion cancion18 = new Cancion(18, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion19 = new Cancion(19, " ", "Trap", "Audio/...", "Media/...", "Media/...");
        Cancion cancion20 = new Cancion(20, " ", "Trap", "Audio/...", "Media/...", "Media/...");

        // CREO PLAYLIST
    
        Playlist playlist1 = new Playlist("Trap");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);

        Playlist playlist2 = new Playlist("Reggaeton");
        playlist2.agregarCancion(cancion10);
        playlist2.agregarCancion(cancion12);
        playlist2.agregarCancion(cancion13);
        playlist2.agregarCancion(cancion14);
        playlist2.agregarCancion(cancion15);
        
        // AGREGAR PLAYLISTS A LA COLECCION
        playlists.agregarPlaylist(playlist1);
        playlists.agregarPlaylist(playlist2);

        // AGREGAR CANCIONES A LA COLECCION CANCIONES
        canciones.agregarCanciones(cancion1); 
        canciones.agregarCanciones(cancion2); 
        canciones.agregarCanciones(cancion3); 
        canciones.agregarCanciones(cancion4); 
        canciones.agregarCanciones(cancion5); 
        canciones.agregarCanciones(cancion6); 
        canciones.agregarCanciones(cancion7); 
        canciones.agregarCanciones(cancion8); 
        canciones.agregarCanciones(cancion9); 
        canciones.agregarCanciones(cancion10); 
        canciones.agregarCanciones(cancion11); 
        canciones.agregarCanciones(cancion12); 
        canciones.agregarCanciones(cancion13); 
        canciones.agregarCanciones(cancion14); 
        canciones.agregarCanciones(cancion15); 
        canciones.agregarCanciones(cancion16); 
        canciones.agregarCanciones(cancion17); 
        canciones.agregarCanciones(cancion18); 
        canciones.agregarCanciones(cancion19); 
        canciones.agregarCanciones(cancion20);

        // CREAR ARCHIVOS
        File f = new File("zCanciones.json");
        File f3 = new File("zplaylists.json");

        // CARGAR CANCIONES, PLAYLIST Y ARTISTAS A LOS ARCHIVOS
        canciones.cargarArchivo(f);
        playlists.cargarArchivo(f3);

        canciones.modificarArchivo(f, cancion1, "TEMIN", null, null, null, playlist1, playlists, f3);

        playlists.modificarArchivo(f3, playlist2, "juan");

        canciones.mostrarCanciones(f);
        playlists.mostrarPlaylist(f3);
    }

}