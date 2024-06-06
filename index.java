import java.io.File;

public class index{
    public static void main(String[] args) {
        CollectionsCancion canciones = new CollectionsCancion();
        CollectionsArtista artistas = new CollectionsArtista();

        // CREAR ARTISTAS
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
        
        Cancion cancion6 = new Cancion(6, "", "Audio/", "Media/...", "Media/...", artista1);
        Cancion cancion7 = new Cancion(7, " ", "Audio/...", "Media/...", "Media/...", artista3);
        Cancion cancion8 = new Cancion(8, " ", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion9 = new Cancion(9, " ", "Audio/...", "Media/...", "Media/...", artista2);
        Cancion cancion10 = new Cancion(10, " ", "Audio/...", "Media/...", "Media/...", artista4);

        Cancion cancion11 = new Cancion(11, " ", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion12 = new Cancion(12, " ", "Audio/...", "Media/...", "Media/...", artista3);
        Cancion cancion13 = new Cancion(13, " ", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion14 = new Cancion(14, " ", "Audio/...", "Media/...", "Media/...", artista2);
        Cancion cancion15 = new Cancion(15, " ", "Audio/...", "Media/...", "Media/...", artista4);

        Cancion cancion16 = new Cancion(16, " ", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion17 = new Cancion(17, " ", "Audio/...", "Media/...", "Media/...", artista3);
        Cancion cancion18 = new Cancion(18, " ", "Audio/...", "Media/...", "Media/...", artista1);
        Cancion cancion19 = new Cancion(19, " ", "Audio/...", "Media/...", "Media/...", artista2);
        Cancion cancion20 = new Cancion(20, " ", "Audio/...", "Media/...", "Media/...", artista4);



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
        File f2 = new File("zArtistas.json");


        cargarListaDeArtistas(artistas, canciones);
        // CARGAR CANCIONES Y ARTISTAS A LOS ARCHIVOS
        canciones.cargarArchivo(f);
        artistas.cargarArchivo(f2);

        canciones.mostrarCanciones();
        artistas.mostrarArtistas();
        artistas.borrarObjeto(f2, artista10);
        canciones.borrarObjeto(f, cancion1);
    }

    public static void cargarListaDeArtistas(CollectionsArtista artistas, CollectionsCancion canciones){
        for(Artista artista : artistas.getArtistas().values()){
            for(Cancion cancion : canciones.getCancionesTotal().values()){
                if(cancion.getArtista().equals(artista)){
                    artista.agregarCancion(cancion);
                }
            }
        }
    }

}