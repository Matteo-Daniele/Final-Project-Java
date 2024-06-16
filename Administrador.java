public class Administrador extends Persona{
    private String username;
    private String password;

    public Administrador() {
        nombre="Guillermo";
        apellido="Gimenez";
        username= "guille";
        password="123";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
