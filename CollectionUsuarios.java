import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class CollectionUsuarios {
    private TreeMap<String, Usuario> usuarios;

    public CollectionUsuarios() {
        usuarios = new TreeMap<>();
    }

    public String registrarUsuario(File archivo, Scanner teclado) {
        boolean nicknameValido = false;
        boolean emailValido = false;
        leerArchivo(archivo);
        System.out.println("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese su apellido: ");                     //Leo el archivo de usuarios (en caso de existir) y lo cargo en nuestro treemap para registrar en base a
        String apellido = teclado.nextLine();                                 //el nickname de cada uno y luego lo subo linea por linea al archivo
        String email = "";
        while (!emailValido) {
            try {
                System.out.println("Ingrese un mail valido (gmail o hotmail)");
                email = teclado.nextLine();
                if (!email.endsWith("@gmail.com") && !email.endsWith("@hotmail.com")) {
                    throw new ExcepcionDatos("Mail no valido");
                } else {
                    emailValido = true;
                }

            } catch (ExcepcionDatos e) {
                System.out.println(e.getMessage());
            }
        }
        String nickname = " ";
        if (usuarios.isEmpty()) {
            System.out.println("Ingrese su nickname: ");
            nickname = teclado.nextLine();
        } else {
            while (!nicknameValido) {
                try {
                    System.out.println("Ingrese su nickname: ");
                    nickname = teclado.nextLine();
                    if (usuarios.containsKey(nickname)) {
                        throw new ExcepcionDatos("El nickname " + nickname + " ya se encuentra en uso");
                    } else
                        nicknameValido = true;
                } catch (ExcepcionDatos e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Ingrese su contraseña: ");
        String password = teclado.nextLine();
        System.out.println("Confirme su contraseña: ");
        String confirmacion = teclado.next();
        while (!confirmacion.equals(password)) {
            System.out.println("La contraseñas son distintas, ingresela de nuevo: ");
            confirmacion = teclado.nextLine();
        }
        Usuario nuevo = new Usuario(nombre, apellido, nickname, password, email);
        escribirArchivo(archivo, nuevo);
        return nickname;

    }
    public boolean comprobarNickname(String nickname)
    {
        if(usuarios.containsKey(nickname))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Usuario devolverUsuario(String nickname)
    {
        return usuarios.get(nickname);
    }

    public void escribirArchivo(File archivo, Usuario usuario) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter fileWriter = new FileWriter(archivo, true)) {

            PrintWriter printWriter = new PrintWriter(fileWriter);
            String usuarioAEscribir = objectMapper.writeValueAsString(usuario);            //Escribo cada usuario al final del archivo
            printWriter.println(usuarioAEscribir);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Usuario leerArchivo(File archivo) {
        Usuario usuario = new Usuario();
        ObjectMapper mapper = new ObjectMapper();
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {                               //Leo el archivo linea por linea y lo subo a nuestro treemap
                    usuario = mapper.readValue(linea, Usuario.class);
                    System.out.println(usuario);
                    usuarios.put(usuario.getNickname(), usuario);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe");
        }

        return usuario;
    }

    public TreeMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public String cambiarNombre(File archivo, String nickname, Scanner teclado) {
        Usuario usuario = usuarios.get(nickname);
        System.out.println("Ingrese su contraseña: ");
        String contraseña = teclado.nextLine();
        while (!contraseña.equals(usuario.getContrasenia())) {
            System.out.println("Contraseña incorrecta");
            contraseña = teclado.nextLine();
        }
        System.out.println("Ingrese su nuevo nickname, recuerde que el actual es: " + nickname);
        String newNickname = teclado.nextLine();
        while (usuarios.containsKey(newNickname)) {
            System.out.println("Ese nickname esta ocupado, ingrese otro: ");
            newNickname = teclado.nextLine();
        }
        ArrayList<Usuario> arrayACargar = cambiarTreeMap(newNickname, nickname, " ", true);
        reescribirArchivoLinea(archivo, arrayACargar);
        return newNickname;

    }

    public ArrayList<Usuario> cambiarTreeMap(String newNickame, String oldNickname, String newPassword, boolean cambiarNickname) {
        Usuario usuario = usuarios.get(oldNickname);
        usuarios.remove(oldNickname);
        if (cambiarNickname) {
            usuario.setNickname(newNickame);
        } else {
            usuario.setContrasenia(newPassword);
        }
        usuarios.put(usuario.getNickname(), usuario);
        return new ArrayList<>(usuarios.values());
    }

    public void reescribirArchivoLinea(File archivo, ArrayList<Usuario> usuariosArchivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter fileWriter = new FileWriter(archivo, false)) {

            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Usuario usuario : usuariosArchivo) {
                System.out.println(usuario.toString());
                String usuarioAEscribir = objectMapper.writeValueAsString(usuario);            //Escribo cada usuario al final del archivo
                printWriter.println(usuarioAEscribir);
            }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solicitarContraseña(Usuario usuario) {
        boolean contraseñaCorrecta = false;
        Scanner teclado = new Scanner(System.in);
        while (!contraseñaCorrecta) {
            try {
                System.out.println("Ingrese su contraseña: ");
                String contraseña = teclado.next();
                if (!contraseña.equals(usuario.getContrasenia())) {
                    throw new ExcepcionDatos("Contraseña incorrecta");   //Funcion hecha para quitar problemas de buffer
                } else {
                    contraseñaCorrecta = true;
                }
            } catch (ExcepcionDatos e) {
                System.out.println(e.getMessage());
            }

        }
        teclado.close();

    }

    public String cambiarContraseña(File archivo, Scanner teclado, String nickname) {
        Usuario usuario = usuarios.get(nickname);
        System.out.println("Primero para cambiar su contraseña necesitamos unos datos: ");
        solicitarContraseña(usuario);
        System.out.println("Ingrese su nueva contraseña: ");
        String newPassword = teclado.next();
        System.out.println("Confirme su contraseña: ");
        String confirmate = teclado.next();
        while (!confirmate.equals(newPassword)) {
            System.out.println("Las contraseñas son distintas: ");
            confirmate = teclado.next();
        }
        ArrayList<Usuario> aEscribir = cambiarTreeMap("", nickname, newPassword, false);
        reescribirArchivoLinea(archivo, aEscribir);
        return nickname;
    }
    public String cambiarEstado(String nickname, File archivo)
    {
        Usuario usuario=usuarios.get(nickname);
        Scanner teclado=new Scanner(System.in);
        System.out.println("Para cambiar su estado, necesitamos un dato: ");
        solicitarContraseña(usuario);
        if(usuario.isActivo())
        {
            System.out.println("Esta seguro que desea darse de baja?");
            String opcion= teclado.next();
            if(opcion.equalsIgnoreCase("Si"))
            {
                usuario.setActivo(false);
            }
        }
        else
        {
            System.out.println("Esta seguro que desea darse de alta?");
            String opcion= teclado.next();
            if(opcion.equalsIgnoreCase("Si"))
            {
                usuario.setActivo(true);
            }
        }
        teclado.close();
        usuarios.remove(usuario.getNickname());
        usuarios.put(usuario.getNickname(),usuario);
        ArrayList<Usuario> aReescribir=new ArrayList<>(usuarios.values());
        reescribirArchivoLinea(archivo,aReescribir);
        return nickname;
    }
}








