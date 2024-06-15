import javax.swing.*;
import java.io.File;

public class index {
    public static void main(String[] args) {
        CollectionsCancion canciones = new CollectionsCancion();
        CollectionsPlaylist playlists = new CollectionsPlaylist();

        // CANCIONES CARGA
        Cancion cancion1 = new Cancion(1, "Alas", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion2 = new Cancion(2, "Flechazo en el centro", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion3 = new Cancion(3, "Rockstar", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion4 = new Cancion(4, "RKT Live Set MDQ", "RKT", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion5 = new Cancion(5, "Wow", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");

        Cancion cancion6 = new Cancion(6, "", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion7 = new Cancion(7, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion8 = new Cancion(8, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion9 = new Cancion(9, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion10 = new Cancion(10, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");

        Cancion cancion11 = new Cancion(11, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion12 = new Cancion(12, "Juan", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion13 = new Cancion(13, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion14 = new Cancion(14, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion15 = new Cancion(15, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");

        Cancion cancion16 = new Cancion(16, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion17 = new Cancion(17, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion18 = new Cancion(18, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion19 = new Cancion(19, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");
        Cancion cancion20 = new Cancion(20, " ", "Trap", "audio/Call-Me-Baby.wav", "Media/ACRU.jpg", "Media/...");

        // CREO PLAYLIST
        Playlist playlist1 = new Playlist("Trap", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);

        Playlist playlist2 = new Playlist("Reggaeton", "Media/ACRU.jpg");
        playlist2.agregarCancion(cancion10);
        playlist2.agregarCancion(cancion12);
        playlist2.agregarCancion(cancion13);
        playlist2.agregarCancion(cancion14);
        playlist2.agregarCancion(cancion15);

        Playlist playlist3 = new Playlist("Pop", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        Playlist playlist4 = new Playlist("Regge", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        Playlist playlist5 = new Playlist("Rap", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        Playlist playlist6 = new Playlist("danu", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        Playlist playlist7 = new Playlist("matteo", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        Playlist playlist8 = new Playlist("mati", "Media/ACRU.jpg");
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);

        // AGREGAR PLAYLISTS A LA COLECCION
        playlists.agregarPlaylist(playlist1);
        playlists.agregarPlaylist(playlist2);
        playlists.agregarPlaylist(playlist3);
        playlists.agregarPlaylist(playlist4);
        playlists.agregarPlaylist(playlist5);
        playlists.agregarPlaylist(playlist6);
        playlists.agregarPlaylist(playlist7);
        playlists.agregarPlaylist(playlist8);

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

        canciones.addLikeSong(f, cancion1, playlist1, playlists, f3);
        canciones.modificarArchivo(f, cancion1, "matteo", null, null, null, playlist1, playlists, f3);
        playlists.modificarArchivo(f3, playlist2, "juan");

        SwingUtilities.invokeLater(() -> new PaginaPrincipal(playlists));
    }
}
