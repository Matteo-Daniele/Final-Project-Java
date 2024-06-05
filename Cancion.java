public class Cancion{
    String nombre;
    String genero;
    String rutaCancion;
    String rutaPortada;
    String rutaMG;
    Boolean MG;

    public Cancion(String nombre, String rutaCancion, String rutaPortada, String rutaMG) {
        this.nombre = nombre;
        this.rutaCancion = rutaCancion;
        this.rutaPortada = rutaPortada;
        this.rutaMG = rutaMG;
        this.MG = false;
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
}