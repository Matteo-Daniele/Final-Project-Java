import java.io.File;

public class index{
    public static void main(String[] args) {
        CollectionsCancion canciones = new CollectionsCancion();
        CollectionsArtista artistas = new CollectionsArtista();

        // ARTISTAS CARGA
        Artista artista1 = new Artista("Duki");
        Artista artista2 = new Artista("Aniasko");
        Artista artista3 = new Artista("Ysy A");
        Artista artista4 = new Artista("CRO");

        // AGREGAR ARTISTAS A LA COLECCION ARTISTAS
        artistas.agregarArtista(artista1);
        artistas.agregarArtista(artista2);
        artistas.agregarArtista(artista3);
        artistas.agregarArtista(artista4);

        // CANCIONES CARGA
        Cancion cancion1 = new Cancion(1, "Alas", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion2 = new Cancion(2, "Flechazo en el centro", "Audio/...", "Media/...", "Media/...", artista3);
        Cancion cancion3 = new Cancion(3, "Rockstar", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion4 = new Cancion(4, "RKT Live Set MDQ", "Audio/...", "Media/...", "Media/...", artista2);
        Cancion cancion5 = new Cancion(5, "Wow", "Audio/...", "Media/...", "Media/...", artista4);

        // AGREGAR CANCIONES A LA COLECCION CANCIONES
        canciones.agregarCanciones(cancion1);
        canciones.agregarCanciones(cancion2);
        canciones.agregarCanciones(cancion3);
        canciones.agregarCanciones(cancion4);
        canciones.agregarCanciones(cancion5);

        // AGREGAR CANCIONES A LA LISTA DEL ARTISTA
        artista1.agregarCancion(cancion1);
        artista2.agregarCancion(cancion4);
        artista3.agregarCancion(cancion2);
        artista1.agregarCancion(cancion3);
        artista4.agregarCancion(cancion5);

        // CREAR ARCHIVOS
        File f = new File("zCanciones.json");
        File f2 = new File("zArtistas.json");

        // CARGAR CANCIONES Y ARTISTAS A LOS ARCHIVOS
        canciones.cargarCancionesArchivo(f);
        artistas.cargarArtistasArchivo(f2);

        canciones.mostrarCanciones();
        artistas.mostrarArtistas();
    }
}