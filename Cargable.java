import java.io.File;

public interface Cargable <T>{
    void cargarArchivo(File f);
    void bajarArchivo(File f);
    void borrarObjeto(File f , T objeto);
}
