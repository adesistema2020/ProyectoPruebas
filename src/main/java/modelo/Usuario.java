package modelo;

/**
 * @author AdeS
 */
public class Usuario {

    private int id;
    private String usuario;
    private String password;
    private String apellido;
    private String nombre;
    private int dni;
    private String mail;
    private int legajo;
    private int id_t_nivel;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String password, String apellido, String nombre, int dni, String mail, int legajo, int id_t_nivel) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.mail = mail;
        this.legajo = legajo;
        this.id_t_nivel = id_t_nivel;
    }

    public Usuario(String usuario, String password, String apellido, String nombre, int dni, String mail, int legajo) {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getId_t_nivel() {
        return id_t_nivel;
    }

    public void setId_t_nivel(int id_t_nivel) {
        this.id_t_nivel = id_t_nivel;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", password=" + password + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", mail=" + mail + ", legajo=" + legajo + ", id_t_nivel=" + id_t_nivel + '}';
    }

}
