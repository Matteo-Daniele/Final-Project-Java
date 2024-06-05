public class Cancion{
    int id;
    String nombre;
    String genero;
    String rutaCancion;
    String rutaPortada;
    String rutaMG;
    Artista artista;
    Boolean MG;

    CollectionsCancion coleccion = new CollectionsCancion();

    public Cancion(int id, String nombre, String rutaCancion, String rutaPortada, String rutaMG, Artista artista) {
        this.id = id;
        this.nombre = nombre;
        this.rutaCancion = rutaCancion;
        this.rutaPortada = rutaPortada;
        this.rutaMG = rutaMG;
        this.MG = false;
        this.artista = artista;
        coleccion.agregarCanciones(this);
    }    

    public Cancion(){

    }

    public int getId() {
        return id;
    }
    public String getGenero() {
        return genero;
    }
    public Boolean getMG() {
        return MG;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRutaCancion() {
        return rutaCancion;
    }
    public String getRutaMG() {
        return rutaMG;
    }
    public String getRutaPortada() {
        return rutaPortada;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMG(Boolean mG) {
        MG = mG;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }
    public void setRutaMG(String rutaMG) {
        this.rutaMG = rutaMG;
    }
    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public void likeOrDislike(){
        if(MG == false){
            rutaMG = "media/like.png";
            MG = true;
        }
        else{
            rutaMG = "media/dislike.png";
            MG = false;
        }
    }

    @Override
    public String toString(){
        if(artista != null){
            return " Cancion-" + id + " Nombre: " + nombre + " Artista: " + artista.toString();
        }
        else{
            return " Cancion-" + id + " Nombre: " + nombre + " Artista: NULL";
        }
       
    }
}