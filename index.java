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
        Artista artista5 = new Artista("Acru");
        Artista artista6 = new Artista("Trueno");
        Artista artista7 = new Artista("David Bisbal");
        Artista artista8 = new Artista("Valeria Lynch");
        Artista artista9 = new Artista("Queen");
        Artista artista10 = new Artista("Eladio Carrion");
        Artista artista11 = new Artista("Dei V");
        Artista artista12 = new Artista("Green Day");

        // AGREGAR ARTISTAS A LA COLECCION ARTISTAS
        artistas.agregarArtista(artista1);
        artistas.agregarArtista(artista2);
        artistas.agregarArtista(artista3);
        artistas.agregarArtista(artista4);
        artistas.agregarArtista(artista5);
        artistas.agregarArtista(artista6);
        artistas.agregarArtista(artista7);
        artistas.agregarArtista(artista8);
        artistas.agregarArtista(artista9);
        artistas.agregarArtista(artista10);
        artistas.agregarArtista(artista11);
        artistas.agregarArtista(artista12);

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
        canciones.cargarArchivo(f);
        artistas.cargarArchivo(f2);

        canciones.mostrarCanciones();
        artistas.mostrarArtistas();
    }
}